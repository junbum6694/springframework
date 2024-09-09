package com.mycompany.springframework.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class Ch14AspectRuntimeCheck {
	
	@Around("@annotation(com.mycompany.springframework.aspect.RuntimeCheck)")
	public Object method(ProceedingJoinPoint joinPoint) throws Throwable {
		//메서드 호출 전에 실행하는 공통 코드
		long start = System.nanoTime();
		//...
		Object result = joinPoint.proceed();
		//메서드 호출 후에 실행하는 공통 코드
		long end = System.nanoTime();
		//...
		long howlong = end-start;
		
		//실재 실행된 메서드 이름 얻기
		String methodName = joinPoint.getSignature().toShortString();
		log.info(methodName +"실행 시간: " + howlong + "ns");
		return result;
	}
}
