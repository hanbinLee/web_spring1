package com.java.guestService;

import java.util.logging.Logger;

import org.springframework.web.servlet.ModelAndView;

public class GuestServiceImpl implements GuestService{
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	public void testing(ModelAndView mav) {
		logger.info("GuestServiceImpl testing Start");
		logger.warning("warning");
		logger.severe("asdf");
		
		
		//요청값을 가지고 DB 작업
		mav.addObject("msg" , "hahaha");
		mav.setViewName("guest/testOk");
	}	
}
