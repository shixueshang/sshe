package com.lhd.service.impl;

import com.lhd.bean.Dictionary;
import com.lhd.commons.enums.DictType;
import com.lhd.dao.HibernateDao;
import com.lhd.service.DictionaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 缓存字典数据
 * Created by lihongde on 2016/11/10 16:14.
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Resource
    private HibernateDao dao;


    private Map<DictType, List<Dictionary>> dictCache = new ConcurrentHashMap<DictType, List<Dictionary>>();

    @Override
    public List<Dictionary> findDictByType(DictType dictType) {
        if(dictType == null){
            return null;
        }

        List<Dictionary> result = this.getFromCache(dictType);
        if(result == null){
            result = dao.find("from Dictionary where cat = ? and isValid = ?", dictType.toString(),  true);
        }
        if(!result.isEmpty()){
            this.putToCache(dictType, result);
        }

        return result;
    }

    private List<Dictionary> getFromCache(DictType dictType) {
        return dictCache.get(dictType);
    }

    private void putToCache(DictType dictType, List<Dictionary> list) {
        List<Dictionary> mapList = dictCache.get(dictType);
        if(mapList == null){
            dictCache.put(dictType, list);
        }
    }
}
