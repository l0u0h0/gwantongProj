package com.damp.damproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.damp.damproject.service.TripService;
import com.damp.damproject.util.MyException;
import com.damp.damproject.vo.TripVO;

@Controller
public class TripController {
	
	@Autowired
	TripService tripService;
	
	@GetMapping("searchByAddress")
	@ResponseBody
	public List<TripVO> searchByAddress(int sido, int gugun) {
		try {
			return tripService.searchByAddress(sido, gugun);
		} catch (MyException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping("searchByType")
	@ResponseBody
	public List<TripVO> searchByType(int type) {
		System.out.println(type);
		try {
			return tripService.searchByType(type);
		} catch (MyException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
