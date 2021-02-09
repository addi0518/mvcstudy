package com.mvcstudy.testmvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvcstudy.testmvc.service.BoardService;
import com.mvcstudy.testmvc.vo.Board;

@WebServlet("*.board") //매핑
public class BoardControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//UID값으로 통신한 것이 정상인지 판단 -> 미리 선언(직렬화 관련)

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charse=utf-8");

		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		String view = null;
		BoardService boardService = null;
	
		
		switch (command) {

		case "/write.board":
			Board board = new Board();
			board.setB_title(request.getParameter("b_title"));
			board.setB_content(request.getParameter("b_content"));
			
			boardService = BoardService.getInstance();
			boardService.insertBoard(board);
			
			view = "board/result";
			break;
			
		case "/form.board":
			view = "board/form";
			break;
			
		case "/board-list.board":
			
			view = "board/board-list";
			break;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(view+".jsp");
		rd.forward(request, response);
	}
}
