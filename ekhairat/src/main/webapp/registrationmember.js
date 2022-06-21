function checkPass() {
var get_elem = document.getElementById,
pass1 = document.getElementById('pwd'),
pass2 = document.getElementById('pwd1'),
message = document.getElementById('confirmMessage'),
colors = {
goodColor: "#fff",
goodColored: "#087a08",
badColor: "#fff",
badColored:"#ed0b0b"
},
strings = {
"confirmMessage": ["good", "bad"]
};

if(pwd.value === pwd1.value && (pwd.value + pwd1.value) !== "") {
pwd1.style.backgroundColor = colors["goodColor"];
message.style.color = colors["goodColored"];
message.innerHTML = strings["confirmMessage"][0];
}
else if(!(pwd1.value === "")) {
pwd1.style.backgroundColor = colors["badColor"];
message.style.color = colors["badColored"];
message.innerHTML = strings["confirmMessage"][1];
}
else {message.innerHTML = "";	
}
}
function passwordtoogle() {
  var x = document.getElementById("pwd");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}

function passwordconfirmtoogle() {
  var x = document.getElementById("pwd1");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}