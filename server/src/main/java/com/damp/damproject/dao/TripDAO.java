package com.damp.damproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.damp.damproject.util.DBUtil;
import com.damp.damproject.util.MyException;
import com.damp.damproject.vo.TripVO;

@Repository
public class TripDAO {
	
	final static String url = "jdbc:mysql://localhost:3306/damp";
	final static String user = "ssafy";
	final static String password = "ssafy";
	
	public List<TripVO> searchByAddress(int sido, int gugun) throws MyException {
		List<TripVO> result = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection(url, user, password);

			String sql = "select * from attraction_info where sido_code = ? and gugun_code = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, sido);
			pstmt.setInt(2, gugun);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result.add(new TripVO(
								rs.getString("title"), rs.getString("addr1"), rs.getString("addr2"), rs.getString("tel"),
								rs.getDouble("latitude"), rs.getDouble("longitude"), rs.getInt("readcount"), rs.getString("first_image")
							));
			}
			
			return result;
		} catch (SQLException e) {
			throw new MyException("검색 실패");
		} finally {
			DBUtil.close(rs, pstmt, con);
		}
	}

	public List<TripVO> searchByType(int type) throws MyException {
		List<TripVO> result = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection(url, user, password);

			String sql = "select * from attraction_info where content_type_id = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, type);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result.add(new TripVO(
								rs.getString("title"), rs.getString("addr1"), rs.getString("addr2"), rs.getString("tel"),
								rs.getDouble("latitude"), rs.getDouble("longitude"), rs.getInt("readcount"), rs.getString("first_image")
							));
			}
			
			return result;
		} catch (SQLException e) {
			throw new MyException("검색 실패");
		} finally {
			DBUtil.close(rs, pstmt, con);
		}
	}
	
}
