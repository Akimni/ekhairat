var check = function() {
  if (document.getElementById('memberPassword').value ==
    document.getElementById('memberPasswordtest').value) {
    document.getElementById('message').style.color = 'green';
    document.getElementById('message').innerHTML = 'matching';
  } else {
    document.getElementById('message').style.color = 'red';
    document.getElementById('message').innerHTML = 'not matching';
  }
}

function passwordtoogle() {
  var x = document.getElementById("memberPassword");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}

function passwordconfirmtoogle() {
  var x = document.getElementById("memberPasswordtest");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}