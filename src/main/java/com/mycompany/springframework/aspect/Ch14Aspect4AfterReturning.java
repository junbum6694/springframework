package com.mycompany.springframework.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class Ch14Aspect4AfterReturning {
	@AfterReturning(pointcut ="execution(public * com.mycompany.springframework.controller.Ch14Controller.afterReturning*(..))",
			returning="returnValue")
	public void method(String returnValue) {
		// 메서드 호출 후에 실행하는 공통코드 작성
		log.info("메서드 호출 후에 실행");
		log.info("리턴값: "+ returnValue);
	}
}
