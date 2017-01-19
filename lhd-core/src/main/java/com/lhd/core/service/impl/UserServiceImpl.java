package com.lhd.core.service.impl;


import com.lhd.core.bean.UserRole;
import com.lhd.core.page.Page;
import com.lhd.core.dao.HibernateDao;
import org.springframework.stereotype.Service;

import com.lhd.core.bean.User;
import com.lhd.core.service.UserService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	private HibernateDao dao;

	@Override
	public Page<User> findPageUsers(int page, int size) {
		return dao.findPage("from User", page, size);
	}

	@Override
	public void saveOrUpdate(User user) {
		dao.save(user);
	}

	@Override
	public void delete(Integer userId) {
		dao.update("update User set isValid = false where userId = ?", userId);
	}

	@Override
	public User findUserByLoginName(String loginName) {
		return dao.findUnique("from User where loginName = ?", loginName);
	}

    @Override
    public User getUser(Integer userId) {
        User user = dao.get(User.class, userId);
        List<UserRole> userRoles = dao.find("from UserRole where userId = ?", userId);
        List<Integer> roleIds = userRoles.stream().map(UserRole::getRoleId).collect(Collectors.toList());
        user.setRoleIds(roleIds);
        return user;
    }

    @Override
    public void addUserRole(Integer userId, List<Integer> roleIds) {
        dao.update("delete from UserRole where userId = ?", userId);
        for(Integer roleId : roleIds){
            UserRole ur = new UserRole();
            ur.setUserId(userId);
            ur.setRoleId(roleId);
            dao.save(ur);
        }
    }

}
