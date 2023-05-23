package com.damp.damproject.dao;

import java.sql.*;

import org.springframework.stereotype.Repository;

import com.damp.damproject.util.DBUtil;
import com.damp.damproject.util.MyException;
import com.damp.damproject.vo.MemberVO;

@Repository
public class MemberDAO {
	
	final static String url = "jdbc:mysql://localhost:3306/damp";
	final static String user = "ssafy";
	final static String password = "ssafy";

	public MemberVO login(MemberVO member) throws MyException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBUtil.getConnection(url, user, password);
			
			String sql = "select * from member where member_id = ? and password = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getPassword());
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member.setId(rs.getInt("id"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setAddress(rs.getString("address"));
				return member;
			}
			return null;
		} catch (SQLException e) {
			throw new MyException("로그인 실패");
		} finally {
			DBUtil.close(rs, pstmt, con);
		}
	}

	public void register(MemberVO member) throws MyException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.getConnection(url, user, password);
			
			String sql = "insert into member (member_id, password, name, email, address) values (?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getAddress());
			
			int result = pstmt.executeUpdate();
			if (result <= 0) throw new MyException("회원가입 실패");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MyException("회원가입 실패");
		} finally {
			DBUtil.close(pstmt, con);
		}
	}

	public void updateMember(MemberVO member) throws MyException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.getConnection(url, user, password);
			
			String sql = "update member set password = ?, name = ?, email = ?, address = ? where id = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getAddress());
			pstmt.setInt(5, member.getId());
			
			int result = pstmt.executeUpdate();
			if (result <= 0) throw new MyException("회원 정보 수정 실패");
		} catch (SQLException e) {
			throw new MyException("회원 정보 수정 실패");
		} finally {
			DBUtil.close(pstmt, con);
		}
	}

	public void deleteMember(MemberVO member) throws MyException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.getConnection(url, user, password);
			
			String sql = "delete from member where id = ?";
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
