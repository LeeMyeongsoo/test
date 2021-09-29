package com.site.p0830.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.p0830.mapper.EventMapper;
import com.site.p0830.vo.EventVo;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	EventMapper eventMapper;
	
	@Override //댓글 전체검색
	public Map<String, Object> selectEvent_view(int bid) {
		Map<String, Object> map = new HashMap<String, Object>();
		//댓글 전체검색
		List<EventVo> list = eventMapper.selectEvent_view(bid);
		//댓글 전체개수
		int replyCount = eventMapper.selectEventCount(bid);
		
		// map저장
		map.put("list",list);
		map.put("replyCount",replyCount);
		
		return map;
	}

	@Override //댓글 저장
	public Map<String, Object> insertReplyWrite(EventVo eventVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		//댓글 저장
		eventMapper.insertReplyWrite(eventVo); //selectKey를 통해 eventVo.getCno() 가져옴.
		//댓글 저장후 1개 검색
		eventVo = eventMapper.selectEventOne(eventVo.getCno());
		//댓글 전체개수
		int replyCount = eventMapper.selectEventCount(eventVo.getBid());
		// map저장
		map.put("eventVo",eventVo);
		map.put("replyCount",replyCount);
		
		return map;
	}

}
