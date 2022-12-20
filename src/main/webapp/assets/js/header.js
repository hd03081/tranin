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
 const body = document.querySelector("body");
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
 rightSearch.addEventListener("click",function(e){
  e.preventDefault();
  body.style.overflow = "hidden";
   rightSearchPage.classList.add("active");
   rightSearchPage.style.top = `${window.pageYOffset}px`;
   upperSmallNav.style.opacity=0;
   rightQuickMenu.style.opacity=0;
   headerLeftNav.style.opacity=0;
   headerWrap.style.opacity=0;
 });
 rightSearchClose.addEventListener("click",function(){
  body.style.overflow = "scroll";
  rightSearchPage.classList.remove("active");
   upperSmallNav.style.opacity=1;
   rightQuickMenu.style.opacity=1;
   headerLeftNav.style.opacity=1;
   headerWrap.style.opacity=1;
 });
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
