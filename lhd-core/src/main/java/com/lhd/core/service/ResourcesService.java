package com.lhd.core.service;

import com.lhd.core.bean.Resources;

import java.util.List;

/**
 * Created by lihongde on 2016/10/31 10:52.
 */
public interface ResourcesService {

    List<Resources> findAllResources();

    List<Resources> findResourcesByRoleId(Integer roleId);
}
