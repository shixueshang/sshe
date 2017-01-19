package com.lhd.core.service;

import com.lhd.core.bean.Role;
import com.lhd.core.bean.UserRole;
import com.lhd.core.page.Page;

import java.util.List;

/**
 * Created by lihongde on 2016/10/31 10:56.
 */
public interface RoleService {

    Page<Role> findPageRoles(int page, int size);

    void saveOrUpdate(Role role);

    Role getRole(Integer roleId);

    List<UserRole> findRolesByUserId(Integer userId);

    List<Role> findAllRoles();
}
