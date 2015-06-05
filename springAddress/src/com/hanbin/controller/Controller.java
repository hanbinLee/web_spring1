package com.hanbin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.hanbin.dto.Address;
import com.hanbin.service.Service;

public class Controller extends MultiActionController{
	private Service service;
	
	public Controller(){}
	public Controller(Service service){
		this.service = service;
	}
	
	public String write(HttpServletRequest request , HttpServletResponse response){
		return "write";
	}
	
	public ModelAndView writeOk(HttpServletRequest request , HttpServletResponse response , Address address){
		super.logger.info("writeOk");
		
		ModelAndView mav = new ModelAndView("writeOk");
		mav.addObject("address" , address);
		service.write(mav);
		
		return mav;
	}
	
	public String select(HttpServletRequest request , HttpServletResponse response){
		return "select";
	}
	
	public ModelAndView selectOk(HttpServletRequest request , HttpServletResponse response){
		super.logger.info("selectOk");
		
		ModelAndView mav = new ModelAndView("selectOk");
		mav.addObject("request" , request);
		service.selectOk(mav);
		
		return mav;
	}
	
	public String delete(HttpServletRequest request , HttpServletResponse response){
		return "delete";
	}
	
	public ModelAndView deleteOk(HttpServletRequest request , HttpServletResponse response){
		ModelAndView mav = new ModelAndView("deleteOk");
		mav.addObject("request" ,request);
		service.delete(mav);
		
		return mav;
	}
	
	public ModelAndView update(HttpServletRequest request , HttpServletResponse response){
		ModelAndView mav = new ModelAndView("update");
		mav.addObject("request" , request);
		service.update(mav);
		
		return mav;
	}
	
	public ModelAndView updateOk(HttpServletRequest request , HttpServletResponse response , Address address){
		ModelAndView mav = new ModelAndView("updateOk");
		mav.addObject("address" , address);
		service.updateOk(mav);
		
		return mav;
	}
}
