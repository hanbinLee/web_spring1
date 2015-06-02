package com.java.boardDao;

import java.util.HashMap;

import com.java.boardDto.BoardDto;

public interface BoardDao {
	public int boardGroupNumberMax();
	public int boardGroupNumberUpdate(HashMap<String,Integer> hMap);
	public int boardInsert(BoardDto boardDto);
}
