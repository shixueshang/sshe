package com.lhd.core.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.transform.ResultTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheableTransformerFactory
{


    static Map<String, ResultTransformer> transformers = new HashMap();

    public static ResultTransformer createForSql(String sql) {
        ResultTransformer ret = (ResultTransformer)transformers.get(sql);
        if (ret == null) {
            ret = new AliasResultTransformer(sql);
            transformers.put(sql, ret);
        }
        return ret;
    }
    static class AliasResultTransformer implements ResultTransformer {

        Logger logger = LoggerFactory.getLogger(AliasResultTransformer.class);
        private static final long serialVersionUID = 1L;
        private String[] aliases;
        private boolean badSql4UsingSqlAias;

        AliasResultTransformer(String sql) {
            this.aliases = SqlAlias.bySelect(sql);
        }

        public List transformList(List list)
        {
            return list;
        }

        public Object transformTuple(Object[] tuple, String[] aliases)
        {
            if (!this.badSql4UsingSqlAias) {
                if ((tuple.length == this.aliases.length) || ((tuple.length == this.aliases.length + 1) &&
                        (aliases[(aliases.length - 1)].equalsIgnoreCase("ROWNUM_")))) {
                    aliases = this.aliases;
                } else {
                    this.badSql4UsingSqlAias = true;
                    this.logger.warn("Bad Sql for using com.lhd.dao.SqlAlias! Using returned aliase instead.");
                }
            }
            Map map = new HashMap(aliases.length);
            for (int i = 0; i < aliases.length; i++) {
                if (aliases[i] != null) {
                    map.put(aliases[i], tuple[i]);
                }
            }
            return map;
        }

    }
}