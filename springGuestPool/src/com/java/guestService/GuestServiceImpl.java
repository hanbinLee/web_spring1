package com.java.guestService;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.java.guestDao.GuestDao;
import com.java.guestDto.GuestDto;

@Component
public class GuestServiceImpl implements GuestService{
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	@Autowired
	private GuestDao guestDao;
	
	public void testing(ModelAndView mav) {
		logger.severe("GuestServiceImpl testing Start");	
		
		//요청값을 가지고 DB 작업
		mav.addObject("msg" , "hahaha");
		mav.setViewName("test/testOk");
	}

	@Override
	public void guestWrite(ModelAndView mav) {
		logger.severe("GuestServiceImpl guestWrite Start");
		
		Map<String , Object> map = mav.getModelMap();
		HttpServletRequest request =(HttpServletRequest) map.get("request");
		
		String pageNumber = request.getParameter("pageNumber");
		
		if(pageNumber==null) pageNumber = "1";
		
		int currentPage = Integer.parseInt(pageNumber);
		logger.severe("currentPage : " + currentPage);
		
		//전체레코드수 , 현재번호의 시작번호 , 끝번호 -- DataBase 
		int count = guestDao.getGuestCount();
		logger.severe("count : " + count);
		
		int boardSize = 3;
		int startRow = (currentPage-1)*boardSize+1;
		int endRow = currentPage*boardSize;
		
		logger.severe("startRow : " + startRow + "endRow : " + endRow);
		
		List<GuestDto> guestList = null;
		
		if(count > 0) guestList = guestDao.getGuestList(startRow , endRow);
		
		logger.severe("guestList Size: " + guestList.size());
		
		mav.addObject("guestList" , guestList);
		mav.addObject("count" , count);
		mav.addObject("boardSize" , boardSize);
		mav.addObject("currentPage" , currentPage);
		//mav.addObject("pageNumber" , pageNumber);
		mav.setViewName("guest/write");
	}

	@Override
	public void guestWriteOk(ModelAndView mav) {
		Map<String , Object> map = mav.getModelMap();
		GuestDto guestDto = (GuestDto) map.get("guestDto");
		guestDto.setWriteDate(new Date());
		
		int check = guestDao.insert(guestDto);
		logger.info("check : " + check);
		
		mav.addObject("check", check);
		mav.setViewName("guest/writeOk");
	}

	@Override
	public void guestDelete(ModelAndView mav) {
		Map<String , Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int num=Integer.parseInt(request.getParameter("num"));
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		
		int check = guestDao.delete(num);
		logger.info("delete check : " + check);
		
		mav.addObject("check" , check);
		mav.addObject("pageNumber" , pageNumber);
		mav.setViewName("guest/delete");
	}
	
	
	@Override
	public void guestSelect(ModelAndView mav) {
		Map<String , Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int num=Integer.parseInt(request.getParameter("num"));
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		
		GuestDto guestDto = guestDao.select(num);
		mav.addObject("guest" , guestDto);
		mav.addObject("pageNumber" , pageNumber);
		mav.setViewName("guest/update");
	}

	@Override
	public void guestUpdate(ModelAndView mav) {
		Map<String , Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		GuestDto guest = (GuestDto) map.get("guest");
		
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));	
		int check = guestDao.update(guest);
		mav.addObject("check" , check);
		mav.addObject("pageNumber" , pageNumber);
		mav.setViewName("guest/updateOk");
	}
	
	
	
}
