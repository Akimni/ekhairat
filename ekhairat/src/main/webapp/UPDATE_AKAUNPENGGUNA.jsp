<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<% if(session.getAttribute("id")==null)
	response.sendRedirect("index.jsp");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Akaun Pengguna</title>
<link rel="stylesheet" href="style.css">
</head>
<style>
b{
margin-left:14px;
}
</style>
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
				<b><a id="linkin" onclick="window.location.href='SEJARAH_PEMBAYARAN.jsp';">SEJARAH & PEMBAYARAN</a></b>
			</li>
			<li id="log" class="log">
				<b><a id="linkin" onclick="window.location.href='index.jsp';">LOG KELUAR</a></b>
			</li>
		</ul>
<br><br>
		<div class="info">
		<h1>
			 MAKLUMAT PENGGUNA
		</h1>
	    </div>
	    <br><br><br>
	    <div class="scroll">

	    	<form action="KhairatmemberHandler" method="post">

<div class="container" style="height: auto">

    <input type=hidden name="memberid"  value="${id}" >

    <div class="row">
        <div class="col-25">
            <label>NAMA</label>
        </div>
        <div class="col-75">
            <input type="text" name="name" value="${name}">
        </div>
    </div>
    <div class="row">
        <div class="col-25">
            <label>NOMBOR KAD PENGENALAN</label>
        </div>
        <div class="col-75">
            <input type="text" name="id" value="${id}">
        </div>
    </div>
    <div class="row">
        <div class="col-25">
            <label>NOMBOR TELEFON</label>
        </div>
        <div class="col-75">
            <input type="tel" name="contact" value="${contact}">
        </div>
    </div>
    <div class="row">
        <div class="col-25">
            <label>ALAMAT</label>
        </div>
        <div class="col-75">
            <input type="text" name="address" value="${address}">
        </div>
        </div>
    <div class="row">
        <div class="col-25">
            <label>EMAIL</label>
        </div>
        <div class="col-75">
            <input type="email" name="email" value="${email}">
        </div>
        </div>
    <div class="row">
        <div class="col-25">
            <label>PASSWORD</label>
        </div>
        <div class="col-75">
            <input type="password" name="password" value="${password}">
        </div>
        </div>



    	<input type="hidden" name="action" value="updateKhairatmember">
        <button type="submit" class="button button1" name="submit" >Submit</button><br><br>


</div>
</form>
</div>
</header>
</body>
</html>