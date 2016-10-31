package com.lhd.commons.shiro;


import com.lhd.bean.Resources;
import com.lhd.bean.Role;
import com.lhd.bean.User;
import com.lhd.bean.UserRole;
import com.lhd.service.ResourcesService;
import com.lhd.service.RoleService;
import com.lhd.service.UserService;
import com.lhd.util.Constants;
import org.apache.commons.lang.StringUtils;
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
     * Shiro登录认证(原理：用户提交 用户名和密码  --- shiro 封装令牌 ---- realm 通过用户名将密码查询返回 ---- shiro 自动去比较查询出密码和用户输入密码是否一致---- 进行登陆控制 )
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        // 账号不存在
        User user  = userService.findUserByLoginName(token.getUsername());
        if(user == null){
            return null;
        }

        // 认证缓存信息
        return new SimpleAuthenticationInfo(user, user.getPassword().toCharArray(), getName());

    }

    /**
     * Shiro权限认证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        User shiroUser = (User) principals.getPrimaryPrincipal();
        Set<String> urlSet = new HashSet<String>();
        //获得登陆人员的权限
        List<Resources> resourcesList = new ArrayList<Resources>();
        if(shiroUser.getLoginName().equals(Constants.ADMIN_USER)){
            resourcesList = resourcesService.findAllResources();
        }else{
           List<UserRole> userRoles = roleService.findRolesByUserId(shiroUser.getId());
            for(UserRole userRole : userRoles){
                 resourcesList = resourcesService.findResourcesByRoleId(userRole.getRoleId());
            }
        }

        for(Resources resource : resourcesList){
            urlSet.add(resource.getUrl());
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(urlSet);
        return info;
    }
}
