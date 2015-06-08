package com.java.memberDao;

import java.util.HashMap;
import java.util.List;

import com.java.memberDto.MemberDto;
import com.java.memberDto.MemberZipcodeDto;

public interface MemberDao {
	public int register(MemberDto member);

	public int idCheck(String id);

	public List<MemberZipcodeDto> getZipcode(String dong);

	public MemberDto getLoginInfo(HashMap<String,String> hMap);
}
