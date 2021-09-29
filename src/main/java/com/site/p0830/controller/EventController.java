package com.site.p0830.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.site.p0830.service.EventService;
import com.site.p0830.vo.EventVo;

@Controller
public class EventController {

	@Autowired
	EventService eventService;
	
	@RequestMapping("/event/event")
	public String event() {
		return "/event/event";
	}
	
	//댓글 전체검색
	@RequestMapping("/event/event_view")
	public String event_view(@RequestParam int bid,Model model) {
		
		//board의 댓글을 모두 가져옴.
		Map<String, Object> map = eventService.selectEvent_view(bid);
		
		//board의 view정보와 댓글 정보를 보내야 함.
		model.addAttribute("map",map);
		
		return "/event/event_view";
	}
	
	//댓글 저장 (ajax)
	@RequestMapping("/event/replyWrite")
	@ResponseBody
	public Map<String, Object> replyWrite(EventVo eventVo) {
		//댓글저장후 1개검색, 댓글개수 가져오기
		Map<String, Object> map = eventService.insertReplyWrite(eventVo);
		
		return map;
	}
}
