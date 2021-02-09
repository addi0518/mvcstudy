package com.mvcstudy.testmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mvcstudy.testmvc.database.DBConnection;
import com.mvcstudy.testmvc.vo.Board;

//데이터베이스에 접속해서 데이터 추가,삭제,수정 등의 작업
public class BoardDAO {
	
	private static BoardDAO b_dao = null;
	
	private BoardDAO() {
		
	}
	
	public static BoardDAO getInstance() {
		if(b_dao == null) {
			b_dao = new BoardDAO();
		}
		return b_dao;
	}
	
	public void insertBoard(Board board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.getConnection();
			/*
			 * String sql =
			 * "insert into board(b_title,b_content,b_date,b_writer) values(?,?,?,?)";
			 */
			String sql = "insert into board(b_title,b_content,b_writer) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getB_title());
			pstmt.setString(2, board.getB_content());
			pstmt.setString(3, board.getB_writer());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("SQLException : " + ex.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
