package com.site.p0830.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.site.p0830.service.MemberService;
import com.site.p0830.vo.MemberVo;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	//로그인
	@GetMapping("/member/login")
	public String login() {
		return "/member/login";
	}
	
	//로그인 - ajax
	@PostMapping("/member/login")
	@ResponseBody
	public String login(MemberVo memberVo,HttpServletRequest request) {
		HttpSession session = request.getSession();
		// 체크를 해서 success -> index, fail -> login
		MemberVo mVo = memberService.selectMemberOne(memberVo);
		String login_check="";
		if(mVo==null) {
			session.setAttribute("session_flag", "fail");
			login_check ="fail";
		}else {
			session.setAttribute("session_flag", "success");
			session.setAttribute("session_id", mVo.getId());
			session.setAttribute("session_nickname",mVo.getNickname());
			login_check ="success";
		}
		return login_check;
	}
	
	//로그아웃
	@GetMapping("/member/logout")
	public String logout() {
		return "/member/logout";
	}

}
