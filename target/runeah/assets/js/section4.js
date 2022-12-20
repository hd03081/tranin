const sec4 = document.querySelector(".page4");
const sec4_gory = sec4.querySelectorAll(".Category_sec4 li");
const sec4_post = sec4.querySelector(".Post_sec4");
const sec4_div = sec4_post.querySelector("div");
const sec4_h5 = sec4_post.querySelector("h5");
const sec4_list = sec4_post.querySelectorAll("ul");
const sec4_item = sec4_post.querySelectorAll("li");
console.log(sec4_div);
// 클릭한 카테고리 글 목록 보이기
sec4_gory.forEach((element, i) => {
  element.addEventListener("click",(q)=>{

    sec4_h5.innerText = sec4_gory[i].innerText;
    sec4_gory.forEach(not =>{
      not.classList.remove("check_gory");
    })
    q.currentTarget.classList.add("check_gory");
    sec4_list.forEach(e =>{
      e.classList.remove("check_sec4");
    })
    sec4_list[i].classList.add("check_sec4");
  })
});
