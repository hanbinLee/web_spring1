package com.java.boardService;

import org.springframework.web.servlet.ModelAndView;

public interface BoardService {
	public void test(ModelAndView mav);
	public void boardWrite(ModelAndView mav);
	public void boardWriteOk(ModelAndView mav);
}
