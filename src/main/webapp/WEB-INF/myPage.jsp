<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,java.lang.*,com.toy.runeah.simpleWebServlet.dao.MainDao,com.toy.runeah.simpleWebServlet.dto.SignDto"%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>마이페이지</title>
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Lato:ital,wght@0,100;0,300;0,400;0,700;0,900;1,400&family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap"
      rel="stylesheet" />
    <link rel="stylesheet" href="assets/css/reset.css" />
    <link rel="stylesheet" href="assets/css/common.css" />
    <link rel="stylesheet" href="assets/css/footer.css" />
    <link rel="stylesheet" href="assets/css/myPage.css" />
    <script type="text/javascript" src="assets/js/jquery-3.6.1.js"></script>
    <script type="text/javascript" src="assets/js/jquery-migrate-1.4.1.min.js"></script>
    <script type="text/javascript" src="assets/js/jquery-ui.js"></script>
    <script src="assets/js/header.js" defer></script>
    <script src="assets/js/myPage.js" defer></script>
  </head>
  <body>
    <div id="upperSmallNav">
    <h1 class="hidden">기타관련</h1>
    <%! SignDto loginSession; %>
    <%
    loginSession = (SignDto)session.getAttribute("session_member");
    if(loginSession!=null){
    	out.print(
				"<a>"+
				loginSession.getNickName()
				);
		out.print("</a>");
		out.print("<a href='myPage'>마이페이지</a>");
		out.print("<a href=logOut class='logOut'>로그아웃</a>");
    }else{
        out.print("<a href=loginForm>로그인</a>");
        out.print("<a href=signForm>회원가입</a>");
    	out.print(
				"<article class='object'>"+
				"로그인 해주세요"
				);
		out.print("</article>");
    }
	%>
  </div>
  <div id="headerWrap">
    <header id="header">
      <h1 class="logo"><a href="./index.html">logo</a></h1>
      <nav id="gnb">
        <h2 class="hidden">주요이용메뉴</h2>
        <ul id="gnbList">
          <li class="gnbListChild"><a href="./sale.html">팝니다</a></li>
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
              <li><a href="./notice.html">공지사항</a></li>
              <li><a href="./FAQ.html">FAQ</a></li>
              <li><a href="#">신고하기</a></li>
            </ul>
          </li>
        </ul>
      </nav>
    </header>
  </div>
    <section id="rightQuick">
      <div class="rightQuickMenu">
        <h2 class="hidden">rightQuick</h2>
        <nav>
          <ul>
            <li>
              <a href="#">채팅상담</a>
            </li>
            <li>
              <a href="#">찜목록</a>
            </li>
            <li>
              <a href="#">장바구니</a>
            </li>
            <li id="rightSearch">
              <a href="#">검색</a>
            </li>
          </ul>
        </nav>
      </div>
      <section id="rightSearchPage">
        <form action="/mainSearch" method="get" id="searchWrap">
          <fieldset>
            <legend>검색하기</legend>
            <input type="text" name="keyword" placeholder="검색어를 입력하세요">
            <select name="searchCategory" id="cars">
              <option value="제목">제목</option>
              <option value="내용">내용</option>
              <option value="제목내용">제목+내용</option>
              <option value="글쓴이">글쓴이</option>
            </select>
            <input type="submit" value="검색">
          </fieldset>
        </form>
        <button id="rightSearchClose">검색창 닫기</button>
      </section>
    </section>
    <section id="myPageProfile">
      <h2>내 프로필</h3>
      <div>
      	<%
      		out.print("<img id='myPageProfilePicture' src='"+ request.getServletContext().getRealPath("/assets/image") + loginSession.getImageURL() +"' alt='내 프로필 사진'>");
      	%>
        <form id="myPageProfile" name="myPageProfile" action="profileUploadImage" method="post" enctype="multipart/form-data">
			    <input name="myPageProfileAttach" id="myPageProfileAttach" type="file">
		</form>
        <ul>
          <li>
	          <%
	      		out.print("<input id='myPageProfileNickName' type='text' name='myPageProfileNickName' value='"+ loginSession.getNickName() +"'>");
	      	  %>
          </li>
          <li>
         	  <%
	      		out.print("<input id='myPageProfileIntroduce' type='text' name='myPageProfileIntroduce' value='"+ loginSession.getStatusMessage() +"'>");
	      	  %>
          	
          </li>
        </ul>
      </div>
    </section>
    <section id="myPageTab">
      <h2>마이페이지</h2>
      <ul>
        <li class="active"><a>내 정보</a></li>
        <li><a>내 활동</a></li>
        <li><a>찜한 상품</a></li>
        <li><a>장바구니</a></li>
        <li><a>구매내역</a></li>
        <li><a>탈퇴하기</a></li>
        <li><a>차단하기</a></li>
        <li><a>관리자페이지</a></li>
        <!--jsp로 나중에 추가 <li><a href="">관리자 페이지</a></li> 누르면 아예 다른페이지로 이동하기-->
      </ul>
    </section>
    <!--탭누르면 카테고리별 파라미터 받아서 알맞은 myPageContent보여주기 -->
    <section id="myPageContent">

    </section>
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
    </div>
  </body>
</html>
