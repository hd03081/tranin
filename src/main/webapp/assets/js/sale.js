const fixedBtn = document.getElementById("fixedBtn");
const topBtn = fixedBtn.querySelector(".topBtn");
console.log(topBtn);
topBtn.addEventListener("click",(e)=>{
  e.preventDefault();
  // 스크롤 스무스하게 올라가게
  window.scrollTo({top: 0, behavior: 'smooth'});
})

// 더보기 클릭시 리스트 추가
// ajax 사용
const xhr = new XMLHttpRequest();
const contentWrap = document.getElementById("contentWrap");
const posts = document.getElementById("posts");
const moreBtn = contentWrap.querySelector(".moreBtn");

let clickNum = 0; // 클릭 수
function moreList(){
  // page = this.getAttribute();
  xhr.open('GET', `./saleList.html`); //HTTP 요청 초기화. 통신 방식과 url 결정
  xhr.send(); // url에 요청 보내기
  // 이벤트 등록. XMLHttpRequest 객체의 readyState 프로퍼티 값이 변할 때마다 자동으로 호출
  xhr.onreadystatechange = ()=>{
    // readyState 프로퍼티의 값이 DONE : 요청한 데이터의 처리가 완료되어 응답할 준비가 완료됨
    if(xhr.readyState !== XMLHttpRequest.DONE) return;
    console.log(xhr.status, xhr.statusText);
    if(xhr.status === 200){ // 서버(url)에 문서가 존재할 때
      posts.insertAdjacentHTML("beforeend", xhr.response);
      const postUl = posts.querySelectorAll("ul"); // 현재 ul태그들 변수에 저장
      clickNum++;
      posts.style.height = `${80 * clickNum}%`; // ul 부모태그 높이 늘리기
      postUl.forEach(element =>{ // ul태그들 높이 조절
        element.style.height = `${100 / clickNum}%`
      })
      // postUl.style.height = `${100 / clickNum}%`
      console.log(80 * clickNum);
    }
    else { // 서버(url)에 문서가 존재하지 않을 때
      console.log("Error", xhr.status, xhr.statusText);
    }
  }
}
window.addEventListener("load", moreList); // 페이지 로드시 디폴트 리스트
moreBtn.addEventListener("click", moreList); // 클릭시 리스트 추가


// 정렬 방식(#array)에 따른 리스트 재나열
const array = document.getElementById("array");
const arrList = array.querySelectorAll("li");

arrList.forEach(element => {
  element.addEventListener("click",(e)=>{
    for(let i=0; i<arrList.length; i++){
      arrList[i].classList.remove("select");
    }
    e.currentTarget.classList.add("select"); // 선택된 정렬방식 표시
    // 리스트 초기화 및 다시 불러오기
    posts.innerHTML = null;
    clickNum = 0;
    moreList();
  })
});


// category 선택
const category = document.getElementById("category");
const goryPTag = category.querySelector("p");
const goryList = category.querySelector(".goryList");
const goryItem = goryList.querySelectorAll("li");
console.log(goryItem);
goryPTag.addEventListener("mouseenter",()=>{
  category.style.height = "175px";
  goryList.style.border = "1px solid #000";
})
category.addEventListener("mouseleave", (e)=>{
  e.currentTarget.style.height = "25px";
  goryList.style.border = "unset";
})

goryItem.forEach(element => {
  element.addEventListener("click",(e)=>{
    let pTagText = e.currentTarget.innerText;
    goryPTag.innerText = element.innerText;
    element.innerText = pTagText;
    // 리스트 초기화 및 다시 불러오기
    posts.innerHTML = null;
    clickNum = 0;
    moreList();
  })
});