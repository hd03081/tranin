/* 제이쿼리 원페이지 */
 let mouse_is_not_in_post_sec4 = true;
 post_sec4.addEventListener("mouseover", function () {
   mouse_is_not_in_post_sec4 = false;
 });
 post_sec4.addEventListener("mouseout", function () {
   mouse_is_not_in_post_sec4 = true;
 });

 let right_quick_bar_activate = false;
 rightSearch.addEventListener("click", function () {
   right_quick_bar_activate = true;
 });
 rightSearchClose.addEventListener("click", function () {
   right_quick_bar_activate = false;
 });

 let wheelParam = 0;
 let param = 1;
 let leftPageCounting = 0;
 let leftPageCountingParam = 0;
 let nWheel = 1;
 let stateW = 1;
 let wheeling = (e) => {
   if (e.wheelDelta < 0 && stateW == 1 && mouse_is_not_in_post_sec4==true && right_quick_bar_activate == false) {
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
   } else if (e.wheelDelta > 0 && stateW == 1 && mouse_is_not_in_post_sec4==true && right_quick_bar_activate == false) {
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
