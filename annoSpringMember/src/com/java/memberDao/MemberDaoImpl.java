package com.java.memberDao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.memberDto.MemberDto;
import com.java.memberDto.MemberZipcodeDto;

@Component
public class MemberDaoImpl implements MemberDao{
	@Autowired
	private SqlSessionTemplate sqlSession;
		
	@Override
	public int register(MemberDto member) {
		return sqlSession.insert("dao.memberMapper.register" , member);
	}
	@Override
	public int idCheck(String id) {
		return sqlSession.selectOne("dao.memberMapper.idCheck" , id);
	}
	@Override
	public List<MemberZipcodeDto> getZipcode(String dong) {
		return sqlSession.selectList("dao.memberMapper.zipcode" , dong);
	}
	@Override
	public MemberDto getLoginInfo(HashMap<String, String> hMap) {
		return sqlSession.selectOne("dao.memberMapper.login" , hMap);
	}
	
	
}
