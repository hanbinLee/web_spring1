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
		return mav;
	}
}
