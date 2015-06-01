package com.java.guestController;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.java.guestDto.GuestDto;
import com.java.guestService.GuestService;

public class GuestController extends MultiActionController {
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	private GuestService guestService;
	
	public GuestController() {}
	public GuestController(GuestService gs) {
		this.guestService = gs;
	}
	
	public ModelAndView test(HttpServletRequest request,HttpServletResponse response , ModelAndView mav){
		logger.severe("GuestController test ------------------------------------------");
		
		//ModelAndView mav= new ModelAndView();
		mav.addObject("request" , request);
		guestService.testing(mav);
		
		return mav;
	}
	
	public ModelAndView guestWrite(HttpServletRequest request,HttpServletResponse response){
		logger.severe("GuestController guestWrite ------------------------------------");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("request" , request);
		guestService.guestWrite(mav);
		
		return mav;
	}

	public ModelAndView guestWriteOk(HttpServletRequest request,
			HttpServletResponse response, GuestDto guestDto) {
		logger.severe("guestWriteOk --------------------------------------");
		logger.severe("guestDto Message : " + guestDto.getMessage());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("guestDto" , guestDto);
		guestService.guestWriteOk(mav);
		
		return mav;
	}
	
	public ModelAndView guestDelete(HttpServletRequest request,
			HttpServletResponse response){
		logger.severe("guestDelete --------------------");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("request" , request);
		guestService.guestDelete(mav);
		return mav;
	}
}
