package com.chat.catok.ctrl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class MainController {
	
	@GetMapping("/main.do")
	public String main(@AuthenticationPrincipal UserDetails user, Model model) {
		log.info("###Principal UserDetail 객체 : {}", user);
		model.addAttribute("username", user.getUsername());
		List<String> authorityStrings = new ArrayList<>();
		for(GrantedAuthority authority : user.getAuthorities()) {
			authorityStrings.add(authority.getAuthority());
		}
		model.addAttribute("auth", authorityStrings);
		return "main";
	}
	
	@GetMapping("/admin.do")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public String admin() {
		return "admin/adminPage";
	}
	
	@GetMapping("/user.do")
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	public String user() {
		return "user/userPage";
	}
	
	@GetMapping("/sessionExpired.do")
	public String sessionExpired() {
		log.info("###세션이 만료되었어용");
		return "sessionExpired";
	}
}
