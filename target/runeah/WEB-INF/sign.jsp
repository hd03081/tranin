<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원가입</title>
  <script src="assets/js/signIn_Test.js" defer></script>
</head>
<body>
  <form action="#" name="signIn" method="post">
    <p> 아이디<br> 
      <input type="text" name="id">
      <input type="button" value="중복검사" onclick="overId()">
    </p>
    <p> 비밀번호<br><input type="password" name="passwd"></p>
    <p> 비밀번호 확인<br><input type="password" name="rePasswd"></p>
    <p> 이름<br><input type="text" name="name"></p>
    <p> 별명<br>
      <input type="text" name="nick"> 
      <input type="button" value="중복검사" onclick="overNick()">
    </p>
    <p> 성별 :
      <input type="radio" name="sex" value="남성" checked>남성
      <input type="radio" name="sex" value="여성">여성
    </p>
    <p> 생년월일<br>
      <input type="date" name="birthday">
    </p>
    <p> 연락처<br> 
      <select name="phone1">
        <option value="010">010</option>
        <option value="011">011</option>
      </select> -
      <input type="text" maxlength="4" size="4" name="phone2"> -
      <input type="text" maxlength="4" size="4" name="phone3">
    </p>
    <p>
   	  <input type="button" value="&lt; 이전" onClick="location.href = 'index.jsp' ">
      <input type="reset" value="다시쓰기">
      <input type="button" value="가입하기" onclick="signInFun()">
    </p>
  </form>
</body>
</html>