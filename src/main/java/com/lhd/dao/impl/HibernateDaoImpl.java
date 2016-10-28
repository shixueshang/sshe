package com.lhd.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Resource;

import com.lhd.commons.page.Page;
import com.lhd.dao.CacheableTransformerFactory;
import com.lhd.dao.HibernateDao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;

@Component
public class HibernateDaoImpl implements HibernateDao {
    private static final Pattern ORDER = Pattern.compile(" order +by +.*$", 2);
    private static final Pattern SELECT = Pattern.compile("^(\\s*select\\s*){0,1}(.+?)\\s+from",
            2);

    private static final Pattern FETCH = Pattern.compile(" fetch ", 2);
    private static final Pattern PLACE_HOLDER = Pattern.compile("\\?");

    @Resource
    protected SessionFactory sf;

    private String buildCountingHql(String hql) {
        hql = ORDER.matcher(hql).replaceFirst("");
        hql = FETCH.matcher(hql).replaceAll(" ");

        Matcher m = SELECT.matcher(hql);
        if (m.find()) {
            String sel = m.group(2).toLowerCase();
            if (sel.contains("distinct")) {
                if (sel.contains(",")) {
                    throw new HibernateException("Hql not support COUNT DISTINCT multiple columns; Please use other way do paginating or counting.");
                }

                hql = m.replaceFirst("Select Count($2) From");
            } else {
                hql = m.replaceFirst("Select Count(*) From");
            }
        } else {
            hql = "Select Count(*) " + hql;
        }
        return hql;
    }

    protected Query buildQuery(boolean nativeSql, String ql, Map<String, Object> values) {
        Query query = null;
        if (nativeSql)
            query = cs().createSQLQuery(ql);
        else {
            query = cs().createQuery(ql);
        }

        for (String name : values.keySet()) {
            setParameter(query, name, values.get(name));
        }
        return query;
    }

    protected Query buildQuery(boolean isSql, String ql, Object[] values) {
        int paramCnt = 0;
        if (values.length > 0) {
            Matcher m = PLACE_HOLDER.matcher(ql);
            StringBuffer sb = new StringBuffer();
            while (m.find()) {
                m.appendReplacement(sb, ":param" + paramCnt);
                paramCnt++;
            }
            m.appendTail(sb);
            if (paramCnt != values.length) {
                throw new HibernateException("Params' count is: " + paramCnt + " but expected to be: " + values.length);
            }
            ql = sb.toString();
        }

        Query query = isSql ? cs().createSQLQuery(ql) : cs().createQuery(ql);
        for (int i = 0; i < values.length; i++) {
            setParameter(query, "param" + i, values[i]);
        }
        return query;
    }

    public int count(String hql, Map<String, Object> params) {
        hql = buildCountingHql(hql);
        Number nmb = this.findUnique(hql, params);
        return nmb.intValue();
    }

    public int count(String hql, Object[] values) {
        hql = buildCountingHql(hql);
        Number nmb = this.findUnique(hql, values);
        return nmb.intValue();
    }

    public int countBySql(String sql, Map<String, Object> params) {
        sql = ORDER.matcher(sql).replaceFirst("");
        sql = "Select Count(*) From (" + sql + ")";
        Number nmb = this.findUniqueBySql(sql, params);
        return nmb.intValue();
    }

    public int countBySql(String sql, Object[] values) {
        sql = ORDER.matcher(sql).replaceFirst("");
        sql = "Select Count(*) From (" + sql + ")";
        Number nmb = this.findUniqueBySql(sql, values);
        return nmb.intValue();
    }

    public Session cs() {
        return this.sf.getCurrentSession();
    }

    public <T> List<T> find(String hql, Map<String, Object> params) {
        Query q = buildQuery(false, hql, params);

        List ret = q.list();
        return ret;
    }

    public <T> List<T> find(String hql, Object[] values) {
        Query q = buildQuery(false, hql, values);

        List ret = q.list();
        return ret;
    }

    public <T> List<T> findAll(Class<T> clazz) {
        String name = this.sf.getClassMetadata(clazz).getEntityName();
        String hql = "SELECT m FROM " + name + " m ";
        return find(hql, new Object[0]);
    }

    public <T> List<T> findBySql(String sql, Map<String, Object> params) {
        Query q = buildQuery(true, sql, params);

        List ret = q.list();
        return ret;
    }

    public <T> List<T> findBySql(String sql, Object[] values) {
        Query q = buildQuery(true, sql, values);

        List ret = q.list();
        return ret;
    }

    public List<Map<String, Object>> findMapBySql(String sql, Map<String, Object> params) {
        Query query = buildQuery(true, sql, params);

        List ret = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
        return ret;
    }

    public List<Map<String, Object>> findMapBySql(String sql, Object[] values) {
        Query query = buildQuery(true, sql, values);

        List ret = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
        return ret;
    }

    public List<Map<String, Object>> findMapBySqlAndRawAliases(String sql, Map<String, Object> params) {
        Query query = buildQuery(true, sql, params);

        List ret = query.setResultTransformer(CacheableTransformerFactory.createForSql(sql)).list();
        return ret;
    }

    public List<Map<String, Object>> findMapBySqlAndRawAliases(String sql, Object[] vars) {
        Query query = buildQuery(true, sql, vars);

        List ret = query.setResultTransformer(CacheableTransformerFactory.createForSql(sql))
                .list();
        return ret;
    }

    public <T> Page<T> findPage(String hql, int page, int pageSize, Map<String, Object> params) {
        int totalCount = count(hql, params);
        Query q = buildQuery(false, hql, params).setFirstResult((page - 1) * pageSize).setMaxResults(pageSize);

        List items = q.list();
        return new Page(page, pageSize, totalCount, items);
    }

    public <T> Page<T> findPage(String hql, int page, int pageSize, Object[] values) {
        int totalCount = count(hql, values);
        Query q = buildQuery(false, hql, values).setFirstResult((page - 1) * pageSize).setMaxResults(pageSize);

        List items = q.list();
        return new Page(page, pageSize, totalCount, items);
    }

    public <T> Page<T> findPageBySql(String sql, int page, int pageSize, Map<String, Object> params) {
        int totalCount = countBySql(sql, params);
        Query q = buildQuery(true, sql, params).setFirstResult((page - 1) * pageSize).setMaxResults(pageSize);

        List items = q.list();
        return new Page(page, pageSize, totalCount, items);
    }

    public <T> Page<T> findPageBySql(String sql, int page, int pageSize, Object[] values) {
        int totalCount = countBySql(sql, values);
        Query q = buildQuery(true, sql, values).setFirstResult((page - 1) * pageSize).setMaxResults(pageSize);

        List items = q.list();
        return new Page(page, pageSize, totalCount, items);
    }

    public Page<Map<String, Object>> findPageOfMapBySql(String sql, int page, int pageSize, Map<String, Object> params) {
        int totalCount = countBySql(sql, params);
        Query q = buildQuery(true, sql, params).setFirstResult((page - 1) * pageSize).setMaxResults(pageSize)
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

        List items = q.list();
        return new Page(page, pageSize, totalCount, items);
    }

    public Page<Map<String, Object>> findPageOfMapBySql(String sql, int page, int pageSize, Object[] values) {
        int totalCount = countBySql(sql, values);
        Query q = buildQuery(true, sql, values).setFirstResult((page - 1) * pageSize).setMaxResults(pageSize)
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

        List items = q.list();
        return new Page(page, pageSize, totalCount, items);
    }

    public Page<Map<String, Object>> findPageOfMapBySqlAndRawAliases(String sql, int page, int pageSize, Map<String, Object> params) {
        int totalCount = countBySql(sql, params);
        Query q = buildQuery(true, sql, params).setFirstResult((page - 1) * pageSize).setMaxResults(pageSize)
                .setResultTransformer(CacheableTransformerFactory.createForSql(sql));

        List items = q.list();
        return new Page(page, pageSize, totalCount, items);
    }

    public Page<Map<String, Object>> findPageOfMapBySqlAndRawAliases(String sql, int page, int pageSize, Object[] values) {
        int totalCount = countBySql(sql, values);
        Query q = buildQuery(true, sql, values).setFirstResult((page - 1) * pageSize).setMaxResults(pageSize)
                .setResultTransformer(CacheableTransformerFactory.createForSql(sql));

        List items = q.list();
        return new Page(page, pageSize, totalCount, items);
    }

    public <T> T findUnique(String hql, Map<String, Object> params) {
        Query q = buildQuery(false, hql, params);

        Object ret = q.uniqueResult();
        return (T) ret;
    }

    public <T> T findUnique(String hql, Object[] values) {
        Query q = buildQuery(false, hql, values);

        Object ret = q.uniqueResult();
        return (T) ret;
    }

    public <T> T findUniqueBySql(String sql, Map<String, Object> parmas) {
        Object ret = buildQuery(true, sql, parmas).uniqueResult();
        return (T) ret;
    }

    public <T> T findUniqueBySql(String sql, Object[] values) {
        Object ret = buildQuery(true, sql, values).uniqueResult();
        return (T) ret;
    }

    public <T> T get(Class<T> clazz, Serializable id) {
        Object ret = cs().get(clazz, id);
        return (T) ret;
    }

    public String getNamedQuery(String queryName) {
        return this.sf.getCurrentSession().getNamedQuery(queryName).getQueryString();
    }

    public <T> T merge(T e) {
        Object ret = this.sf.getCurrentSession().merge(e);
        return (T) ret;
    }

    public void persist(Object e) {
        this.sf.getCurrentSession().persist(e);
    }

    public void remove(Class<?> clazz, Serializable id) {
        Session c = this.sf.getCurrentSession();
        Object o = c.get(clazz, id);
        if (o != null)
            c.delete(o);
    }

    public void remove(Object e) {
        this.sf.getCurrentSession().delete(e);
    }

    public void removeAll(Collection<?> objs) {
        Session session = this.sf.getCurrentSession();
        for (Iterator localIterator = objs.iterator(); localIterator.hasNext(); ) {
            Object e = localIterator.next();
            session.delete(e);
        }
    }

    public void save(Object e) {
        this.sf.getCurrentSession().saveOrUpdate(e);
    }

    public void saveAll(Collection<?> es) {
        Session seesion = this.sf.getCurrentSession();
        for (Iterator localIterator = es.iterator(); localIterator.hasNext(); ) {
            Object e = localIterator.next();
            seesion.save(e);
        }
    }

    protected void setParameter(Query query, String name, Object value) {
        if ((value instanceof Collection))
            query.setParameterList(name, (Collection) value);
        else if ((value instanceof Object[]))
            query.setParameterList(name, (Object[]) value);
        else
            query.setParameter(name, value);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sf = sessionFactory;
    }

    public SessionFactory sf() {
        return this.sf;
    }

    public int update(String hql, Map<String, Object> namedVars) {
        Query q = buildQuery(false, hql, namedVars);
        return q.executeUpdate();
    }

    public int update(String hql, Object[] values) {
        Query q = buildQuery(false, hql, values);
        return q.executeUpdate();
    }

    public int updateBySql(String sql, Map<String, Object> namedVars) {
        Query q = buildQuery(true, sql, namedVars);
        return q.executeUpdate();
    }

    public int updateBySql(String sql, Object[] values) {
        Query q = buildQuery(true, sql, values);
        return q.executeUpdate();
    }
}