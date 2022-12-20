<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="assets/css/reset.css">
    <link rel="stylesheet" href="assets/css/footer.css">
    <link rel="stylesheet" href="assets/css/common.css">
    <link rel="stylesheet" href="assets/css/login.css">
    <script src="assets/js/login.js" defer></script>
    <!--  <script src="assets/js/header.js" defer></script>-->
</head>
<body>
    <div id="upperSmallNav">
        <h1 class="hidden">기타관련</h1>
        <a href="#">회원가입</a>
      </div>
      <div id="headerWrap">
        <header id="header">
          <h1 class="logo"><a href="./index.html">logo</a></h1>
          <nav id="gnb">
            <h2 class="hidden">주요이용메뉴</h2>
            <ul id="gnbList">
              <li class="gnbListChild"><a href="#">팝니다</a></li>
              <li class="gnbListChild"><a href="#">삽니다</a></li>
              <li class="gnbListChild"><a href="#">커뮤니티</a>
                <ul class="snb">
                  <li><a href="#">후기</a></li>
                  <li><a href="#">인기글</a></li>
                  <li><a href="#">자유게시판</a></li>
                  <li><a href="#">정보게시판</a></li>
                </ul>
              </li>
              <li class="gnbListChild"><a href="#">고객센터</a>
                <ul class="snb">
                  <li><a href="#">공지사항</a></li>
                  <li><a href="#">FAQ</a></li>
                  <li><a href="#">신고하기</a></li>
                </ul>
              </li>
            </ul>
          </nav>
        </header>
      </div>
    <div id="loginWrap_sh">
      <div id="login_sh">
        <h1>회원가입</h1>
        <form action="login" method="post" name="member_insert">
          <div id="listWrap_sh">
            <ul id="list_sh">
                <li><span>아이디</span><input type="text" placeholder=" 아이디" name="memberId" id="id_sh"></li>
                <li><span>비밀번호</span><input type="password" placeholder=" 비밀번호" name="password" id="password_sh"></li>
                <div id="check_sh"></div>
                <div id="checkBox_sh">
                <li>자동 로그인 <input id="autoLogin" type="checkbox" name="autoLogin"></li>
                <li>아이디 저장 <input type="checkbox"></li>
              </div>
                <li><span>로그인</span><input id="loginBtn" type="button" value="로그인" onClick="submit()"></li>           
            </ul>
          </div>
        </form>
        <div id="linkList_sh">
        <a href="#">로그인/비밀번호 찾기</a>                
        <a href="#">회원가입</a>    
      </div>   
      <div id="alterLogin_sh">
        <div id="naver_sh">네이버 로그인</div>  
        <div id="kakao_sh">카카오 로그인</div>
      </div>   
      </div>
    </div>
      <div class="footerWrap page onePage6">
        <footer class="page8" id="footer">
          <p class="us">about us</p>
          <div id="membersWrap">
            <p class="member0_sh member_sh"><a href="#" target="_blank">개인정보처리방침</a></p>
            <p class="member1_sh member_sh"><a href="hyehyun.html" target="_blank">김혜현</a></p>
            <p class="member2_sh member_sh"><a href="beomsu.html" target="_blank">오범수</a></p>
            <p class="member3_sh member_sh"><a href="haejun.html" target="_blank">오해준</a></p>
            <p class="member4_sh member_sh"><a href="https://suhyun980716.github.io/LandingPage/Landing%20Page/index.html" target="_blank">유수현</a></p>
            <p class="member5_sh member_sh"><a href="https://github.com/hyeahyun2/TeamProject" target="_blank">GitHub</a></p>
          </div>
        </footer>
</body>
</html>