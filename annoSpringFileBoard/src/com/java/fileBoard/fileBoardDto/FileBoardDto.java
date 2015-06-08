package com.java.fileBoard.fileBoardDto;

import java.util.Date;
import java.util.HashMap;

public class FileBoardDto {
	private int boardNumber;   //�۹�ȣ ( �ڵ����� ��ȣ)
	private String writer;     //�ۼ���
	private String subject; //����
	private String email; //�̸���
	private String content; //����
	private String password; //���
	private Date writeDate; //�ۼ���
	private int readCount; //��ȸ��
	private String ip; //������
	private int groupNumber; //�׷��ȣ
	private int sequenceNumber; //�ۼ���
	private int sequenceLevel; //�� ����
	private String fileName;
	private String path;
	private long size;
	private HashMap<String , String> dataMap;
	
	public int getBoardNumber() {
		return boardNumber;
	}
	public void setBoardNumber(int boardNumber) {
		this.boardNumber = boardNumber;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getGroupNumber() {
		return groupNumber;
	}
	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}
	public int getSequenceNumber() {
		return sequenceNumber;
	}
	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
	public int getSequenceLevel() {
		return sequenceLevel;
	}
	public void setSequenceLevel(int sequenceLevel) {
		this.sequenceLevel = sequenceLevel;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public HashMap<String, String> getDataMap() {
		return dataMap;
	}
	public void setDataMap(HashMap<String, String> dataMap) {
		this.dataMap = dataMap;
	}
}
