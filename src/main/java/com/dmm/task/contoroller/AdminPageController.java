package com.dmm.task.contoroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPageController {
	@GetMapping("/adminPage")
	public String adminPage() {
		return "adminPage";
	}
}