package com.damp.damproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.damp.damproject.service.TripService;

@Controller
public class TripController {
	
	@Autowired
	TripService tripService;
	
}
