package com.lhd.service.impl;

import com.lhd.bean.Role;
import com.lhd.bean.UserRole;
import com.lhd.commons.page.Page;
import com.lhd.dao.HibernateDao;
import com.lhd.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lihongde on 2016/10/31 13:30.
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Resource
    private HibernateDao dao;

    @Override
    public Page<Role> findPageRoles(int page, int size) {
        return dao.findPage("from Role ", page, size);
    }

    @Override
    public void addRole(Role role) {
        dao.save(role);
    }

    @Override
    public Role getRole(Integer roleId) {
        return dao.get(Role.class, roleId);
    }

    @Override
    public List<UserRole> findRolesByUserId(Integer userId) {
        return dao.find("from UserRole where userId = ?", userId);
    }
}