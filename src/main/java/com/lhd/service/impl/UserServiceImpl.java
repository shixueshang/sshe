package com.lhd.service.impl;


import com.lhd.commons.page.Page;
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
		dao.remove(dao.get(User.class, userId));
	}

	@Override
	public User findUserByLoginName(String loginName) {
		return dao.findUnique("from User where loginName = ?", loginName);
	}

}
