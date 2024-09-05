package com.mycompany.springframework.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mycompany.springframework.dao.Ch12DaoInterface;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Ch12Service9 {
	@Value("${prop1}")
	private int prop1;
	private double prop2;
	private boolean prop3;
	private String prop4;
	
	public Ch12Service9() {
		log.info("prop1: " + prop1);		
	}
	@Autowired
	public void setProp2(@Value("${prop2}")double prop2) {
		log.info("prop1: " + prop1);
		log.info("prop2: " + prop2);

	}
	@Value("${prop3}")
	public void setProp3(boolean prop3) {
		log.info("prop3: " + prop3);
		this.prop3 = prop3;
	}
	
	//ch12_create_bean_by_xml.xml 파일 참조
	public void setProp4(String prop4) {
		log.info("prop4: " + prop4);
		this.prop4 = prop4;
	}
}





