package com.mycompany.springframework.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mycompany.springframework.dao.mybatis.Ch13MemberDao;
import com.mycompany.springframework.dto.Ch13Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Ch13MemberService {
	public enum JoinResult {
		SUCCESS,
		FAIL_DUPLICATED_MID
	}
	
	public enum LoginResult {
		SUCCESS,
		FAIL_MID,
		FAIL_PASSWORD,
		FAIL_ENABLED
	}
	
	@Resource
	private Ch13MemberDao memberDao;
	
	public JoinResult join(Ch13Member member) {
		boolean exist = isMid(member.getMid());
		if(exist) {
			return JoinResult.FAIL_DUPLICATED_MID;
		}
		memberDao.insert(member);
		return JoinResult.SUCCESS;
	}
	
	public boolean isMid(String mid) {
		Ch13Member member = memberDao.selectByMid(mid);
		if(member == null) {
			return false;
		}else {
			return true;
		}
	}
	
	
	
	public LoginResult login(Ch13Member member) {
		Ch13Member dbmember = memberDao.selectByMid(member.getMid());
		if(dbmember == null) {
			return LoginResult.FAIL_MID;
		}
		if(!dbmember.isMenabled()) {
			return LoginResult.FAIL_ENABLED;
		}
		if(!dbmember.getMpassword().equals(member.getMpassword())) {
			return LoginResult.FAIL_PASSWORD;
		}
		return LoginResult.SUCCESS;
	}
	
}
