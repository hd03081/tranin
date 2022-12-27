package com.toy.runeah.simpleWebServlet.dto;

public class MemberDto {
	private int no;//11 no auto-increment
	private String id;//50 id not-null
	private String pw;//500 pw not-null
	private String nickName;//20 nickname not-null
	private String address;//100 address not-null
	private String zipCode;//5 zipcode not-null
	private String phone;//11 phone
	private String accountNo;//25 account_no
	private String accountName;//10 account_name
	private String statusMessage;//140 status_message
	private String profileImageURL;//200 profile_image_url
	public MemberDto() {}
	//회원가입용 컨스트럭터
	public MemberDto(String id, String pw, String nickName, String address, String zipCode) {
		this.id = id;
		this.pw = pw;
		this.nickName = nickName;
		this.address = address;
		this.zipCode = zipCode;
	}
	//로그인 세션용 컨스트럭터
	public MemberDto(int no, String id, String pw, String nickName, String address, String zipCode, String phone,
			String accountNo, String accountName, String statusMessage, String profileImageURL) {
		this.no = no;
		this.id = id;
		this.pw = pw;
		this.nickName = nickName;
		this.address = address;
		this.zipCode = zipCode;
		this.phone = phone;
		this.accountNo = accountNo;
		this.accountName = accountName;
		this.statusMessage = statusMessage;
		this.profileImageURL = profileImageURL;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public String getProfileImageURL() {
		return profileImageURL;
	}
	public void setProfileImageURL(String profileImageURL) {
		this.profileImageURL = profileImageURL;
	}
	@Override
	public String toString() {
		return "MemberDto [no=" + no + ", id=" + id + ", pw=" + pw + ", nickName=" + nickName + ", address=" + address
				+ ", zipCode=" + zipCode + ", phone=" + phone + ", accountNo=" + accountNo + ", accountName="
				+ accountName + ", statusMessage=" + statusMessage + ", profileImageURL=" + profileImageURL + "]";
	}
}
