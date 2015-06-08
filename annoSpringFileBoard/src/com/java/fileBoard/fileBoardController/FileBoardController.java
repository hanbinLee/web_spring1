package com.java.fileBoard.fileBoardController;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.fileBoard.fileBoardDto.FileBoardDto;
import com.java.fileBoard.fileBoardService.FileBoardService;

@Controller
public class FileBoardController {
	@Autowired
	private FileBoardService fileBoardService;
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	@RequestMapping(value="fileBoard/write.do" , method=RequestMethod.GET)
	public ModelAndView write(HttpServletRequest request , HttpServletResponse response){
		logger.info("Controller write");
		ModelAndView mav = new ModelAndView("fileBoard/write");
		return mav;
	}
	
	@RequestMapping(value="fileBoard/write.do" , method=RequestMethod.POST)
	public ModelAndView write(HttpServletRequest request , HttpServletResponse response , FileBoardDto fileBoardDto){
		logger.info("writeInfo");
		ModelAndView mav = new ModelAndView("fileBoard/writeOk");
		return mav;
	}
}
