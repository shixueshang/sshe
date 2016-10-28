package com.lhd.service;


import com.lhd.bean.User;

public interface UserService {

	void insert(User user);
	
	void delete(Integer userId);
}
