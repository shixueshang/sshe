package com.lhd.core.service;

import com.lhd.core.bean.Dictionary;
import com.lhd.core.enums.DictType;

import java.util.List;

/**
 * Created by lihongde on 2016/11/10 16:13.
 */
public interface DictionaryService {

    List<Dictionary> findDictByType(DictType dictType);
}
