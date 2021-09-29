package com.site.p0830.service;

import java.util.List;
import java.util.Map;

import com.site.p0830.vo.EventVo;

public interface EventService {

	//댓글 전체검색
	Map<String, Object> selectEvent_view(int bid);

	//댓글 저장
	Map<String, Object> insertReplyWrite(EventVo eventVo);

}
