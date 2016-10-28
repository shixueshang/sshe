package com.lhd.dao;

import com.lhd.commons.page.Page;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public abstract interface HibernateDao
{
	public abstract SessionFactory sf();

	public abstract Session cs();

	public abstract int count(String paramString, Map<String, Object> paramMap);

	public abstract int count(String paramString, Object... paramArrayOfObject);

	public abstract int countBySql(String paramString, Map<String, Object> paramMap);

	public abstract int countBySql(String paramString, Object... paramArrayOfObject);

	public abstract <T> List<T> find(String paramString, Map<String, Object> paramMap);

	public abstract <T> List<T> find(String paramString, Object... paramArrayOfObject);

	public abstract <T> List<T> findAll(Class<T> paramClass);

	public abstract <T> List<T> findBySql(String paramString, Map<String, Object> paramMap);

	public abstract <T> List<T> findBySql(String paramString, Object... paramArrayOfObject);

	public abstract List<Map<String, Object>> findMapBySql(String paramString, Map<String, Object> paramMap);

	public abstract List<Map<String, Object>> findMapBySql(String paramString, Object... paramArrayOfObject);

	public abstract List<Map<String, Object>> findMapBySqlAndRawAliases(String paramString, Map<String, Object> paramMap);

	public abstract List<Map<String, Object>> findMapBySqlAndRawAliases(String paramString, Object... paramArrayOfObject);

	public abstract <T> Page<T> findPage(String paramString, int paramInt1, int paramInt2, Map<String, Object> paramMap);

	public abstract <T> Page<T> findPage(String paramString, int paramInt1, int paramInt2, Object... paramArrayOfObject);

	public abstract <T> Page<T> findPageBySql(String paramString, int paramInt1, int paramInt2, Map<String, Object> paramMap);

	public abstract <T> Page<T> findPageBySql(String paramString, int paramInt1, int paramInt2, Object... paramArrayOfObject);

	public abstract Page<Map<String, Object>> findPageOfMapBySql(String paramString, int paramInt1, int paramInt2, Map<String, Object> paramMap);

	public abstract Page<Map<String, Object>> findPageOfMapBySql(String paramString, int paramInt1, int paramInt2, Object... paramArrayOfObject);

	public abstract Page<Map<String, Object>> findPageOfMapBySqlAndRawAliases(String paramString, int paramInt1, int paramInt2, Map<String, Object> paramMap);

	public abstract Page<Map<String, Object>> findPageOfMapBySqlAndRawAliases(String paramString, int paramInt1, int paramInt2, Object... paramArrayOfObject);

	public abstract <T> T findUnique(String paramString, Map<String, Object> paramMap);

	public abstract <T> T findUnique(String paramString, Object... paramArrayOfObject);

	public abstract <T> T findUniqueBySql(String paramString, Map<String, Object> paramMap);

	public abstract <T> T findUniqueBySql(String paramString, Object... paramArrayOfObject);

	public abstract <T> T get(Class<T> paramClass, Serializable paramSerializable);

	public abstract String getNamedQuery(String paramString);

	public abstract <T> T merge(T paramT);

	public abstract void persist(Object paramObject);

	public abstract void remove(Class<?> paramClass, Serializable paramSerializable);

	public abstract void remove(Object paramObject);

	public abstract void removeAll(Collection<?> paramCollection);

	public abstract void save(Object paramObject);

	public abstract void saveAll(Collection<?> paramCollection);

	public abstract int update(String paramString, Map<String, Object> paramMap);

	public abstract int update(String paramString, Object... paramArrayOfObject);

	public abstract int updateBySql(String paramString, Map<String, Object> paramMap);

	public abstract int updateBySql(String paramString, Object... paramArrayOfObject);
}