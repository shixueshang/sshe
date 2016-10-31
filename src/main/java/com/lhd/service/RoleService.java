package com.lhd.service;

import com.lhd.bean.Role;
import com.lhd.bean.UserRole;
import com.lhd.commons.page.Page;

import java.util.List;

/**
 * Created by lihongde on 2016/10/31 10:56.
 */
public interface RoleService {

    Page<Role> findPageRoles(int page, int size);

    void addRole(Role role);

    Role getRole(Integer roleId);

    List<UserRole> findRolesByUserId(Integer userId);
}
