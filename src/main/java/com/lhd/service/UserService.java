package com.lhd.service;


import com.lhd.bean.User;
import com.lhd.commons.page.Page;

import java.util.List;

public interface UserService {

	Page<User> findPageUsers(int page, int size);

	void saveOrUpdate(User user);
	
	void delete(Integer userId);

	User findUserByLoginName(String loginName);

    User getUser(Integer userId);

    void addUserRole(Integer userId, List<Integer> roleIds);

}
