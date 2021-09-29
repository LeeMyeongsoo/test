package com.site.p0830.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.site.p0830.vo.EventVo;

@Mapper
public interface EventMapper {

	//댓글 전체검색
	List<EventVo> selectEvent_view(int bid);

	//댓글 전체개수
	int selectEventCount(int bid);

	//댓글 저장
	void insertReplyWrite(EventVo eventVo);

	EventVo selectEventOne(int cno);

	

}
