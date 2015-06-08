package com.java.guestDao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.guestDto.GuestDto;

@Component
public class GuestDaoImpl implements GuestDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
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
	
	@Override
	public GuestDto select(int num) {
		return sqlSession.selectOne("selectNum" , num);
	}

	public int update(GuestDto guestDto){
		return sqlSession.update("updateNum" , guestDto);
	}
	
}
