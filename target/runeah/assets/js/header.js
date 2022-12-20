 //header sticky
  const headerWrap = document.querySelector("#headerWrap");
  const pageSelector = document.querySelector(".mainslider");

  window.addEventListener("scroll", function () {
    const maxHeight = document.body.scrollHeight - window.innerHeight;
    let currentHeight = (window.pageYOffset * 100) / maxHeight;
    if (currentHeight > 3) {
      headerWrap.classList.add("enabled");
    } else {
      headerWrap.classList.remove("enabled");
    }
  });

 //header left/right Side
 const headerLeftNav = document.querySelector(".leftNav");
 const headerLeftNavUl = document.querySelector(".count");
 const headerLeftNavLi = document.querySelectorAll(".count > li");
 const headerLeftNavA = document.querySelectorAll(".count > li > a");
 const headerLeftNavBar = document.querySelector("#headerBar");
 const rightQuick = document.querySelector("#rightQuick");
 const rightQuickMenu = document.querySelector(".rightQuickMenu");
 const post_sec4 = document.querySelector(".Post_sec4");
 const rightSearch = document.querySelector("#rightSearch");
 const rightSearchPage = document.querySelector("#rightSearchPage");
 const rightSearchClose = document.querySelector("#rightSearchClose");
 const upperSmallNav = document.querySelector("#upperSmallNav");


 /* 검색창 */
 rightSearch.addEventListener("click",function(){
   rightSearchPage.classList.add("active");
   upperSmallNav.style.opacity=0;
   rightQuickMenu.style.opacity=0;
   headerLeftNav.style.opacity=0;
   headerWrap.style.opacity=0;
 });
 rightSearchClose.addEventListener("click",function(){
   rightSearchPage.classList.remove("active");
   upperSmallNav.style.opacity=1;
   rightQuickMenu.style.opacity=1;
   headerLeftNav.style.opacity=1;
   headerWrap.style.opacity=1;
 });

 /* 제이쿼리 원페이지 */

  let mouse_is_not_in_post_sec4 = true;
  post_sec4.addEventListener("mouseover", function () {
    mouse_is_not_in_post_sec4 = false;
  });
  post_sec4.addEventListener("mouseout", function () {
    mouse_is_not_in_post_sec4 = true;
  });

  let wheelParam = 0;
  let param = 1;
  let leftPageCounting = 0;
  let leftPageCountingParam = 0;
  let nWheel = 1;
  let stateW = 1;
  let wheeling = (e) => {
    if (e.wheelDelta < 0 && stateW == 1 && mouse_is_not_in_post_sec4==true) {
      stateW = 0;
      nWheel++;
      if (nWheel > 6) {
        nWheel = 6;
        stateW = 1;
      } else {
        console.log(nWheel, $(".onePage" + nWheel).position().top);
        $("html, body")
          .stop()
          .animate({ scrollTop: $(".onePage" + nWheel).position().top }, function () {
            stateW = 1;
          });
        for (let i = 0; i < headerLeftNavLi.length - 1; i++) {
          headerLeftNavLi[i].style.opacity = "0";
        }
        if (nWheel == 6) {
          headerLeftNavLi[nWheel - 1].style.opacity = "1";
          headerLeftNavBar.style.height = `${24 * (nWheel) - 2}px`;
        } else {
          headerLeftNavLi[nWheel - 1].style.opacity = "1";
          headerLeftNavBar.style.height = `${24 * (nWheel)}px`;
        }
      }
    } else if (e.wheelDelta > 0 && stateW == 1 && mouse_is_not_in_post_sec4==true) {
      stateW = 0;
      nWheel--;
      if (nWheel < 1) {
        nWheel = 1;
        stateW = 1;
      } else {
        console.log(nWheel);
        $("html, body")
          .stop()
          .animate({ scrollTop: $(".onePage" + nWheel).position().top }, function () {
            stateW = 1;
          });
        for (let i = 0; i < headerLeftNavLi.length - 1; i++) {
          headerLeftNavLi[i].style.opacity = "0";
        }
        headerLeftNavLi[nWheel - 1].style.opacity = "1";
        headerLeftNavBar.style.height = `${24 * (nWheel)}px`;
      }
    }
  };

  window.addEventListener("load", function () {
    setTimeout(function () {
      window.scrollTo(0, 0);
    }, 10);
  });
  document.addEventListener("wheel", wheeling);
  window.addEventListener("resize", function () {
    if (window.innerWidth >= 1024 && hamStatus == 1) {
      mHeaderWrap.style.display = "none";
      goHamburger.click();
    }
    if (window.innerWidth >= 1024) {
      document.body.style.overflow = "hidden";
      if (wheelParam == 0) {
        wheelParam = 1;
        console.log("adddadd");
        document.addEventListener("wheel", wheeling);
      }
    } else {
      document.body.style.overflowY = "scroll";
      document.removeEventListener("wheel", wheeling);
      console.log("removes");
      wheelParam = 0;
    }
  });

  let headerLeftCount = 0;
  headerLeftNavA[0].style.opacity = "1";
  headerLeftNavLi[0].style.opacity = "1";

  //top btn
  $(".rightQuickMenu > a").on("click", function (e) {
    e.preventDefault();
    $("html, body")
      .stop()
      .animate({ scrollTop: 0 }, function () {
        nWheel = 1;
        stateW = 1;
        for (let i = 0; i < headerLeftNavLi.length - 1; i++) {
          headerLeftNavLi[i].style.opacity = "0";
        }
        headerLeftNavLi[0].style.opacity = "1";
        headerLeftNavBar.style.top = "0px";
      });
  });
  /* section 1 start*/
  //page1 slides
  let sec1_pos;
  let sec1_sLength = $('.page1_slides > li').length;
  let sec1_state = 1; //움직임제어조건변수
  let sec1_num;
  let sec1_classNum = 0;
  let sec1_nextSlider = ()=> {
    sec1_state = 0;
    sec1_classNum++;
    if(sec1_classNum == 3) {
      sec1_classNum = 0;
    }
    $('.page1_slides > li:eq(1)')
            .addClass('active')
            .css({opacity: 0})
            .animate({opacity:1}, function(){
              $('.page1_slides').append($('.page1_slides > li:eq(0)'));
              $('.page1_slides > li:last').removeClass('active');
              sec1_state=1;
            });
  }
  let sec1_prevSlider = ()=> {
    sec1_state =0;
    sec1_classNum--;
    if(sec1_classNum == -1) {
      sec1_classNum = 5;
    }
    $('.page1_slides > li:last')
            .addClass('active')
            .css({opacity: 0})
            .animate({opacity:1}, function(){
              $('.page1_slides').prepend($(this));
              $('.page1_slides > li:eq(1)').removeClass('active');
              sec1_state=1;
            });
  }
  let sec1_timer = setInterval(sec1_nextSlider,3000);
  //버튼공통
  $('#mainsliderBtn button').on('click', function(e){
    e.preventDefault();
    clearInterval(sec1_timer);
    sec1_timer = setInterval(sec1_nextSlider,3000);
  });
  $('#mainslide_btnNext').on('click',function(){
    if(sec1_state==1){
      sec1_nextSlider();
    }

  });
  $('#mainslide_btnPrev').on('click',function(){
    if(sec1_state==1){
      sec1_prevSlider();
    }
  });
 /* section 1 end */
