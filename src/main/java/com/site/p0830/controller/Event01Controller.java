
package com.site.p0830.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.site.p0830.service.Event01Service;

@Controller
public class Event01Controller {

	@Autowired

	Event01Service event01Service;

	@RequestMapping("event01/list")
	public String list(
			@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam @Nullable String category,
			@RequestParam @Nullable String searchWord, Model model) {
		Map<String,Object> map = new HashMap<String,Object>();
		map = event01Service.selectBoardList(page, category, searchWord);
		
		model.addAttribute("map", map);

		return "/event01/list";
	}

	@RequestMapping("event01/view")
	public String view(@RequestParam int bid, Model model) {
		Map<String,Object> map = new HashMap<String,Object>();
		map = event01Service.selectOneList(bid);
		model.addAttribute("map",map);
		
		return "/event01/view";
	}

}
