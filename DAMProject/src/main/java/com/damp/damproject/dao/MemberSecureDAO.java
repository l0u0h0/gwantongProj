package com.damp.damproject.dao;

import java.sql.*;

import org.springframework.stereotype.Repository;

import com.damp.damproject.util.DBUtil;
import com.damp.damproject.util.MyException;
import com.damp.damproject.vo.MemberVO;

@Repository
public class MemberSecureDAO {
	
	final static String url = "jdbc:postgresql://localhost:5432/damp";
	final static String user = "ssafy";
	final static String password = "ssafy";
	
	public String getSalt(MemberVO member) throws MyException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBUtil.getConnection(url, user, password);
			
			String sql = "select salt from member_secure where id = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, member.getId());
			
			rs = pstmt.executeQuery();
			if (rs.next()) return rs.getString("salt");
			return null;
		} catch (SQLException e) {
			throw new MyException("로그인 실패");
		} finally {
			DBUtil.close(rs, pstmt, con);
		}
	}
	
	public void insertSalt(MemberVO member, String salt) throws MyException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.getConnection(url, user, password);
			
			String sql = "insert into member_secure (id, salt) values (?, ?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, member.getId());
			pstmt.setString(2, salt);
			
			int result = pstmt.executeUpdate();
			if (result <= 0) throw new MyException("회원가입 실패");
		} catch (SQLException e) {
			throw new MyException("회원가입 실패");
		} finally {
			DBUtil.close(pstmt, con);
		}
	}
	
	public void updateSalt(MemberVO member, String salt) throws MyException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.getConnection(url, user, password);
			
			String sql = "update member_secure set salt = ? where id = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, salt);
			pstmt.setInt(2, member.getId());
			
			int result = pstmt.executeUpdate();
			if (result <= 0) throw new MyException("회원 정보 수정 실패");
		} catch (SQLException e) {
			throw new MyException("회원 정보 수정 실패");
		} finally {
			DBUtil.close(pstmt, con);
		}
	}
	
	public void deleteSalt(MemberVO member) throws MyException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.getConnection(url, user, password);
			
			String sql = "delete from member_secure where id = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, member.getId());
			
			int result = pstmt.executeUpdate();
			if (result <= 0) throw new MyException("회원 탈퇴 실패");
		} catch (SQLException e) {
			throw new MyException("회원 탈퇴 실패");
		} finally {
			DBUtil.close(pstmt, con);
		}
	}
	
}
