package com.site.p0830.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.p0830.mapper.event01Mapper;
import com.site.p0830.vo.BoardVo;
import com.site.p0830.vo.EventVo;

@Service
public class Event01ServiceImpl implements Event01Service {

	@Autowired	
	
	event01Mapper event01mapper;

	
	public Map<String, Object> selectBoardList(int page,String category, String searchWord) {
		//하단넘버링 구하는 메소드
		//하단 넘버링 : listCount,page,maxpage,startpage,endpage
		//게시글 전체개수 (일반게시글,검색게시글)
		Map<String, Object> map = new HashMap<String, Object>();
		int listCount = event01mapper.selectListCount(category,searchWord);
		System.out.println("service listCount : "+listCount);
		int limit=10; //한페이지당 게시글 수
		int numlimit=10; //하단 넘버링 개수
		
		int maxpage = (int)((double)listCount/limit+0.99); //최대페이지 수
		int startpage = (((int)((double)page/numlimit+0.99))-1)*numlimit+1; //하단넘버링 첫번째 수
		int endpage = startpage+numlimit-1; //하단넘버링 마지막 수
		if(endpage>maxpage) endpage=maxpage; // 마지막수가 maxpage수 보다 크면 maxpage로 대체
		
		int startrow = (page-1)*limit+1;
		int endrow = startrow+limit-1;
		
		List<BoardVo> list = event01mapper.selectBoardList(startrow,endrow,category,searchWord);
		
		
		//하단 넘버링에 필요한 자료
		map.put("listCount",listCount);
		map.put("maxpage",maxpage);
		map.put("startpage",startpage);
		map.put("endpage",endpage);
		map.put("list",list);
		map.put("category",category);
		map.put("searchWord",searchWord);
		
		return map;
	}
	//게시판 1개 검색
	@Override
	public Map<String, Object> selectOneList(int bid) {
		Map<String, Object> map = new HashMap<String, Object>();
		//1증가
		event01mapper.updateBhut(bid);
		
		//1개 리스트 가져오기
		BoardVo boardVo = event01mapper.selectOneList(bid);
		
		//하단댓글
		List<EventVo> eventList = event01mapper.selectReplyAll(bid);
		map.put("eventList", eventList);
		map.put("boardVo", boardVo);
		
		return map;
	}
	
	
		
	
}
