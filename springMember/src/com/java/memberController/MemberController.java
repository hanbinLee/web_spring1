package com.java.memberController;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.java.memberDto.MemberDto;
import com.java.memberService.MemberService;

public class MemberController extends MultiActionController{
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	private MemberService memberService;
	
	public MemberController() {}
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	public ModelAndView test(HttpServletRequest request , HttpServletResponse response){
		logger.info("test");
		
		ModelAndView mav = new ModelAndView();
		memberService.test(mav);
		return mav;
	}
	
	public String register(HttpServletRequest request , HttpServletResponse response){
		logger.info("register");
		return "member/register";
	}
	
	public ModelAndView registerOk(HttpServletRequest request , HttpServletResponse response , MemberDto memberDto){
		logger.info("registerOk");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("memberDto" , memberDto);
		memberService.registerOk(mav);
		
		return mav;
	}
	
	public ModelAndView idCheck(HttpServletRequest request , HttpServletResponse response){
		logger.info("idCheck");
		
		ModelAndView mav = new ModelAndView("member/idCheck");
		mav.addObject("request" , request);
		
		memberService.idCheck(mav);
		return mav;
	}
	
	public ModelAndView zipcode(HttpServletRequest request , HttpServletResponse response){
		ModelAndView mav = new ModelAndView("member/zipcode");
		mav.addObject("request" , request);
		
		if(request.getParameter("zipcode") !=null) memberService.zipcode(mav);
		
		return mav;
	}
	
	public String login(HttpServletRequest request , HttpServletResponse response){
		return "member/login";
	}
	
	public ModelAndView loginOk(HttpServletRequest request , HttpServletResponse response){
		ModelAndView mav = new ModelAndView("member/loginOk");
		mav.addObject("request" , request);
		
		memberService.login(mav);
		
		return mav;
	}
	
	public String goMain(HttpServletRequest request , HttpServletResponse response){
		return "member/main";
	}
}
