package com.site.p0830.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.p0830.mapper.BoardMapper;
import com.site.p0830.vo.BoardVo;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	//게시판 전체검색
	@Override
	public Map<String, Object> selectBoardList(int page,String category, String searchWord) {
		Map<String, Object> map = new HashMap<String, Object>();
		//하단넘버링 구하는 메소드
		//하단 넘버링 : listCount,page,maxpage,startpage,endpage
		//게시글 전체개수 (일반게시글,검색게시글)
		int listCount = boardMapper.selectListCount(category,searchWord);
		System.out.println("service listCount : "+listCount);
		int limit=10; //한페이지당 게시글 수
		int numlimit=10; //하단 넘버링 개수
		
		int maxpage = (int)((double)listCount/limit+0.99); //최대페이지 수
		int startpage = (((int)((double)page/numlimit+0.99))-1)*numlimit+1; //하단넘버링 첫번째 수
		int endpage = startpage+numlimit-1; //하단넘버링 마지막 수
		if(endpage>maxpage) endpage=maxpage; // 마지막수가 maxpage수 보다 크면 maxpage로 대체
		
		int startrow = (page-1)*limit+1;
		int endrow = startrow+limit-1;
		
		List<BoardVo> list = boardMapper.selectBoardList(startrow,endrow,category,searchWord);
		
		
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
