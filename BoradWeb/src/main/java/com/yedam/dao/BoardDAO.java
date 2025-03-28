package com.yedam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.BoardVo;

public class BoardDAO extends DAO {

	public List<BoardVo> boardList() {
		List<BoardVo> list = new ArrayList();
		
		Connection connection = getConnect();
		try {
			PreparedStatement psmt = connection.prepareStatement("select * from tbl_board");
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				BoardVo boardVo = new BoardVo();
				boardVo.setBoardNo(rs.getInt("board_no"));
				boardVo.setContent(rs.getString("content"));
				boardVo.setTitle(rs.getString("title"));
				boardVo.setWriteDate(rs.getDate("write_date"));
				boardVo.setWriter(rs.getString("writer"));
				list.add(boardVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
