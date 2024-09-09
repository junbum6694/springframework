package com.mycompany.springframework.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class Ch14Aspect6Around {
	@Around("execution(public * com.mycompany.springframework.controller.Ch14Controller.around*(..))")
	public Object method(ProceedingJoinPoint joinPoint) throws Throwable {
		//메서드 호출 전에 실행하는 공통 코드
		log.info("메서드 호출 전에 실행하는 공통 코드");
		//...
		Object result = joinPoint.proceed();
		//메서드 호출 후에 실행하는 공통 코드
		log.info("메서드 실행 후에 실행하는 공통 코드");
		//...
		return result;
	}
}
