package com.site.p0830.service;

import com.site.p0830.vo.MemberVo;

public interface MemberService {

	// select 1개 검색 - login
	MemberVo selectMemberOne(MemberVo memberVo);

}
