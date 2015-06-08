package com.java.fileBoard.fileBoardDao;

import java.util.logging.Logger;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileBoardDaoImpl implements FileBoardDao{
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final Logger logger = Logger.getLogger(this.getClass().getName());
}
