package com.site.p0830.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.p0830.mapper.MemberMapper;
import com.site.p0830.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper memberMapper;
	
	// select 1개 검색 - login
	@Override
	public MemberVo selectMemberOne(MemberVo memberVo) {
		MemberVo mVo = memberMapper.selectMemberOne(memberVo);
		return mVo;
	}

}
