package com.lhd.service.impl;

import com.lhd.bean.Resources;
import com.lhd.dao.HibernateDao;
import com.lhd.service.ResourcesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lihongde on 2016/10/31 11:34.
 */
@Service
@Transactional
public class ResourcesServiceImpl implements ResourcesService {

    @Resource
    private HibernateDao dao;

    @Override
    public List<Resources> findAllResources() {
        return dao.find("from Resources");
    }

    @Override
    public List<Resources> findResourcesByRoleId(Integer roleId) {
        return dao.find("from Resources where roleId = ?", roleId);
    }
}
