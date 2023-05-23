package com.damp.damproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.damp.damproject.service.MemberService;
import com.damp.damproject.util.MyException;
import com.damp.damproject.vo.MemberVO;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@PostMapping("login")
	@ResponseBody
	public String login(MemberVO member, HttpServletResponse response, HttpServletRequest request){
		try {
			member = memberService.login(member);
			if (member == null) return "FAIL";
			
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			
			Cookie cookie = new Cookie("JSESSIONID", session.getId());
			cookie.setPath("/");
			response.addCookie(cookie);
			
			return "OK";
		} catch (MyException e) {
			e.printStackTrace();
			return "FAIL";
		}
	}
	
	@GetMapping("logout")
	@ResponseBody
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		if (session != null) session.invalidate();
		return "OK";
	}
	
	@PostMapping("register")
	@ResponseBody
	public String register(MemberVO member){
		try {
			memberService.register(member);
			return "OK";
		} catch (MyException e) {
			e.printStackTrace();
			return "FAIL";
		}
	}
	
	@PostMapping("updateMember")
	@ResponseBody
	public String updateMember(MemberVO member, HttpServletRequest request){
		HttpSession session = request.getSession(false);
		if (session == null) return "FAIL";
		System.out.println(session);
		MemberVO originMember = (MemberVO) session.getAttribute("member");
		if (originMember == null) return "FAIL";
		System.out.println(originMember);
		member.setId(originMember.getId());
		member.setMemberId(originMember.getMemberId());
		
		boolean updatePassword = member.getPassword() != null;
		if (!updatePassword) member.setPassword(originMember.getPassword());
		if (member.getName() == null) member.setName(originMember.getName());
		if (member.getEmail() == null) member.setEmail(originMember.getEmail());
		if (member.getAddress() == null) member.setAddress(originMember.getAddress());
		
		try {
			memberService.updateMember(member, updatePassword);
			originMember = member;
			return "OK";
		} catch (MyException e) {
			e.printStackTrace();
			return "FAIL";
		}
	}
	
	@GetMapping("deleteMember")
	@ResponseBody
	public String deleteMember(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		if (session == null) return "FAIL";
		
		MemberVO member = (MemberVO) session.getAttribute("member");
		if (member == null) return "FAIL";
		
		try {
			memberService.deleteMember(member);
			session.invalidate();
			return "OK";
		} catch (MyException e) {
			e.printStackTrace();
			return "FAIL";
		}
	}
	
}
