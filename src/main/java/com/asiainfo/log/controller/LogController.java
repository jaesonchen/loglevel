package com.asiainfo.log.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.asiainfo.log.LogLevel;

@Path("/log")
public class LogController {
	
	//private final Logger logger = Logger.getLogger(LogController.class);
	private final Logger logger1 = LogManager.getLogger(getClass());
	
	private final org.apache.logging.log4j.Logger logger2 = org.apache.logging.log4j.LogManager.getLogger(getClass());
	
	private final Log log = LogFactory.getLog(getClass());
	
	@GET
    @Path("/execute")
    @Produces("application/json; charset=utf-8")
	public String execute(@Context HttpServletRequest request) {
		
		logger1.debug("Controller log4j debug......");
		logger1.info("Controller log4j info......");
		logger1.error("Controller log4j error......");
		
		logger2.debug("Controller log4j2 debug......");
		logger2.info("Controller log4j2 info......");
		logger2.error("Controller log4j2 error......");
		
		log.debug("Controller apache common logging debug......");
		log.info("Controller apache common logging info......");
		log.error("Controller apache common logging error......");
		
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		
		LogLevel level = context.getBean(LogLevel.class);
		level.execute();
		return "success";
	}
}
