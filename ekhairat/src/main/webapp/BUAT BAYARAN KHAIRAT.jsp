<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buat Bayaran Khairat</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<header>
		<div class="topheader"></div>
		<img class="banner" src="Screenshot_243.jpg">
		<ul class="bar">
			<li id="link">
				<b><a id="linkin" onclick="window.location.href='HOMEPAGE_MEMBER.jsp';">HALAMAN UTAMA</a></b>
			</li>
			<li id="link">
				<b><a id="linkin" onclick="window.location.href='AKAUN_PENGGUNA.jsp';">AKAUN PENGGUNA</a></b>
			</li>
			<li id="link">
				<b><a id="linkin" onclick="window.location.href='SEJARAH_PEMBAYARAN.jsp';">SEJARAH 
				& PEMBAYARAN</a></b>
			</li>
			<li id="log" class="log">
				<b><a id="linkin" onclick="window.location.href='loginpage.jsp';">LOG KELUAR</a></b>
			</li>
			</ul>

			<h1 id = "muatnaik">MUAT NAIK BUTIRAN TRANSAKSI</h1>

 			 <div class="button center">
                <b><a class="but_muat" onclick="window.location.href='UPLOAD_PEMBAYARAN.jsp';">MUAT NAIK</a></b>
             </div>
  			 <div class="button right">
  			 	<b><a class="but_kem" onclick="window.location.href='SEJARAH_PEMBAYARAN.jsp';">KEMBALI</a></b>
   				
  			</div>
			
	</header>
</body>
</html>