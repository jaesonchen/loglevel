package com.asiainfo.log.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

//import java.util.HashMap;
//import java.util.Map;
import java.util.UUID;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopService {
	
	private static final Logger logger = LoggerFactory.getLogger(AopService.class);
	
	//public static final ThreadLocal<Map<String, String>> local = new InheritableThreadLocal<Map<String, String>>();

	@Pointcut("execution(* com.asiainfo.log.service.*.*(..))")
    public void aopLogService() {}

	@Around("aopLogService()")
	public Object around(JoinPoint joinPoint) throws Throwable {
		
		logger.debug("aop start......");
		logger.info("aop start......");
		logger.warn("aop start......");
		logger.error("aop start......");
		
		Object result = null;
		
		try {
			//put request_id for log
			String request_id = MDC.get("REQUEST_ID");
			//across multi method invoke use unique id
			if (request_id == null || "".equals(request_id)) {
				request_id = UUID.randomUUID().toString();
				MDC.put("REQUEST_ID", request_id + " -- ");
			}
			
			result = ((ProceedingJoinPoint) joinPoint).proceed();
			//MDC.put("EXECUTE", "time");
		} finally {
			//remove request_id
			MDC.remove("REQUEST_ID");
		}
		return result;
	}
}
