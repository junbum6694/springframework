package com.mycompany.springframework.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Order(2)
@Slf4j
@Component
@Aspect
public class Ch14Aspect1Before {
	@Before("execution(public * com.mycompany.springframework.controller.Ch14Controller.before*(..))")
	public void method() {
		// 메서드 호출 전에 실행하는 공통코드 작성
		log.info("메서드 호출 전에 실행");
	}
}
