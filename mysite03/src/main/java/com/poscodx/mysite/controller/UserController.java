package com.poscodx.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poscodx.mysite.service.UserService;
import com.poscodx.mysite.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/join")
	public String join() {
		return "user/join";
	}

	@PostMapping("/join")
	public String join(UserVo vo) {
		System.out.println(vo);
		userService.addUser(vo);
		return "redirect:/user/joinsuccess";
	}

	@GetMapping("/joinsuccess")
	public String joinsuccess() {
		return "user/joinsuccess";
	}

	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
}
