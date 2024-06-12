package com.chat.catok.ctrl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.chat.catok.service.IUserInfoService;
import com.chat.catok.vo.UserInfoVo;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {
	
	@Autowired
	private IUserInfoService service;
	
	@GetMapping(value="/")
	public String home() {
		return "redirect:/loginForm.do";
	}
	
	@GetMapping(value="/loginForm.do")
	public String loginForm() {
		log.info("###로그인페이지로 가요");
		return "login/loginForm";
	}
	
	@GetMapping(value="/loginSuccess.do")
	public String loginSuccess() {
		log.info("###로그인 성공");
		return "main";
	}
	
	@PostMapping(value="/login.do")
	public String loginForm(HttpServletRequest request, String id) {
		log.info("###로그인중!");
		id = request.getParameter("id");
		UserInfoVo user = service.login(id);
		log.info("###user : " + user);
		return "main";
	}
}
