<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <link rel="stylesheet" href="assets/css/reset.css">
    <link rel="stylesheet" href="assets/css/footer.css">
    <link rel="stylesheet" href="assets/css/common.css">
    <link rel="stylesheet" href="assets/css/register.css">
    <script src="assets/js/header.js" defer></script>
</head>
<script src="https://spi.maps.daum.net/imap/map_js_init/postcode.v2.js"></script>
    <script>
        /* 
        카카오 우편번호 검색 가이드 페이지 :  https://postcode.map.daum.net/guide
        getElementById() : html 에서 매개변수로 받은 id 값이 있는 요소를 반환.
        */
        function execDaumPostcode() {
            new daum.Postcode({
                oncomplete: function(data) {
                    // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                    // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                    // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                    var fullAddr = ''; // 최종 주소 변수
                    var extraAddr = ''; // 조합형 주소 변수

                    // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                    if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                        fullAddr = data.roadAddress;
                    }
                    else { // 사용자가 지번 주소를 선택했을 경우(J)
                        fullAddr = data.jibunAddress;
                    }

                    // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                    if(data.userSelectedType === 'R'){
                        //법정동명이 있을 경우 추가한다.
                        if(data.bname !== ''){
                            extraAddr += data.bname;
                        }
                        // 건물명이 있을 경우 추가한다.
                        if(data.buildingName !== ''){
                            extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                        }
                        // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                        fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                    }

                    // 우편번호와 주소 정보를 해당 필드에 넣는다.
                    document.getElementById('zipcode').value = data.zonecode; //5자리 새우편번호 사용
                    document.getElementById('address01').value = fullAddr;

                    // 커서를 상세주소 필드로 이동한다.
                    document.getElementById('address02').focus();
                }
            }).open();
        }
    </script> 
<body>
    <div id="upperSmallNav">
        <h1 class="hidden">기타관련</h1>
        <a href="login.html">로그인</a>
        <a href="#">회원가입</a>
        <a href="myPage.html">마이페이지</a>
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
    <div id="listWrap_sh">
    <form id="list_sh" action="signAdd" method="post">
        <ul id="forms_sh">
        <li> <span>아이디</span> <input type="text" name="memberId"></li>
        <span>인증하기</span>
        <li> <span>비밀번호</span> <input type="password" name="password"></li>
        <li> <span>비밀번호 확인</span> <input type="password" value="password_cf"></li>
        <li> <span>이름</span> <input type="text" name="name"></li>
        <li> <span>별명</span> <input type="text" name="nickName"></li>
        <span><span>중복확인</span></span><br>
        <span id="sex">
        <p><input id="man" type="radio" value="남성" name="sex"></p>
        <p><input id="woman"type="radio" value="여성" name="sex"></p>
        </span>
        <li> <span>생년월일</span> <input type="number" name="birthYear"> 
            <input type="number" name="birthMonth"> 
            <input type="number" name="birthDay">
        </li>
        <li> <span>휴대전화</span> <input type="number" name="phone1"> -
            <input type="number" name="phone2"> -
            <input type="number" name="phone3"> 
        </li>
        <li> <span>집전화</span> <input type="number" name="phone4"> -
            <input type="number" name="phone5"> -
            <input type="number" name="phone6"> 
        </li>
        <li><span>우편번호</span> <input id="zipcode" type="text" name="zipCode" readonly></li>
        <span onclick="execDaumPostcode()" style="cursor:pointer;" > 우편번호 검색</span> <br>
            <li><span>집 주소1</span> <input id="address01" type="text" name="address1"></li>
            <li><span>집 주소2</span> <input id="address02" type="text" name="address2"></li>
        <input type="submit" value="회원가입">
    </ul>
    </form>
</div>
    <div class="footerWrap page onePage6">
        <footer class="page8" id="footer">
            <p class="us">about us</p>
            <div id="membersWrap">
                <p class="member0_sh member_sh"><a href="#" target="_blank">개인정보처리방침</a></p>
                <p class="member1_sh member_sh"><a href="hyehyun.html" target="_blank">김혜현</a></p>
                <p class="member2_sh member_sh"><a href="beomsu.html" target="_blank">오범수</a></p>
                <p class="member3_sh member_sh"><a href="haejun.html" target="_blank">오해준</a></p>
                <p class="member4_sh member_sh"><a
                        href="https://suhyun980716.github.io/LandingPage/Landing%20Page/index.html"
                        target="_blank">유수현</a></p>
                <p class="member5_sh member_sh"><a href="https://github.com/hyeahyun2/TeamProject"
                        target="_blank">GitHub</a></p>
            </div>
        </footer>
        <!-- 유수현 영역2 끝 -->
    </div>

</body>
</html>