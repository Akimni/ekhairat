<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Resgistration For Member</title>
	<link rel="stylesheet" href="registration.css">
	<script src="registration.js"></script>
</head>
<body>
	<h1 class="header">DAFTAR AKAUN BAHARU</h1>
	<br>
	<br>
	<div class = "box">
		<div class = "col-75">
			<div class = "containercart"><br>
				<form id="Resgistration" action="registrationmember.html">
					<div class= "row">
						<div class = "col-50">
							<label class="regis" for="fname">Nama</label>
							<input class = "extratext" type="text" id="fname" name="memberName" placeholder = "nama penuh pengguna" required>
		
							<label class="regis" for="id">Nombor Kad Pengenalan</label>
							<input type= "text" id="id" name="memberID" placeholder = "nombor kad" required>
							<p class = "extratext"><span style="color: red">*</span>Nombor telefon diisi tanpa simbol(-)</p>
		
							<label class="regis" for="nophone">Nombor Telefon Bimbit</label>
							<input type= "tel" id="nophone" name="memberContactNo" placeholder = "nombor telefon" required>
							<p class = "extratext"><span style="color: red">*</span>Nombor telefon diisi tanpa simbol(-) dan tanpa (+06)</p>
		
							<label class="regis" for="address">Alamat</label>
							<textarea rows = "5" cols = "60" class = "extratext" id="address" name="memberAddress" placeholder = "alamat pengguna" required></textarea>
		
							<label class="regis" for="mail">Email</label>
							<input class = "extratext" type="email" id="mail" name="memberEmail" placeholder = "email pengguna" required>
						</div>
						<div class ="col-50">
							<div class="infobox"><br>
								<p class="infotext"><span style="color: red">*</span>Semua maklumat hendaklah diisi dengan huruf besar <br><span style="color: red">*</span>Untuk log masuk setelah selesai pendaftaran, sila gunakan nombor kad pengenalan sebagai username<br><span style="color: red">*</span>Setelah selesai isi kesemua maklumat. Sila tekan 'DAFTAR AKAUN' untuk mengesahkan maklumat dan daftar</p><br>
							</div>
							<label class="regis" id="passlabel"  for="pwd">Kata Laluan</label>
							<input type="password" id="pwd"  name="memberPassword" placeholder = "password pengguna" required><br>
							<input type = "checkbox" id="passlabel"  onclick="passwordtoogle()">Papar Katalaluan
							<p class = "extratext"></p>
		
							<label class="regis" id="passlabel" for="pwd1">Masukkan Kata Laluan Semula</label>
							<input type="password" id="pwd1"  name="memberPasswordtest" placeholder = "password pengguna" required><br>
							<input type = "checkbox" id="passlabel" onclick="passwordconfirmtoogle()">Papar Katalaluan
							<p class = "extratext"></p>
						</div>
			</div>
		</div>
	</div>
	<footer>
		<button class="backbtn" >KEMBALI</button>
		<input type="submit" form="Resgistration" name="submitinfo" value="DAFTAR AKAUN" class="btncart"/>
	</footer>
</body>
</html>