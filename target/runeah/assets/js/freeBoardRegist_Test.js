
let form = document.signIn;

function signInFun(){
  let memberNo = form.memberNo.value;
  let nickName = form.nickName.value;
  let title = form.title.value;
  let attachedImageURL = form.attachedImageURL.value;
  let content = form.content.value;

  // 데이터 json 형식으로 저장
  const freeBoard = {
    memberNo: memberNo,
    nickName: nickName,
    title: title,
    attachedImageURL: attachedImageURL,
    content: content
  };
  const Mjson = JSON.stringify(freeBoard, null, 2);
  console.log(Mjson);
  var xhr = new XMLHttpRequest();
  var url = "http://localhost:8080/runeah/freeBoardRegist";
  xhr.open("POST", url, true);
  xhr.setRequestHeader("Content-Type", "application/json");
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4 && xhr.status === 200) {
        location.href='/runeah/freeBoard';
    }
  };
  xhr.send(Mjson);
  
}