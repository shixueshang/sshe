package com.lhd.service.impl;


import com.lhd.dao.HibernateDao;
import org.springframework.stereotype.Service;

import com.lhd.bean.User;
import com.lhd.service.UserService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	private HibernateDao userDao;

	@Override
	public void insert(User user) {
		userDao.save(user);
	}

	@Override
	public void delete(Integer userId) {
		userDao.remove(userDao.get(User.class, userId));
	}

	@Override
	public User findUserByLoginName(String loginName) {
		return userDao.findUnique("from User where loginName = ?", loginName);
	}

}
