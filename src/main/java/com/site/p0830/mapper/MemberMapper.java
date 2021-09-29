package com.site.p0830.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.site.p0830.vo.MemberVo;

@Mapper
public interface MemberMapper {

	// select 1개 검색 - login
	MemberVo selectMemberOne(MemberVo memberVo);

}
