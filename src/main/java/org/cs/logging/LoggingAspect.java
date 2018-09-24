package org.cs.logging;



import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.cs.logmodel.ReturnType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;



@Aspect
@Configuration
public class LoggingAspect {

	private static Logger logger = LoggerFactory.getLogger("AOP Engine Logger");

	@Around(value = "ReaderEngineExecution()")
	public Object readerAuditAround(ProceedingJoinPoint joinPoint) {
		Date date = new Date();
		String methodName = joinPoint.getSignature().getName();

		Object obj = null;
		joinPoint.getArgs();
		try {
			obj = joinPoint.proceed();
			Date date2 = new Date();
			ReturnType rType = (ReturnType) obj;
			logger.info("Method {} return with input params : {} StartDate : {} EndDate : {}  with outparams : {}",
					methodName, Arrays.toString(joinPoint.getArgs()), date.toString(), date2.toString(),
					rType.toString());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			Date date2 = new Date();
			logger.error("Method {} with input params : {} StartDate : {} EndDate : {} Error : {} ", methodName,
					Arrays.toString(joinPoint.getArgs()), date.toString(), date2.toString(), e.getMessage());
		}
		return obj;
	}
	
	@Around(value = "LogGeneratorExecution()")
	public Object generatorAuditAround(ProceedingJoinPoint joinPoint) {
		Date date = new Date();
		String methodName = joinPoint.getSignature().getName();

		Object obj = null;
		joinPoint.getArgs();
		try {
			obj = joinPoint.proceed();
			Date date2 = new Date();
			ReturnType rType = (ReturnType) obj;
			logger.info("Method {} return with input params : {} StartDate : {} EndDate : {}  with outparams : {}",
					methodName, Arrays.toString(joinPoint.getArgs()), date.toString(), date2.toString(),
					rType.toString());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			Date date2 = new Date();
			logger.error("Method {} with input params : {} StartDate : {} EndDate : {} Error : {} ", methodName,
					Arrays.toString(joinPoint.getArgs()), date.toString(), date2.toString(), e.getMessage());
		}
		return obj;
	}


	@Pointcut("execution(* org.cs.logreader.service.*.*(..))")
	public void ReaderEngineExecution() {
	}

	@Pointcut("execution(* org.cs.loggenerator.service.*.*(..))")
	public void LogGeneratorExecution() {
	}

	

}
