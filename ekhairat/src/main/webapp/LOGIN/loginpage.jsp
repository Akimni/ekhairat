<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Login Page</title>
	<link rel="stylesheet" href="loginpage.css">
</head>
<body>
	<div>
		<img class="logo" src="Surau Al-Hidayah1.png">
	</div>
	<form>
		<label class="check align" for="khairat">Khairat</label>
		<input class = "checkbox" type="radio" id="khairat" name="khairatorstaff">
		<label class="check nextalign" for="staff">Staff</label>
		<input class = "checkbox" type="radio" id="staff" name="khairatorstaff">
		<p class="typemem">LOG MASUK SEBAGAI KHAIRAT</p>
		<div class="login">
			<label class="logintext" for="username">Nombor K/P</label>
			<input class="userbox" type="text" name="nomborkp" id="username" placeholder="Nombor Kad Pengenalan" reuqired><br>
			<label class="logintext margin" for="password">Kata Laluan</label>
			<input class="passbox margin" type="text" name="pass" id="password" placeholder="Kata Laluan" reuqired>
		</div>
		<input type="submit" name="submitlogin" value="LOG MASUK" class="btnlogin" /><br>
	</form>
	<button class="regis" href="" >DAFTAR AKAUN BAHARU</button>

</body>
</html>