package com.java.fileBoard.fileBoardService;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.fileBoard.fileBoardDao.FileBoardDao;

@Component
public class FileBoardServiceImpl implements FileBoardService{
	@Autowired
	private FileBoardDao fileBoardDao;
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	
}
