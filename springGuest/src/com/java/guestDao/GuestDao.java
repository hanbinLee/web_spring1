package com.java.guestDao;

import java.util.List;

import com.java.guestDto.GuestDto;

public interface GuestDao {
	public int getGuestCount();
	public List<GuestDto> getGuestList(int startRow , int endRow);
	public int insert(GuestDto guestDto);
	public int delete(int num);
}
