package com.asiainfo.log.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.log.dao.LogDao;

@Service
public class LogService {

	private static final Logger logger = LoggerFactory.getLogger(LogService.class);

	@Autowired
	private LogDao dao;
	
	public void logService() {

		logger.debug("{}", "service debug ......");
		logger.info("{}", "service info ......");
		logger.warn("{}", "service warn ......");
		logger.error("{}", "service error ......");
		
		this.dao.logDao();
	}
}
