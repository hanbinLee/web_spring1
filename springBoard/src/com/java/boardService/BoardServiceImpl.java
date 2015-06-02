package com.java.boardService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.java.boardDao.BoardDao;
import com.java.boardDto.BoardDto;

public class BoardServiceImpl implements BoardService {
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	private BoardDao boardDao;
	
	public BoardServiceImpl() {}
	public BoardServiceImpl(BoardDao boardDao){
		this.boardDao = boardDao;
	}
	
	@Override
	public void test(ModelAndView mav) {
		logger.info("--------------------Service Test------------------");
		
		mav.addObject("test" , "test");
		//InternalResourceViewResolver사용안하면 이렇게
		//mav.setViewName("/WEB-INF/test/test.jsp");
		mav.setViewName("test/test");
	}
	
	@Override
	public void boardWrite(ModelAndView mav) {
		logger.info("--------------------Service Write------------------");
		Map<String , Object> map = mav.getModel();
		
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		//Root 글일때 0 1 0 0
		int boardNumber = 0;
		int groupNumber = 1;
		int sequenceNumber = 0;
		int sequenceLevel = 0;
		
		//답글
		if(request.getParameter("boardNumber") != null){
			boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
			groupNumber = Integer.parseInt(request.getParameter("groupNumber"));
			sequenceNumber = Integer.parseInt(request.getParameter("sequenceNumber"));
			sequenceLevel = Integer.parseInt(request.getParameter("sequenceLevel"));
		}
		
		logger.warning("boardNumber : " + boardNumber);
		logger.warning("groupNumber : " + groupNumber);
		logger.warning("sequenceNumber : " + sequenceNumber);
		logger.warning("sequenceLevel : " + sequenceLevel);
		
		mav.addObject("boardNumber" , boardNumber);
		mav.addObject("groupNumber" , groupNumber);
		mav.addObject("sequenceNumber" , sequenceNumber);
		mav.addObject("sequenceLevel" , sequenceLevel);
		mav.setViewName("board/write");
	}
	
	@Override
	public void boardWriteOk(ModelAndView mav) {
		Map<String ,Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		BoardDto boardDto = (BoardDto) map.get("boardDto");
		
		this.boardWriteNumber(boardDto);
		
		boardDto.setWriteDate(new Date());
		boardDto.setReadCount(0);
		boardDto.setIp(request.getRemoteAddr());
		
		int check = boardDao.boardInsert(boardDto);
		logger.info("check" + check);
		mav.addObject("check" , check);
	}
	
	public void boardWriteNumber(BoardDto boardDto){
		int boardNumber = boardDto.getBoardNumber();
		int groupNumber = boardDto.getGroupNumber();
		int sequenceNumber = boardDto.getSequenceNumber();
		int sequenceLevel = boardDto.getSequenceLevel();
		
		logger.warning("boardNumber : " + boardNumber);
		logger.warning("groupNumber : " + groupNumber);
		logger.warning("sequenceNumber : " + sequenceNumber);
		logger.warning("sequenceLevel : " + sequenceLevel);
		
		int max = 0;
		if(boardNumber==0){
			//root
			max = boardDao.boardGroupNumberMax();
			if(max != 0){
				max+=1;
			}else{
				max = boardDto.getGroupNumber(); // 1
			}
			
			logger.info("max : " + max);
			
			groupNumber = max;
			sequenceNumber = boardDto.getSequenceNumber();
			sequenceLevel = boardDto.getSequenceLevel();
		}else{
			//답글
			HashMap<String , Integer> hMap = new HashMap<String ,Integer>();
			hMap.put("groupNumber", groupNumber);
			hMap.put("sequenceNumber", sequenceNumber);
			
			boardDao.boardGroupNumberUpdate(hMap);
			sequenceNumber+=1;
			sequenceLevel+=1;
		}
		
		boardDto.setGroupNumber(groupNumber);
		boardDto.setSequenceLevel(sequenceLevel);
		boardDto.setSequenceNumber(sequenceNumber);
	}
	
	
}
