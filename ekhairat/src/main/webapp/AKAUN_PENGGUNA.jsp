<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<% if(session.getAttribute("name")==null)
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
    <h3>MY PROFILE</h3>

    <input type="number" name="memberid"  value="${name}" >

    <div class="row">
        <div class="col-25">
            <label>NAMA</label>
        </div>
        <div class="col-75">
            <label>${name}</label>
        </div>
    </div>
    <div class="row">
        <div class="col-25">
            <label>NOMBOR KAD PENGENALAN</label>
        </div>
        <div class="col-75">
            <label>${id}</label>
        </div>
    </div>

    <div class="row">
        <div class="col-25">
            <label>NOMBOR TELEFON</label>
        </div>
        <div class="col-75">
            <label>${contact}</label>
        </div>
    </div>
    <div class="row">
        <div class="col-25">
            <label>ALAMAT</label>
        </div>
        <div class="col-75">
            <label>${address}</label>
        </div>
        </div>
    <div class="row">
        <div class="col-25">
            <label>EMAIL</label>
        </div>
        </div>
        <div class="col-75">
            <label>${email}</label>
        </div>
    <div class="row">
        <div class="col-25">
            <label>PASSWORD</label>
        </div>
        <div class="col-75">
            <label>${password}</label>
        </div>
        </div>



    <input type="hidden" name="action" value="delete">


    <button type="submit"  class="button button1" name="submit" onclick="form.action='admin-updateProfile.jsp'">UPDATE</button>
    <button type="submit" class="button button1" name="submit" formaction="AdminServlet" onclick="return confirm('Confirm delete your profile?');">DELETE</button>


</div>
</form>
</div>
</header>
</body>
</html>