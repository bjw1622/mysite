package com.poscodx.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poscodx.mysite.repository.GuestbookRepository;
import com.poscodx.mysite.vo.GuestbookVo;

@Service
public class GueskbookService {
	@Autowired
	private GuestbookRepository guestbookRepository;

	public List<GuestbookVo> getContentList() {
		return guestbookRepository.findAll();
	}

	public void deleteContents(Long no) {
		guestbookRepository.deleteByNo(no);
	}

	public void addContents(GuestbookVo vo) {
		guestbookRepository.insert(vo);
	}

}
