package com.toy.runeah.simpleWebServlet.dto;

public class LoginDto {
	String memberID;
	String password;
	public LoginDto(String memberID, String password) {
		super();
		this.memberID = memberID;
		this.password = password;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginDto [memberID=" + memberID + ", password=" + password + "]";
	}
}
