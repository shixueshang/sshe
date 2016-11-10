package com.lhd.service;

import com.lhd.bean.Dictionary;
import com.lhd.commons.enums.DictType;

import java.util.List;

/**
 * Created by lihongde on 2016/11/10 16:13.
 */
public interface DictionaryService {

    List<Dictionary> findDictByType(DictType dictType);
}
