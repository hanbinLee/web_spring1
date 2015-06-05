package com.java.memberService;

import org.springframework.web.servlet.ModelAndView;

public interface MemberService {
	public void test(ModelAndView mav);
	public void registerOk(ModelAndView mav);
	public void idCheck(ModelAndView mav);
	public void zipcode(ModelAndView mav);
	public void login(ModelAndView mav);
	public void update(ModelAndView mav);

}
