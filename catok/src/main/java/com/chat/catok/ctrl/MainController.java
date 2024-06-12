package com.chat.catok.ctrl;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
	
//	@GetMapping(value="/")
//	public String home() {
//		return "redirect:/main.do";
//	}
	
	@GetMapping(value="/main.do")
	public String main() {
		return "main";
	}
}
