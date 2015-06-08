package com.java.memberController;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.memberDto.MemberDto;
import com.java.memberService.MemberService;

@Controller
public class MemberController{
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/member/test.do" , method=RequestMethod.GET)
	public ModelAndView test(HttpServletRequest request , HttpServletResponse response){
		logger.info("test");
		
		ModelAndView mav = new ModelAndView();
		memberService.test(mav);
		return mav;
	}
	
	@RequestMapping(value="/member/register.do",method=RequestMethod.GET)
	public String register(HttpServletRequest request , HttpServletResponse response){
		logger.info("register");
		return "member/register";
	}
	
	@RequestMapping(value="/member/register.do",method=RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request , HttpServletResponse response , MemberDto memberDto){
		logger.info("registerOk");
		
		ModelAndView mav = new ModelAndView("member/registerOk");
		mav.addObject("memberDto" , memberDto);
		memberService.registerOk(mav);
		
		return mav;
	}
	
	@RequestMapping(value="/member/idCheck.do" , method=RequestMethod.GET)
	public ModelAndView idCheck(HttpServletRequest request , HttpServletResponse response){
		logger.info("idCheck");
		
		ModelAndView mav = new ModelAndView("member/idCheck");
		mav.addObject("request" , request);
		
		memberService.idCheck(mav);
		return mav;
	}
	
	@RequestMapping(value="/member/zipcode.do" , method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView zipcode(HttpServletRequest request , HttpServletResponse response){
		ModelAndView mav = new ModelAndView("member/zipcode");
		mav.addObject("request" , request);
		
		if(request.getParameter("zipcode") !=null) memberService.zipcode(mav);
		
		return mav;
	}
	
	@RequestMapping(value="/member/login.do" , method=RequestMethod.GET)
	public String login(HttpServletRequest request , HttpServletResponse response){
		return "member/login";
	}
	
	@RequestMapping(value="/member/loginOk.do" , method=RequestMethod.POST)
	public ModelAndView loginOk(HttpServletRequest request , HttpServletResponse response){
		ModelAndView mav = new ModelAndView("member/loginOk");
		mav.addObject("request" , request);
		
		memberService.login(mav);
		
		return mav;
	}
	
	@RequestMapping(value="/member/update.do" , method=RequestMethod.GET)
	public ModelAndView update(HttpServletRequest request , HttpServletResponse response){
		logger.info("update");
		ModelAndView mav = new ModelAndView("member/update");
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		mav.addObject("id" , id);
		
		memberService.update(mav);
		return mav;
	}
}
