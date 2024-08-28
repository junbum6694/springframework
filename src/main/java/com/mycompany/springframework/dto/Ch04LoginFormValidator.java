package com.mycompany.springframework.dto;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch04LoginFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		log.info("실행");
		boolean result = Ch04LoginForm.class.isAssignableFrom(clazz);
		// isAssignableFrom으로 들어오는 clazz가 Ch04LoginForm이 맞는지
		return result; // or true
	}

	@Override
	public void validate(Object target, Errors errors) {
		log.info("실행");
		Ch04LoginForm loginForm = (Ch04LoginForm) target;
		String mid = loginForm.getMid();

		if (mid == null || mid.equals("")) {
			errors.rejectValue("mid", "errors.mid.required");
		} else if (mid.length() < 6 || mid.length() > 12) {
			errors.rejectValue("mid", "errors.mid.length", new Object[] { "6", "12" }, "알수없는 에러 발생");
			// error.mid.length 에러가 없을 때 "알수없는 에러 발생" 을 나타내도록 한다.
		}
		// password 설정
		String mpassword = loginForm.getMpassword();
		String pattern = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,15}";
		if (mpassword == null || mpassword.equals("")) {
			errors.rejectValue("mpassword", "errors.mpassword.required");
		} else if (mpassword.length() < 8 || mpassword.length() > 15) {
			errors.rejectValue("mpassword", "errors.mpassword.length", new Object[] { "8", "15" }, null);
		} else if (!Pattern.matches(pattern, mpassword)) {
			errors.rejectValue("mpassword", "errors.mpassword.wrongchar");
		}

	}

}
