<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Akaun Pengguna</title>
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
				<b><a id="linkin"  onclick="window.location.href='AKAUN_PENGGUNA.jsp';">AKAUN PENGGUNA</a></b>
			</li>
			<li id="link">
				<b><a id="linkin" onclick="window.location.href='SEJARAH_PEMBAYARAN.jsp';">SEJARAH 
				& PEMBAYARAN</a></b>
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
	    <div class="scroll1">
	    	<form action="KhairatmemberHandler" method="post">

<div class="container" style="height: auto">
    <h3>MY PROFILE</h3>

    <input type="number" name="memberid"  value="${nomborkp}" hidden>

    <div class="row">
        <div class="col-25">
            <label>NAMA</label>
        </div>
        <div class="col-75">
            <label>${membername}</label>
        </div>
    </div>
    <div class="row">
        <div class="col-25">
            <label>NOMBOR KAD PENGENALAN</label>
        </div>
        <div class="col-75">
            <label>${memberid}</label>
        </div>
    </div>

    <div class="row">
        <div class="col-25">
            <label>NOMBOR TELEFON</label>
        </div>
        <div class="col-75">
            <label>${membercontactno}</label>
        </div>
    </div>
    <div class="row">
        <div class="col-25">
            <label>ALAMAT</label>
        </div>
        <div class="col-75">
            <label>${memberaddress}</label>
        </div>
    </div>
    <div class="row">
        <div class="col-25">
            <label>EMAIL</label>
        </div>
        <div class="col-75">
            <label>${memberemail}</label>
        </div>
    </div>
    <div class="row">
        <div class="col-25">
            <label>PASSWORD</label>
        </div>
        <div class="col-75">
            <label>${memberpassword}</label>
        </div>
    </div>



    <input type="hidden" name="action" value="delete">


    <button type="submit"  class="button button1" name="submit" onclick="form.action='admin-updateProfile.jsp'">UPDATE</button>
    <button type="submit" class="button button1" name="submit" formaction="AdminServlet" onclick="return confirm('Confirm delete your profile?');">DELETE</button>


</div>
</form>
	    </div>

	</header>
	<%
	Object name = session.getAttribute("membername");
    Object id = session.getAttribute("memberid");
%>
<h1><%=name %></h1>
<h1><%=id %></h1>
</body>
</html>