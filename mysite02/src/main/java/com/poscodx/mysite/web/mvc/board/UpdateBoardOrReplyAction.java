package com.poscodx.mysite.web.mvc.board;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.mysite.dao.BoardDao;
import com.poscodx.web.mvc.Action;

public class UpdateBoardOrReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String groupNo = request.getParameter("groupNo");
		String depth = request.getParameter("depth");
		String orderNo = request.getParameter("orderNo");
		String userNo = request.getParameter("userNo");

		String encodeTitle = URLEncoder.encode(title, "UTF-8");
		String encodeContents = URLEncoder.encode(contents, "UTF-8");
		new BoardDao().updateTitleAndContentsByNo(title, contents, no);

		response.sendRedirect(request.getContextPath() + "/board?a=detailboardorreply&no=" + no + "&title="
				+ encodeTitle + "&contents=" + encodeContents + "&groupNo=" + groupNo + "&depth=" + depth + "&orderNo="
				+ orderNo + "&userNo=" + userNo);

	}

}
