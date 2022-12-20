<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,java.lang.*,com.toy.runeah.simpleWebServlet.dao.MainDao,com.toy.runeah.simpleWebServlet.dto.SignDto"%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang="ko" dir="ltr">

<head>
  <meta charset="utf-8" />
  <title>포트폴리오</title>
  <link rel="preconnect" href="https://fonts.googleapis.com" />
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
  <link
    href="https://fonts.googleapis.com/css2?family=Lato:ital,wght@0,100;0,300;0,400;0,700;0,900;1,400&family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap"
    rel="stylesheet" />
  <link rel="stylesheet" href="assets/css/index.css" />
  <script type="text/javascript" src="assets/js/jquery-3.6.1.js"></script>
  <script type="text/javascript" src="assets/js/jquery-migrate-1.4.1.min.js"></script>
  <script type="text/javascript" src="assets/js/jquery-ui.js"></script>
  <script src="assets/js/common.js" defer></script>
  <script src="assets/js/header.js" defer></script>
  <script src="assets/js/onePage.js" defer></script>
  <script src="assets/js/section1.js" defer></script>
  <script src="assets/js/section4.js" defer></script>
  <script src="assets/js/section3.js" defer></script>
</head>

<body>
  <div id="upperSmallNav">
    <h1 class="hidden">기타관련</h1>
    <%
	SignDto loginSession = (SignDto)session.getAttribute("session_member");
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
  <main>
    <div class="leftNav">
      <h2 class="hidden">페이지넘버</h2>
      <ul class="count">
        <li><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">5</a></li>
        <li><a href="#">6</a></li>
        <li><a href="#">6</a></li>
        <li><a href="#">6</a></li>
      </ul>
      <span id="headerBar"></span>
    </div>
    <section class="mainslider onePage1">
      <h2 class="hidden">프로모션</h2>
      <div id="mainsliderBtn">
        <button id="mainslide_btnPrev">이전 슬라이더</button>
        <button id="mainslide_btnNext">다음 슬라이더</button>
      </div>
      <ul class="page1_slides">
        <li class="page1_1 active">
        </li>
        <li class="page1_2">
        </li>
        <li class="page1_3">
        </li>
        <li class="page1_4">
        </li>
      </ul>
    </section>
    <!-- 유수현 영역1 시작 -->
    <section class="page2Wrap_sh pageWrap_sh onePage2">
      <div class="page2 page">
        <div id="pcNotice">
          <button class="on">PC</button>
          <p>쉽고 간편하게! <br> 트레닌에서 닌텐도를 <br> 중고로 거래하세요!</p>
        </div>
        <div id="PCBtnWrap_sh" class="see">
          <button class="PCBtn_sh">이용안내 넘기기</button>
        </div>
        <div id="PCSliderWrap_sh" class="see">
          <img src="assets/sh_images/pc.svg" alt="PC의 모습" class="img">
          <ul class="PCSlider1_sh">
            <li class="PCSlider_sh PCSlider1"><a href="#">회원가입</a></li>
            <li class="PCSlider_sh PCSlider2"><a href="#">글 작성</a></li>
            <li class="PCSlider_sh PCSlider3"><a href="#">상품 올리기</a></li>
            <li class="PCSlider_sh PCSlider4"><a href="#">거래 완료</a></li>
            <li class="PCSlider_sh PCSlider5"><a href="#">후기 올리기</a></li>
          </ul>
        </div>
        <div id="mobileNotice">
          <button>mobile</button>
        </div>
        <div id="MBtnWrap_sh">
          <button class="MBtn_sh">이용안내 넘기기</button>
        </div>
        <div id="MSliderWrap_sh" class="unsee">
          <img src="assets/sh_images/phone.svg" alt="mobile의 모습" class="img">
          <ul class="MSlider_sh">
            <li class="MSlider MSlider1"><a href="#">회원가입</a></li>
            <li class="MSlider MSlider2"><a href="#">글 작성</a></li>
            <li class="MSlider MSlider3"><a href="#">상품 올리기</a></li>
            <li class="MSlider MSlider4"><a href="#">거래 완료</a></li>
            <li class="MSlider MSlider5"><a href="#">후기 올리기</a></li>
          </ul>
        </div>
      </div>
    </section>
    <!-- 유수현 영역1 끝 -->
    <section class="Wrap_hj page3 page onePage3">
      <div class="firstDiv_hj">
        <div id="headerWrap_hj">
          <h2 class="Header3_hj">최근 올라온 판매 상품!</h2>
          <a href="#" class="more_hj">더보기</a>
        </div>
        <div id="SliderWrap_hj">
          <ul class="Slider_hj">
            <li>
              <a href="#">
                <div>
                  이미지
                </div>
                <p class="title_hj">닌텐도 팝니다!1</p>
                <p>2021년도 상품이고, 거의 새거입니다.</p>
              </a>
            </li>
            <li>
              <a href="#">
                <div>
                  이미지
                </div>
                <p class="title_hj">닌텐도 팝니다!2</p>
                <p>2021년도 상품이고, 거의 새거입니다.</p>
              </a>
            </li>
            <li>
              <a href="#">
                <div>
                  이미지
                </div>
                <p class="title_hj">닌텐도 팝니다!3</p>
                <p>2021년도 상품이고, 거의 새거입니다.</p>
              </a>
            </li>
            <li>
              <a href="#">
                <div>
                  이미지
                </div>
                <p class="title_hj">닌텐도 팝니다!4</p>
                <p>2021년도 상품이고, 거의 새거입니다.</p>
              </a>
            </li>
            <li>
              <a href="#">
                <div>
                  이미지
                </div>
                <p class="title_hj">닌텐도 팝니다!5</p>
                <p>2021년도 상품이고, 거의 새거입니다.</p>
              </a>
            </li>
            <li>
              <a href="#">
                <div>
                  이미지
                </div>
                <p class="title_hj">닌텐도 팝니다!6</p>
                <p>2021년도 상품이고, 거의 새거입니다.</p>
              </a>
            </li>
            <li>
              <a href="#">
                <div>
                  이미지
                </div>
                <p class="title_hj">닌텐도 팝니다!7</p>
                <p>2021년도 상품이고, 거의 새거입니다.</p>
              </a>
            </li>
            <li>
              <a href="#">
                <div>
                  이미지
                </div>
                <p class="title_hj">닌텐도 팝니다!8</p>
                <p>2021년도 상품이고, 거의 새거입니다.</p>
              </a>
            </li>
          </ul>
        </div>
        <div id="btnWrap_hj">
          <button class="prev_hj">이전</button>
          <button class="next_hj">다음</button>
        </div>
      </div>
    </section>
    </section>
    <section class="page4 page onePage4">
      <ul class="Category_sec4">
        <li class="check_gory">후기글</li>
        <li>자유게시판</li>
        <li>공략게시판</li>
      </ul>
      <div class="Post_sec4">
        <div>
          <h5>후기글</h5>
          <ul class="review_sec4 check_sec4">
            <li class="List_sec4">
              <a href="#" class="Img_sec4">후기글사진1</a>
              <dl>
                <dt><a href="#">후기글제목1</a></dt>
                <dd class="nick_sec4">별명1</dd>
                <dd class="date_Num_sec4"></dd>
              </dl>
            </li>
            <li class="List_sec4">
              <a href="#" class="Img_sec4">후기글사진2</a>
              <dl>
                <dt><a href="#">후기글제목2</a></dt>
                <dd class="nick_sec4">별명2</dd>
                <dd class="date_Num_sec4"></dd>
              </dl>
            </li>
            <li class="List_sec4">
              <a href="#" class="Img_sec4">후기글사진3</a>
              <dl>
                <dt><a href="#">후기글제목3</a></dt>
                <dd class="nick_sec4">별명3</dd>
                <dd class="date_Num_sec4"></dd>
              </dl>
            </li>
            <li class="List_sec4">
              <a href="#" class="Img_sec4">후기글사진4</a>
              <dl>
                <dt><a href="#">후기글제목4</a></dt>
                <dd class="nick_sec4">별명4</dd>
                <dd class="date_Num_sec4"></dd>
              </dl>
            </li>
            <li class="List_sec4">
              <a href="#" class="Img_sec4">후기글사진5</a>
              <dl>
                <dt><a href="#">후기글제목5</a></dt>
                <dd class="nick_sec4">별명5</dd>
                <dd class="date_Num_sec4"></dd>
              </dl>
            </li>
            <li class="List_sec4">
              <a href="#" class="Img_sec4">후기글사진6</a>
              <dl>
                <dt><a href="#">후기글제목6</a></dt>
                <dd class="nick_sec4">별명6</dd>
                <dd class="date_Num_sec4"></dd>
              </dl>
            </li>
          </ul>
          <ul class="free_sec4">
            <li class="List_sec4">
              <a href="#" class="Img_sec4">자유글사진1</a>
              <dl>
                <dt><a href="#">자유글제목1</a></dt>
                <dd class="nick_sec4">별명1</dd>
                <dd class="date_Num_sec4"></dd>
              </dl>
            </li>
            <li class="List_sec4">
              <a href="#" class="Img_sec4">자유글사진2</a>
              <dl>
                <dt><a href="#">자유글제목2</a></dt>
                <dd class="nick_sec4">별명2</dd>
                <dd class="date_Num_sec4"></dd>
              </dl>
            </li>
            <li class="List_sec4">
              <a href="#" class="Img_sec4">자유글사진3</a>
              <dl>
                <dt><a href="#">자유글제목3</a></dt>
                <dd class="nick_sec4">별명3</dd>
                <dd class="date_Num_sec4"></dd>
              </dl>
            </li>
            <li class="List_sec4">
              <a href="#" class="Img_sec4">자유글사진4</a>
              <dl>
                <dt><a href="#">자유글제목4</a></dt>
                <dd class="nick_sec4">별명4</dd>
                <dd class="date_Num_sec4"></dd>
              </dl>
            </li>
            <li class="List_sec4">
              <a href="#" class="Img_sec4">자유글사진5</a>
              <dl>
                <dt><a href="#">자유글제목5</a></dt>
                <dd class="nick_sec4">별명5</dd>
                <dd class="date_Num_sec4"></dd>
              </dl>
            </li>
            <li class="List_sec4">
              <a href="#" class="Img_sec4">자유글사진6</a>
              <dl>
                <dt><a href="#">자유글제목6</a></dt>
                <dd class="nick_sec4">별명6</dd>
                <dd class="date_Num_sec4"></dd>
              </dl>
            </li>
          </ul>
          <ul class="info_sec4">
            <li class="List_sec4">
              <a href="#" class="Img_sec4">정보글사진1</a>
              <dl>
                <dt><a href="#">정보글제목1</a></dt>
                <dd class="nick_sec4">별명1</dd>
                <dd class="date_Num_sec4"></dd>
              </dl>
            </li>
            <li class="List_sec4">
              <a href="#" class="Img_sec4">정보글사진2</a>
              <dl>
                <dt><a href="#">정보글제목2</a></dt>
                <dd class="nick_sec4">별명2</dd>
                <dd class="date_Num_sec4"></dd>
              </dl>
            </li>
            <li class="List_sec4">
              <a href="#" class="Img_sec4">정보글사진3</a>
              <dl>
                <dt><a href="#">정보글제목3</a></dt>
                <dd class="nick_sec4">별명3</dd>
                <dd class="date_Num_sec4"></dd>
              </dl>
            </li>
            <li class="List_sec4">
              <a href="#" class="Img_sec4">정보글사진4</a>
              <dl>
                <dt><a href="#">정보글제목4</a></dt>
                <dd class="nick_sec4">별명4</dd>
                <dd class="date_Num_sec4"></dd>
              </dl>
            </li>
            <li class="List_sec4">
              <a href="#" class="Img_sec4">정보글사진5</a>
              <dl>
                <dt><a href="#">정보글제목5</a></dt>
                <dd class="nick_sec4">별명5</dd>
                <dd class="date_Num_sec4"></dd>
              </dl>
            </li>
            <li class="List_sec4">
              <a href="#" class="Img_sec4">정보글사진6</a>
              <dl>
                <dt><a href="#">정보글제목6</a></dt>
                <dd class="nick_sec4">별명6</dd>
                <dd class="date_Num_sec4"></dd>
              </dl>
            </li>
          </ul>
        </div>
      </div>
    </section>
    <section class="page5 page onePage5">
      <div>
        <div id="noticeWrap_hj">
          <h2 class="Header_hj"><span>공지사항</span></h2>
          <ul class="noticeUl_hj">
            <li>
              <p>4</p>
              <p><a href="#">공지사항입니다.</a></p>
              <p>조회수</p>
            </li>
            <li>
              <p>3</p>
              <p><a href="#">공지사항입니다.</a></p>
              <p>조회수</p>
            </li>
            <li>
              <p>2</p>
              <p><a href="#">공지사항입니다.</a></p>
              <p>조회수</p>
            </a></li>
            <li>
              <p>1</p>
              <p><a href="#">공지사항입니다.</a></p>
              <p>조회수</p>
            </li>
          </ul>
          <a href="#" class="gopage_hj">공지사항 바로가기</a>
        </div>
        <div id="reportWrap_hj">
          <h2 class="Header_hj"><span>부정거래 신고</span></h2>
          <div class="reportExplan">
            <p>공정한 거래를 위해 부정거래 발생 시 신고해주세요.</p>
            <div>이미지</div>
          </div>
          <a href="#" class="gopage_hj">신고하기 바로가기</a>
        </div>
      </div>
    </section>
  </main>
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

  <!-- 유수현 영역2 시작 -->
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
    <!-- 유수현 영역2 끝 -->
  </div>
</body>
</html>

