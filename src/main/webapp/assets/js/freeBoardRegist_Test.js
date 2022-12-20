
let form = document.signIn;
let loadpTag = form.querySelectorAll("p");

function signInFun(){
  let memberNo = form.memberNo.value;
  let nickName = form.nickName.value;
  let title = form.title.value;
  let attachedImageURL = form.attachedImageURL.value;
  let content = form.content.value;

  // 데이터 json 형식으로 저장
  const member = {
    memberNo: memberNo,
    nickName: nickName,
    title: title,
    attachedImageURL: attachedImageURL,
    content: content
  };
  // console.log(member);
  const Mjson = JSON.stringify(member, null, 2);
  console.log(Mjson);


  let xhr = new XMLHttpRequest();
xhr.open("POST", "http://localhost:8080/runeah/freeBoardRegist");
xhr.setRequestHeader("Content-Type", "application/json");
xhr.onreadystatechange = function () {
  if (xhr.readyState === 4) {
    console.log(xhr.status);
    console.log(xhr.responseText);
  }};
xhr.send(Mjson);
location.href = "http://localhost:8080/runeah";
  //form.submit();
}