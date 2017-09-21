package com.xyyh.web.uap.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class RepositoryAop {

	@Pointcut("execution(public * com.xyyh.web.uap.services..*.*(..))")
	public void save() {
	};

	// @Before("save()")
	public void beforeMethod(JoinPoint point) {
		System.out.println(point);
	}

	// @After("save()")
	public void afterMethod(JoinPoint point) {
		System.out.println(point);
	}

	@Around("save()")
	public Object arroundMethod(ProceedingJoinPoint point) throws Throwable {
		return point.proceed();
	}
}
