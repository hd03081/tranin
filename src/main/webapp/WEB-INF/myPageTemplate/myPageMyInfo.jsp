<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section id="myPageMyInfo">
	<form accept-charset="UTF-8" id="myPageMyInfoForm" action="myPageMyInfoModify.jsp" method="post">
		<ul>
			<li>아이디 : <input type="text" name="myPageMyInfoId" value=""></li>
			<li>패스워드 : <input type="text" name="myPageMyInfoPassword" value=""></li>
			<li>패스워드 확인 : <input type="text" name="myPageMyInfoPasswordConfirm" value=""></li>
			<li>이름 : <input type="text" name="myPageMyInfoName" value=""></li>
			<li>별명 : <input type="text" name="myPageMyInfoNickName" value=""></li>
			<li>성별 : <input type="text" name="myPageMyInfoSex" value=""></li>
			<li>생일 : <input type="text" name="myPageMyInfoBirth" value=""></li>
			<li>휴대전화 : <input type="text" name="myPageMyInfoPhone" value=""></li>
			<li>집전화 : <input type="text" name="myPageMyInfoTel" value=""></li>
			<li>주소 : <input type="text" name="myPageMyAddress" value=""></li>
			<li>계좌번호 : <input type="text" name="myPageMyInfoAccountNo" value=""></li>
			<li><input type="button" name="myPageMyInfoModify" value="수정하기" accept="modifyMyPageInfo()"></li>
		</ul>
	</form>
</section>