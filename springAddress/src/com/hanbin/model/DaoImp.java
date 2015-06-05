package com.hanbin.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.hanbin.dto.Address;

public class DaoImp implements Dao{
	private SqlSessionTemplate sqlSession;
	
	public DaoImp(){}
	public DaoImp(SqlSessionTemplate sqlSession){
		this.sqlSession = sqlSession;
	}
	@Override
	public int write(Address address) {
		return sqlSession.insert("write" , address);
	}
	@Override
	public List<Address> select(String name) {
		return sqlSession.selectList("select" , name);
	}
	@Override
	public int delete(String name) {
		return sqlSession.delete("delete" , name );
	}
	@Override
	public Address search(String name) {
		return sqlSession.selectOne("search" , name);
	}
	@Override
	public int update(Address address) {
		return sqlSession.update("update" , address);
	}
	
	
	
}
