package com.zea.geverytime.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;
import com.zea.geverytime.board.model.service.BoardService;
import com.zea.geverytime.board.model.vo.Board;
import com.zea.geverytime.common.MvcFileRenamePolicy;
import com.zea.geverytime.common.MvcUtils;
import com.zea.geverytime.common.model.vo.Attachment;

/**
 * Servlet implementation class BoardEnrollServlet
 */
@WebServlet("/board/boardEnroll")
public class BoardEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardService(); 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자 입력값 처리
		String saveDirectory = getServletContext().getRealPath("/upload/board");
		int max = 1024*1024*10; // 10메가바이트
		String encoding = "utf-8";
		FileRenamePolicy policy = new MvcFileRenamePolicy();
		
		MultipartRequest multipartRequest = new MultipartRequest(request,saveDirectory,max,encoding,policy);
		
		String title = multipartRequest.getParameter("title");
		String writer = multipartRequest.getParameter("writer");
		String content = multipartRequest.getParameter("content");
		String boardCode = multipartRequest.getParameter("boardCode");
		Board board = new Board();
		board.setWriter(writer);
		board.setTitle(title);
		board.setContent(content);
		board.setOrCode(boardCode);
		
		// 첨부파일 있는 경우 board객체에 첨부파일 List 추가
		if(multipartRequest.getParameter("file1") != null
				|| multipartRequest.getParameter("file2")!=null) {
			List<Attachment> list = new ArrayList<>();
			Attachment attachment =  null;
			if(multipartRequest.getParameter("file1")  != null) {
				attachment = MvcUtils.makeAttachment(multipartRequest,"file1");
				list.add(attachment);
			}
			if(multipartRequest.getParameter("file2") != null) {
				attachment =  MvcUtils.makeAttachment(multipartRequest,"file2");
				list.add(attachment);
			}
			board.setAttachments(list);
		}
	
		// 2. 업무처리
		int result = boardService.enrollBoard(board);
		
		
		// 3. 응답처리
		response.sendRedirect(request.getContextPath()+"/board/freeBoard");
		
	}

}