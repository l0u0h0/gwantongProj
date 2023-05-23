package com.damp.damproject.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damp.damproject.dao.MemberDAO;
import com.damp.damproject.dao.MemberSecureDAO;
import com.damp.damproject.util.MyException;
import com.damp.damproject.util.OpenCrypt;
import com.damp.damproject.vo.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	MemberDAO memberDAO;
	@Autowired
	MemberSecureDAO memberSecureDAO;

	public MemberVO login(MemberVO member) throws MyException {
		String salt = memberSecureDAO.getSalt(member);
		if (salt == null) throw new MyException("로그인 실패");
		
		try {
			String hashPassword = OpenCrypt.getSHA256(member.getPassword(), salt);
			member.setPassword(hashPassword);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("로그인 실패");
		}

		return memberDAO.login(member);
	}

	public void register(MemberVO member) throws MyException {
		String salt = UUID.randomUUID().toString();
		
		try {
			String hashPassword = OpenCrypt.getSHA256(member.getPassword(), salt);
			member.setPassword(hashPassword);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("회원가입 실패");
		}
		
		memberSecureDAO.insertSalt(member, salt);
		memberDAO.register(member);
	}

	public void updateMember(MemberVO member, boolean updatePassword) throws MyException {
		if (updatePassword) {
			String salt = UUID.randomUUID().toString();
			
			try {
				String hashPassword = OpenCrypt.getSHA256(member.getPassword(), salt);
				member.setPassword(hashPassword);
			} catch (Exception e) {
				e.printStackTrace();
				throw new MyException("회원 정보 수정 실패");
			}

			memberSecureDAO.updateSalt(member, salt);
		}

		memberDAO.updateMember(member);
	}

	public void deleteMember(MemberVO member) throws MyException {
		memberSecureDAO.deleteSalt(member);
		memberDAO.deleteMember(member);
	}
	
}
