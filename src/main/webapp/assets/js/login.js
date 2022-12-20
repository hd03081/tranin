const idForm = document.querySelector("#id_sh");
const pwForm = document.querySelector("#password_sh");
const loginBtn = document.querySelector("#loginBtn");
const autoLogin = document.querySelector("#autoLogin");

let id = getCookie("autoLoginIDCookie");
let pw = getCookie("autoLoginPWCookie");
console.log(id,pw);
idForm.value = id;
pwForm.value = pw;
if(id!=""&&pw!=""){
	autoLogin.checked = true;
}

function getCookie(cname) {
  let name = cname + "=";
  let decodedCookie = decodeURIComponent(document.cookie);
  let ca = decodedCookie.split(';');
  for(let i = 0; i <ca.length; i++) {
    let c = ca[i];
    while (c.charAt(0) == ' ') {
      c = c.substring(1);
    }
    if (c.indexOf(name) == 0) {
      return c.substring(name.length, c.length);
    }
  }
  return "";
}