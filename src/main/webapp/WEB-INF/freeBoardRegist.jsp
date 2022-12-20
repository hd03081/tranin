<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>자유게시판 등록이에오!</title>
  <script src="assets/js/freeBoardRegist_Test.js" defer></script>
</head>
<body>
  <form action="freeBoardRegist" name="signIn" method="post">
    <p> 회원번호<br> 
      <input type="text" name="memberNo">
    </p>
    <p> 별명<br>
      <input type="text" name="nickName">
    </p>
    <p> 제목<br>
      <input type="text" name="title">
    </p>
    <p> 첨부파일URL<br>
      <input type="text" name="attachedImageURL">
    </p>
    <p> 내용<br>
      <input type="text" name="content"> 
    </p>
    <p>
      <input type="reset" value="다시쓰기">
      <input type="button" value="가입하기" onclick="signInFun()">
    </p>
  </form>
</body>
</html>