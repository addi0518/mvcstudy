package com.mvcstudy.testmvc.service;

import com.mvcstudy.testmvc.dao.BoardDAO;
import com.mvcstudy.testmvc.vo.Board;

public class BoardService {
	private static BoardService b_service = null;
	private static BoardDAO b_dao = null;
	
	private BoardService() {
		
	}
	
	public static BoardService getInstance() {
		if(b_service == null) {
			b_service = new BoardService();
			b_dao = BoardDAO.getInstance();
		}
		return b_service;
	}
	
	public void insertBoard(Board board) {
		b_dao.insertBoard(board);
	}
}
