const sec3 = document.getElementById("Wrap_hj");
const slideList_sec3 = sec3.querySelector(".Slider_hj");
const slideItem_sec3 = slideList_sec3.querySelectorAll("li");
const btnWrap_sec3 = document.getElementById("btnWrap_hj");
const btn_sec3 = btnWrap_sec3.querySelectorAll("button");

// 슬라이드 초기 설정 (8번 슬라이드가 1번 앞으로)
slideList_sec3.prepend(slideItem_sec3[7]);
let slideMargin_sec3 = -25;
slideList_sec3.style.marginLeft = `${slideMargin_sec3}%`;
// 이전 버튼
btn_sec3[0].addEventListener("click", ()=>{
  // 애니메이션 시간 0.5초로 설정
  slideList_sec3.style.transition = "0.5s";
  slideMargin_sec3 += 25;
  slideList_sec3.style.marginLeft = `${slideMargin_sec3}%`;
  // 애니메이션 시간 초기화(0초)
  setTimeout(function(){
      if(slideMargin_sec3 >= 0){
        slideList_sec3.style.transition = "0s";
        slideMargin_sec3 = -25;
        const prevItem_sec3 = slideList_sec3.querySelectorAll("li");
        slideList_sec3.prepend(prevItem_sec3[7]);
        slideList_sec3.style.marginLeft = `${slideMargin_sec3}%`;
      }
    },500)
})
// 다음 버튼
btn_sec3[1].addEventListener("click", ()=>{
  // 애니메이션 시간 0.5초로 설정
  slideList_sec3.style.transition = "0.5s";
  slideMargin_sec3 -= 25;
  slideList_sec3.style.marginLeft = `${slideMargin_sec3}%`;
  // 애니메이션 시간 초기화(0초)
  setTimeout(function(){
      if(slideMargin_sec3 <= -100){
        slideList_sec3.style.transition = "0s";
        slideMargin_sec3 = -75;
        const NextItem_sec3 = slideList_sec3.querySelectorAll("li");
        slideList_sec3.append(NextItem_sec3[0]);
        slideList_sec3.style.marginLeft = `${slideMargin_sec3}%`;
      }
    },500)
})
