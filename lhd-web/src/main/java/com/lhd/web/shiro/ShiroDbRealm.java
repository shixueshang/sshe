package com.lhd.web.shiro;


import com.lhd.core.bean.Resources;
import com.lhd.core.bean.User;
import com.lhd.core.bean.UserRole;
import com.lhd.core.service.ResourcesService;
import com.lhd.core.service.RoleService;
import com.lhd.core.service.UserService;
import com.lhd.core.util.Constants;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * shiro权限认证
 */
public class ShiroDbRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private ResourcesService resourcesService;


    /**
     * 获取身份验证相关信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;

        User user  = userService.findUserByLoginName(token.getUsername());
        if(user == null){
            throw new UnknownAccountException();// 账号不存在
        }

        if(!user.isValid()){
            throw new UnknownAccountException(); //帐号已失效
        }

        // 认证缓存信息
        return new SimpleAuthenticationInfo(user, user.getPassword().toCharArray(), getName());

    }

    /**
     * 获取授权信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        User shiroUser = (User) principals.getPrimaryPrincipal();
        Set<String> urlSet = new HashSet<String>();
        //获得登陆人员的权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<Resources> resourcesList = new ArrayList<Resources>();
        if(shiroUser.getLoginName().equals(Constants.ADMIN_USER)){
            resourcesList = resourcesService.findAllResources();
        }else{
            List<UserRole> userRoles = roleService.findRolesByUserId(shiroUser.getId());
            for(UserRole userRole : userRoles){
                resourcesList = resourcesService.findResourcesByRoleId(userRole.getRoleId());
            }
        }

        urlSet.addAll(resourcesList.stream().map(Resources::getUrl).collect(Collectors.toList()));

        info.addStringPermissions(urlSet);
        return info;
    }
}
