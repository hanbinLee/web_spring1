package com.java.guestController;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.guestDto.GuestDto;
import com.java.guestService.GuestService;

@Controller
public class GuestController{
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	@Autowired //자동 set메소드 생성
	private GuestService guestService;
	
	@RequestMapping(value="/guest/test.do" ,  method=RequestMethod.GET)
	public ModelAndView test(HttpServletRequest request,HttpServletResponse response , ModelAndView mav){
		logger.severe("GuestController test ------------------------------------------");
		
		mav.addObject("request" , request);
		guestService.testing(mav);
		
		return mav;
	}
	
	@RequestMapping(value="/guest/write.do" , method=RequestMethod.GET)
	public ModelAndView guestWrite(HttpServletRequest request,HttpServletResponse response){
		logger.severe("GuestController guestWrite ------------------------------------");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("request" , request);
		guestService.guestWrite(mav);
		
		return mav;
	}
	
	@RequestMapping(value="/guest/writeOk.do" , method=RequestMethod.POST)
	public ModelAndView guestWriteOk(HttpServletRequest request,
			HttpServletResponse response, GuestDto guestDto) {
		logger.severe("guestWriteOk --------------------------------------");
		logger.severe("guestDto Message : " + guestDto.getMessage());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("guestDto" , guestDto);
		guestService.guestWriteOk(mav);
		
		return mav;
	}
	
	@RequestMapping(value="/guest/delete.do" , method=RequestMethod.GET)
	public ModelAndView guestDelete(HttpServletRequest request,
			HttpServletResponse response){
		logger.severe("guestDelete --------------------");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("request" , request);
		guestService.guestDelete(mav);
		return mav;
	}
	
	@RequestMapping(value="/guest/update.do", method=RequestMethod.GET)
	public ModelAndView guestSelect(HttpServletRequest request , HttpServletResponse response){
		logger.severe("guestSelect --------------------");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("request" , request);
		guestService.guestSelect(mav);
		return mav;
	}
	
	@RequestMapping(value="/guest/updateOk.do" , method=RequestMethod.POST)
	public ModelAndView guestUpdate(HttpServletRequest request , HttpServletResponse response,GuestDto guest){
		logger.severe("guestUpdate --------------------");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("request" , request);
		mav.addObject("guest" , guest);
		guestService.guestUpdate(mav);
		return mav;
	}
}
