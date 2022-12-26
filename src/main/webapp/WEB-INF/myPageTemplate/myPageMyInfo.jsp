<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,java.lang.*,com.toy.runeah.simpleWebServlet.dao.MainDao,com.toy.runeah.simpleWebServlet.dto.SignDto"%>
<%! SignDto loginSession; %>
<%
	loginSession = (SignDto)session.getAttribute("session_member");
%>
<section id="myPageMyInfo">
	<form accept-charset="UTF-8" id="myPageMyInfoForm" action="myPageMyInfoModify" method="post">
		<ul>
			<li>아이디 : <input type="text" disabled name="myPageMyInfoId" value="<%=loginSession.getMemberId()%>"></li>
			<li>패스워드 : <input type="password" disabled name="myPageMyInfoPassword" value="<%=loginSession.getPassword()%>"></li>
			<li>패스워드 확인 : <input type="password" autocomplete="off" name="myPageMyInfoPasswordConfirm" value=""></li>
			<li>이름 : <input type="text" name="myPageMyInfoName" value="<%=loginSession.getName()%>"></li>
			<li>별명 : <input type="text" name="myPageMyInfoNickName" value="<%=loginSession.getNickName()%>"></li>
			<li>성별 : <input type="text" name="myPageMyInfoSex" value="<%=loginSession.getSex()%>"></li>
			<li>생일 : <input type="text" name="myPageMyInfoBirth" value="<%=loginSession.getBirthYear()+"/"+loginSession.getBirthMonth()+"/"+loginSession.getBirthDay()%>"></li>
			<li>휴대전화 : <input type="text" name="myPageMyInfoPhone" value="<%=loginSession.getPhone1()+"-"+loginSession.getPhone2()+"-"+loginSession.getPhone3()%>"></li>
			<li>집전화 : <input type="text" name="myPageMyInfoTel" value="<%=loginSession.getPhone4()+"-"+loginSession.getPhone5()+"-"+loginSession.getPhone6()%>"></li>
			<li>주소 : <input type="text" name="myPageMyAddress" value="<%=loginSession.getAddress1()+"/"+loginSession.getAddress2()+"/"+loginSession.getZipCode()%>"></li>
			<li>계좌번호 : <input type="text" name="myPageMyInfoAccountNo" value="<%="계좌번호에오" %>"></li>
			<li><input type="submit" name="myPageMyInfoModify" value="수정하기"></li>
		</ul>
	</form>
</section>