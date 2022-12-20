package com.toy.runeah.simpleWebServlet.dto;

public class SignDto {
	private int memberNo;
	private String memberId;
	private String password;
	private String name;
	private String nickName;
	private String sex;
	private String birthYear;
	private String birthMonth;
	private String birthDay;
	private String phone1;
	private String phone2;
	private String phone3;
	private String phone4;
	private String phone5;
	private String phone6;
	private String zipCode;
	private String address1;
	private String address2;
	private String imageURL;
	private String statusMessage;
	public SignDto(int memberNo,String memberId, String password, String name, String nickName, String sex, String birthYear,
			String birthMonth, String birthDay, String phone1, String phone2, String phone3, String phone4,
			String phone5, String phone6, String zipCode, String address1, String address2, String imageURL,
			String statusMessage) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.password = password;
		this.name = name;
		this.nickName = nickName;
		this.sex = sex;
		this.birthYear = birthYear;
		this.birthMonth = birthMonth;
		this.birthDay = birthDay;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.phone4 = phone4;
		this.phone5 = phone5;
		this.phone6 = phone6;
		this.zipCode = zipCode;
		this.address1 = address1;
		this.address2 = address2;
		this.imageURL = imageURL;
		this.statusMessage = statusMessage;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}
	public String getBirthMonth() {
		return birthMonth;
	}
	public void setBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getPhone3() {
		return phone3;
	}
	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
	public String getPhone4() {
		return phone4;
	}
	public void setPhone4(String phone4) {
		this.phone4 = phone4;
	}
	public String getPhone5() {
		return phone5;
	}
	public void setPhone5(String phone5) {
		this.phone5 = phone5;
	}
	public String getPhone6() {
		return phone6;
	}
	public void setPhone6(String phone6) {
		this.phone6 = phone6;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	@Override
	public String toString() {
		return "SignDto [memberId=" + memberId + ", password=" + password + ", name=" + name + ", nickName=" + nickName
				+ ", sex=" + sex + ", birthYear=" + birthYear + ", birthMonth=" + birthMonth + ", birthDay=" + birthDay
				+ ", phone1=" + phone1 + ", phone2=" + phone2 + ", phone3=" + phone3 + ", phone4=" + phone4
				+ ", phone5=" + phone5 + ", phone6=" + phone6 + ", zipCode=" + zipCode + ", address1=" + address1
				+ ", address2=" + address2 + ", imageURL=" + imageURL + ", statusMessage=" + statusMessage + "]";
	}
}
