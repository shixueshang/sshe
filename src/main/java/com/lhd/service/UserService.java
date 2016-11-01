package com.lhd.service;


import com.lhd.bean.User;
import com.lhd.commons.page.Page;

public interface UserService {

	Page<User> findPageUsers(int page, int size);

	void insert(User user);
	
	void delete(Integer userId);

	User findUserByLoginName(String loginName);
}
