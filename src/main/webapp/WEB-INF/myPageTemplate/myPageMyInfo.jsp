<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,java.lang.*,com.toy.runeah.simpleWebServlet.dao.MainDao,com.toy.runeah.simpleWebServlet.dto.MemberDto"%>
<%! MemberDto loginSession; %>
<%
	loginSession = (MemberDto)session.getAttribute("session_member");
%>
<section id="myPageMyInfo">
	<form accept-charset="UTF-8" id="myPageMyInfoForm" action="myPageMyInfoModify" method="post">
		<ul>
			<li>아이디 : <input type="text" disabled name="myPageMyInfoId" value="<%=loginSession.getId()%>"></li>
			<li>패스워드 : <input type="password" disabled name="myPageMyInfoPassword" value="<%=loginSession.getPw()%>"></li>
			<li>패스워드 확인 : <input type="password" autocomplete="off" name="myPageMyInfoPasswordConfirm" value=""></li>
			<li>별명 : <input type="text" name="myPageMyInfoNickName" value="<%=loginSession.getNickName()%>"></li>
			<li>주소 : <input type="text" name="myPageMyAddress" value="<%=loginSession.getAddress()%>"></li>
			<li>우편번호 : <input type="text" name="myPageMyAddress" value="<%=loginSession.getZipCode()%>"></li>
			<li>휴대전화 : <input type="text" name="myPageMyInfoPhone" value="<%=loginSession.getPhone()%>"></li>
			<li>계좌은행 : <input type="text" name="myPageMyInfoAccountNo" value="<%=loginSession.getAccountName()%>"></li>
			<li>계좌번호 : <input type="text" name="myPageMyInfoAccountNo" value="<%=loginSession.getAccountNo()%>"></li>
			<li><input type="submit" name="myPageMyInfoModify" value="수정하기"></li>
		</ul>
	</form>
</section>