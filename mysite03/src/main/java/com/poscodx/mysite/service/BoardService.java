package com.poscodx.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poscodx.mysite.repository.BoardRepository;
import com.poscodx.mysite.vo.BoardVo;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;

	public List<BoardVo> getboardList() {
		List<BoardVo> list = boardRepository.findAll(1);
		return list;
	}

	// 게시판 상세 수
	public void updateDetail(BoardVo boardVo) {
		boardRepository.updateTitleAndContentsByNo(boardVo.getTitle(), boardVo.getContents(),
				boardVo.getNo().toString());
		;

	}

}
