package com.site.p0830.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.site.p0830.service.BoardService;
import com.site.p0830.vo.BoardVo;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/board/boardList")
	public String boardList(@RequestParam(value="page", defaultValue = "1") int page
			,@RequestParam @Nullable String category, @RequestParam @Nullable String searchWord
			,Model model) {
		Map<String, Object> map = boardService.selectBoardList(page,category,searchWord);
		model.addAttribute("map",map);
		//하단 넘버링 : listCount,page,maxpage,startpage,endpage
		return "/board/boardList";
	}
	
	
	
	
	
	

}
