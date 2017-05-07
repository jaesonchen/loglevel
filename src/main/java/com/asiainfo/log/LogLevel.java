package com.asiainfo.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.asiainfo.log.service.LogService;

@Component
public class LogLevel {

	private static final Logger logger = LoggerFactory.getLogger(LogLevel.class);

	@Autowired
	private LogService service;
	
	public static void main(String[] args) {

		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(new String[] {"classpath:application-core-configure.xml"});
		final LogLevel log = ac.getBean(LogLevel.class);
		
		log.execute();
		
		ac.close();
	}
	
	public void execute() {
		
		logger.debug("{}", "debug ......");
		logger.info("{}", "info ......");
		logger.warn("{}", "warn ......");
		logger.error("{}", "error ......");
		
		this.service.logService();
		//logger.error("{}", "error1 ......");
		
		//across thread invoke
		new Thread(new Runnable() {
					
			@Override
			public void run() {
						
				service.logService();
			}
		}).start();
	}
}
