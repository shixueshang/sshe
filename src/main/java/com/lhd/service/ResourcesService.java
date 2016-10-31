package com.lhd.service;

import com.lhd.bean.Resources;

import java.util.List;

/**
 * Created by lihongde on 2016/10/31 10:52.
 */
public interface ResourcesService {

    List<Resources> findAllResources();

    List<Resources> findResourcesByRoleId(Integer roleId);
}
