package com.damp.damproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damp.damproject.dao.TripDAO;
import com.damp.damproject.util.MyException;
import com.damp.damproject.vo.TripVO;

@Service
public class TripService {
	
	@Autowired
	TripDAO tripDAO;

	public List<TripVO> searchByAddress(int sido, int gugun) throws MyException {
		return tripDAO.searchByAddress(sido, gugun);
	}

	public List<TripVO> searchByType(int type) throws MyException {
		return tripDAO.searchByType(type);
	}

}
