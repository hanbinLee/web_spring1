package com.java.guestDao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.java.guestDto.GuestDto;

public class GuestDaoImpl implements GuestDao {
	private SqlSessionTemplate sqlSession;
	
	public GuestDaoImpl() {}
	
	public GuestDaoImpl(SqlSessionTemplate sqlSession){
		this.sqlSession = sqlSession;
	}

	@Override
	public int getGuestCount() {
		return sqlSession.selectOne("guestCount");
	}

	@Override
	public List<GuestDto> getGuestList(int startRow, int endRow) {
		HashMap<String , Integer> hMap = new HashMap<String , Integer>();
		hMap.put("startRow" , startRow);
		hMap.put("endRow" , endRow);
		return sqlSession.selectList("guestList" , hMap);
	}

	@Override
	public int insert(GuestDto guestDto) {
		return sqlSession.insert("insertGuestDto" , guestDto);
	}

	@Override
	public int delete(int num) {
		return sqlSession.delete("deleteNum" , num);
	}
	
	
	
}
