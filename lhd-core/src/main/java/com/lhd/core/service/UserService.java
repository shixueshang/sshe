package com.lhd.core.service;


import com.lhd.core.bean.User;
import com.lhd.core.page.Page;

import java.util.List;

public interface UserService {

	Page<User> findPageUsers(int page, int size);

	void saveOrUpdate(User user);
	
	void delete(Integer userId);

	User findUserByLoginName(String loginName);

    User getUser(Integer userId);

    void addUserRole(Integer userId, List<Integer> roleIds);

}
