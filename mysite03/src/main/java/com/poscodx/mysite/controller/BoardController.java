package com.poscodx.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poscodx.mysite.service.BoardService;
import com.poscodx.mysite.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardService;

	@GetMapping("")
	public String board(Model model) {
		List<BoardVo> boardList = boardService.getboardList();
		model.addAttribute("list", boardList);
		return "board/list";
	}

	@GetMapping("/detail/{no}/{userNo}/{title}/{contents}/{groupNo}/{depth}/{orderNo}")
	public String detail() {
		return null;
	}

}
  