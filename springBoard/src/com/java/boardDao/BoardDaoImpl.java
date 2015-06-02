package com.java.boardDao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;

import com.java.boardDto.BoardDto;

public class BoardDaoImpl implements BoardDao{
	private SqlSessionTemplate sqlSession;
	
	public BoardDaoImpl() {}
	
	public BoardDaoImpl(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	public int boardGroupNumberMax() {
		return sqlSession.selectOne("groupNumberMax");
	}

	@Override
	public int boardGroupNumberUpdate(HashMap<String, Integer> hMap) {
		return sqlSession.update("groupNumberUpdate" , hMap);
	}

	@Override
	public int boardInsert(BoardDto boardDto) {
		return sqlSession.insert("boardInsert" , boardDto);
	}
	
	
}
