package com.lhd.context;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lihongde
 */
@ContextConfiguration(locations = {
		"classpath:spring-hibernate.xml",
		"classpath:spring-mvc.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Rollback
@Transactional(transactionManager = "transactionManager")
public class Base extends Assert {
	protected Logger logger = Logger.getLogger(getClass());
	
}
