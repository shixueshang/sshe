package com.lhd;

import com.lhd.bean.Dictionary;
import com.lhd.commons.enums.DictType;
import com.lhd.context.Base;
import com.lhd.service.DictionaryService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lihongde on 2016/11/10 16:31.
 */
public class TestDictionary extends Base {

    @Resource
    private DictionaryService dictionaryService;

    @Test
    public void findDictByType(){
       List<Dictionary> list = dictionaryService.findDictByType(DictType.PASSPORT);
        list.forEach(l-> logger.info("key : " + l.getKey() + "  value : " + l.getValue()));
    }
}
