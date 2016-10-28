package com.lhd.service.impl;


import com.lhd.dao.HibernateDao;
import org.springframework.stereotype.Service;

import com.lhd.bean.User;
import com.lhd.service.UserService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private HibernateDao userDao;

	public void insert(User user) {
		userDao.save(user);
	}

	public void delete(Integer userId) {
		userDao.remove(userDao.get(User.class, userId));
	}

}
