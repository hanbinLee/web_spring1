package com.java.memberService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.java.memberDao.MemberDao;
import com.java.memberDto.MemberDto;
import com.java.memberDto.MemberZipcodeDto;

@Component
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDao memberDao;
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Override
	public void test(ModelAndView mav) {
		mav.addObject("msg" , "test");
		mav.setViewName("test/testing");
	}

	@Override
	public void registerOk(ModelAndView mav) {
		Map<String , Object> map = mav.getModelMap();
		MemberDto member = (MemberDto) map.get("memberDto");
		member.setMemberLevel("AA");
		member.setRegisterDate(new Date());
		
		int check = memberDao.register(member);
		logger.info("check : " + check);
		mav.addObject("check" , check);
	}

	@Override
	public void idCheck(ModelAndView mav) {
		Map<String , Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String id = request.getParameter("id");
		
		int check = memberDao.idCheck(id);
		mav.addObject("check" , check);
		mav.addObject("id" , id);
	}

	@Override
	public void zipcode(ModelAndView mav) {
		Map<String , Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String dong = request.getParameter("zipcode");
		List<MemberZipcodeDto> list = memberDao.getZipcode(dong);
		
		mav.addObject("list" , list);
	}

	@Override
	public void login(ModelAndView mav) {
		Map<String , Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		HashMap<String ,String> hMap = new HashMap<String , String>();
		hMap.put("id", request.getParameter("id"));
		hMap.put("password" , request.getParameter("password"));
		MemberDto member = memberDao.getLoginInfo(hMap);
		
		if(member !=null){
			mav.addObject("id" , member.getId());
			mav.addObject("memberLevel" , member.getMemberLevel());
		}
	}

	@Override
	public void update(ModelAndView mav) {
		Map<String , Object> map = mav.getModelMap();
		String id = (String) map.get("id");
		
	}
	
	
	
}
