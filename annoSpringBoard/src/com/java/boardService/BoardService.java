package com.java.boardService;

import org.springframework.web.servlet.ModelAndView;

public interface BoardService {
	public void test(ModelAndView mav);
	public void boardWrite(ModelAndView mav);
	public void boardWriteOk(ModelAndView mav);
	public void boardList(ModelAndView mav);
	public void boardRead(ModelAndView mav);
	public void boardDelete(ModelAndView mav);
	public void boardDeleteOk(ModelAndView mav);
	public void boardUpdate(ModelAndView mav);
	public void boardUpdateOk(ModelAndView mav);
}
