package com.java.boardController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.java.boardDto.BoardDto;
import com.java.boardService.BoardService;

public class BoardController extends MultiActionController{
	private BoardService boardService;
	
	public BoardController() {}
	
	public BoardController(BoardService boardService){
		this.boardService = boardService;
	}
	
	public ModelAndView test(HttpServletRequest request , HttpServletResponse response){
		super.logger.info("-----------------------Controller test--------------------------");
		
		ModelAndView mav = new ModelAndView();
		boardService.test(mav);
		
		return mav;
	}
	
	public ModelAndView boardWrite(HttpServletRequest request , HttpServletResponse response){
		super.logger.info("-----------------------Controller Write--------------------------");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("request" , request);
		boardService.boardWrite(mav);
		
		return mav;
	}
	
	public ModelAndView boardWriteOk(HttpServletRequest request , HttpServletResponse response , BoardDto boardDto){
		//BoardDto 는 Jsp:useBean형태로 넘어오기때문에 사용가능
		super.logger.info("-----------------------Controller WriteOk--------------------------");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("request" , request);
		mav.addObject("boardDto" , boardDto);
		boardService.boardWriteOk(mav);
		
		logger.info(mav.getViewName());
		return mav;
	}
	
	public ModelAndView boardList(HttpServletRequest request , HttpServletResponse response){
		super.logger.info("-----------------------Controller boardList--------------------------");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("request" , request);
		boardService.boardList(mav);
		return mav;
	}
	
	public ModelAndView boardRead(HttpServletRequest request , HttpServletResponse response){
		super.logger.info("-----------------------Controller boardRead--------------------------");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("request" , request);
		boardService.boardRead(mav);
		return mav;
	}
	
	public ModelAndView boardDelete(HttpServletRequest request , HttpServletResponse response){
		super.logger.info("-----------------------Controller delete--------------------------");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("request" , request);
		boardService.boardDelete(mav);
		return mav;
	}
	
	public ModelAndView boardDeleteOk(HttpServletRequest request , HttpServletResponse response){
		super.logger.info("-----------------------Controller deleteOk--------------------------");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("request" , request);
		boardService.boardDeleteOk(mav);
		return mav;
	}
	
	public ModelAndView boardUpdate(HttpServletRequest request , HttpServletResponse response){
		super.logger.info("-----------------------Controller update--------------------------");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("request" , request);
		boardService.boardUpdate(mav);
		
		return mav;
	}
	
	public ModelAndView boardUpdateOk(HttpServletRequest request , HttpServletResponse response , BoardDto boardDto){
		super.logger.info("-----------------------Controller UpdateOk--------------------------");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("request" , request);
		mav.addObject("boardDto" , boardDto);
		boardService.boardUpdateOk(mav);
		
		return mav;
	}
}
