function checkPass() {
var get_elem = document.getElementById,
pass1 = document.getElementById('pwd'),
pass2 = document.getElementById('pwd1'),
message = document.getElementById('passlabel'),
colors = {
goodColor: "#fff",
goodColored: "#087a08",
badColor: "#fff",
badColored:"#ed0b0b"
},
strings = {
"passlabel": ["good", "bad"]
};

if(pwd.value === pwd1.value && (pwd.value + pwd1.value) !== "") {
pwd1.style.backgroundColor = colors["goodColor"];
message.style.color = colors["goodColored"];
message.innerHTML = strings["passlabel"][0];
}
else if(!(pwd1.value === "")) {
pwd1.style.backgroundColor = colors["badColor"];
message.style.color = colors["badColored"];
message.innerHTML = strings["passlabel"][1];
}
else {message.innerHTML = "";	
}
}