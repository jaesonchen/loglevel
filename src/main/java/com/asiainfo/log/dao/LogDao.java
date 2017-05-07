package com.asiainfo.log.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class LogDao {

	private static final Logger logger = LoggerFactory.getLogger(LogDao.class);

	public void logDao() {

		logger.debug("{}", "dao debug ......");
		logger.info("{}", "dao info ......");
		logger.warn("{}", "dao warn ......");
		logger.error("{}", "dao error ......");
	}
}
