package com.toy.runeah.simpleWebServlet.dto;

import java.util.Date;

public class BoardDto {
	private int boardNo;
	private int memberNo;
	private String nickName;
	private String title;
	private Date regDate;
	private Date modDate;
	private String attachedImageURL;
	private String content;
	private int viewCount;
	private int thumbUpCount;
	public BoardDto(int memberNo,String nickName,String title,String attachedImageURL,String content) {
		super();
		this.memberNo=memberNo;
		this.nickName=nickName;
		this.title=title;
		this.attachedImageURL=attachedImageURL;
		this.content=content;
	}
	public BoardDto(int boardNo, String nickName, String title, Date regDate, int viewCount, int thumbUpCount) {
		super();
		this.boardNo = boardNo;
		this.nickName = nickName;
		this.title = title;
		this.regDate = regDate;
		this.viewCount = viewCount;
		this.thumbUpCount = thumbUpCount;
	}
	public BoardDto(int boardNo, int memberNo, String nickName, String title, Date regDate, Date modDate,
			String attachedImageURL, String content, int viewCount, int thumbUpCount) {
		super();
		this.boardNo = boardNo;
		this.memberNo = memberNo;
		this.nickName = nickName;
		this.title = title;
		this.regDate = regDate;
		this.modDate = modDate;
		this.attachedImageURL = attachedImageURL;
		this.content = content;
		this.viewCount = viewCount;
		this.thumbUpCount = thumbUpCount;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getModDate() {
		return modDate;
	}
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
	public String getAttachedImageURL() {
		return attachedImageURL;
	}
	public void setAttachedImageURL(String attachedImageURL) {
		this.attachedImageURL = attachedImageURL;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public int getThumbUpCount() {
		return thumbUpCount;
	}
	public void setThumbUpCount(int thumbUpCount) {
		this.thumbUpCount = thumbUpCount;
	}
	@Override
	public String toString() {
		return "BoardDto [boardNo=" + boardNo + ", memberNo=" + memberNo + ", nickName=" + nickName + ", title=" + title
				+ ", regDate=" + regDate + ", modDate=" + modDate + ", attachedImageURL=" + attachedImageURL
				+ ", content=" + content + ", viewCount=" + viewCount + ", thumbUpCount=" + thumbUpCount + "]";
	}
}
