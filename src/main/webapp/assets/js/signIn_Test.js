
let form = document.signIn;
let loadpTag = form.querySelectorAll("p");

// 아이디
let spanID = document.createElement("span");
loadpTag[0].append(spanID);
spanID.style.color = "red";
// 영문자로 시작하는 영문자 또는 숫자 5~20자
let regExpIdFirst = /^[a-z]/;
let regEpxIdNext = /^[a-z|0-9]{5,20}$/;

function IDCheck() {
  let id = form.id.value;
  // console.log(id);
  if(id.length == 0){ // 미입력시
    spanID.innerText = "";
  }
  else if(!regExpIdFirst.test(id)){ // 해당 정규표현식 폼에 포함되지 않은 문자가 있는 경우
    // console.log("if");
    spanID.innerText = "영문자로 시작해야합니다.";
  }
  else if(!regEpxIdNext.test(id)){
    // console.log("else if");
    spanID.innerText = "영문자 또는 숫자를 사용하여 5자이상 20자 이하로 작성하세요.";
  }
  else {
    // console.log("else");
    spanID.innerText = " ";
  }
}
form.id.addEventListener("keyup", IDCheck);

// 비밀번호
let spanPW = document.createElement("span");
loadpTag[1].append(spanPW);
let regExpNick = /^[가-힣|a-z|A-Z]+[가-힣|a-z|A-Z|0-9]*$/;
spanPW.style.color = "red";
let regExpPasswd = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,}/;
function pwCheck() {
  let passwd = form.passwd.value;
  if(passwd.length == 0){ // 미입력시
    spanPW.innerText = "";
  }
  else if(!regExpPasswd.test(passwd)){
    spanPW.innerText = "최소 8 자, 대문자, 소문자, 숫자, 특수 문자 각각 하나 이상 포함해야 합니다.";
  }
  else {
    spanPW.innerText = "";
  }
}
form.passwd.addEventListener("keyup", pwCheck);

// 비밀번호 확인
let spanPWCheck = document.createElement("span");
loadpTag[2].append(spanPWCheck);
spanPWCheck.style.color = "red";
function repwCheck (){
  let passwd = form.passwd.value;
  if(form.rePasswd.value.length == 0){ // 미입력시
    spanPWCheck.innerText = "";
  }
  else if(form.rePasswd.value != passwd){
    spanPWCheck.innerText = "비밀번호가 일치하지 않습니다. 다시 확인해주세요.";
  }
  else {
    spanPWCheck.innerText = "";
  }
}
form.rePasswd.addEventListener("keyup", repwCheck);

// 별명
let spanNick = document.createElement("span");
loadpTag[4].append(spanNick);
spanNick.style.color = "red";
// 별명 : 한글/영문/숫자
function nickCheck(){
  let nick = form.nick.value;
  if(nick.length == 0){ // 미입력시
    spanNick.innerText = "";
  }
  else if(!regExpNick.test(nick)){
    spanNick.innerText = "별명은 한글이나 영문으로 시작해야하고, 한글/영문/숫자로 입력 가능합니다";
  }
  else {
    spanNick.innerText = "";
  }
}
form.nick.addEventListener("keyup", nickCheck);

form.birthday.addEventListener("change",(e)=>{
  console.log(e.currentTarget.value);
})

function signInFun(){
  let id = form.id.value;
  let passwd = form.passwd.value;
  let nick = form.nick.value;
  let name = form.name.value;
  let phone = form.phone1.value + "-" + form.phone2.value + "-" + form.phone3.value;
  let birthday = form.birthday.value;

  // 유효성 검사
  // 이름에 대해 한글만 검사하도록 정규 표현식 작성.
  let regExpName = /^[가-힣]{2,}$/;
  
  // 전화번호 형태
  let regExpPhone = /^\d{3}-\d{3,4}-\d{4}$/;
  // 날짜
  let regExpBirth = /^\d{4}-\d{1,2}-\d{1,2}$/;

  if(!regExpIdFirst.test(id) || !regEpxIdNext.test(id)){
    alert("아이디를 양식에 맞게 입력해주세요!");
    form.id.select();
    return;
  }
  if(!regExpPasswd.test(passwd)){
    alert("비밀번호를 양식에 맞게 입력해주세요!");
    pwCheck();
    form.passwd.select();
    return;
  }
  if(form.rePasswd.value != passwd){
    spanPWCheck.innerText = "비밀번호가 일치하지 않습니다. 다시 확인해주세요.";
    alert("비밀번호를 확인해주세요!");
    form.rePasswd.select();
    return;
  }
  if(!regExpName.test(name)){
    alert("이름은 한글만으로 입력해 주세요!");
    form.name.select();
    return;
  }
  if(!regExpNick.test(nick)){
    alert("별명을 양식에 맞게 입력해주세요!");
    nickCheck();
    form.nick.select();
    return;
  }
  if(!regExpBirth.test(birthday)){
    alert("생년월일 입력을 확인해 주세요!");
    form.birthday.select();
    return;
  }
  if(!regExpPhone.test(phone)){
    alert("연락처 입력을 확인해 주세요!");
    form.phone.select();
    return;
  }

  // 데이터 json 형식으로 저장
  const member = {
    id: id,
    passwd: passwd,
    name: name,
    nick: nick,
    sex: form.sex.value,
    birthday: form.birthday.value,
    phone: phone
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