package com.poscodx.mysite.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		userService.join(vo);
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

	@PostMapping("/auth")
	public String auth(HttpSession session,
			@RequestParam(value = "email", required = true, defaultValue = "") String email,
			@RequestParam(value = "password", required = true, defaultValue = "") String password, Model model) {
		UserVo authUser = userService.getUser(email, password);
		if (authUser == null) {
			model.addAttribute("email", email);
			return "user/login";
		}
		/* 인증 처리 */
		session.setAttribute("authUser", authUser);
		return "redirect:/";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping("/update")
	public String update(HttpSession session) {
		// Access Control(접근 제어)
		UserVo authUser = (UserVo) (session.getAttribute("authUser"));
		if (authUser == null) {
			return "redirect:/user/login";
		}
		
		return "user/update";
	}
}
