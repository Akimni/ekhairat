<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource var="ic" driver="org.postgresql.Driver"
				   url="jdbc:postgres://ec2-52-73-184-24.compute-1.amazonaws.com/dckqi5pj1ki93c"
				   user = "olkzesmgaifpnp"
				   password="e13b8bdf28023c60fd1bfde4b54a707571b971a82e85d244b7871afc806f26ed"/>
				   
<sql:query dataSource="${ic}" var="oc">
	SELECT row_number() over () "rank",memberName,memberID,memberContactNo,memberEmail, memberPassword, memberAddress from khairatmember where memberID>0
</sql:query>				   
<div class="content" >
	<br>
	<h2 class="title">Display Khairat Member</h2>
	<div style="overflow-x:auto;">
		<table style="text-align: center;" id="donationList">
			<tr>
				<th onclick="sortTable(0)" style="width: 50px; height: 50px;">NO. </th>
				<th onclick="sortTable(1)" style="width: 250px;">NAMA BANTUAN</th>
				<th onclick="sortTable(2)" style="width: 500px;">MAKLUMAT BANTUAN</th>
				<th onclick="sortTable(3)" style="width: 150px;">TARIKH BUKA</th>
				<th onclick="sortTable(4)" style="width: 150px;">TARIKH TUTUP</th>
				<th onclick="sortTable(5)" style="width: 150px;">TARIKH TUTUP</th>
				<th style="width: 120px;">TINDAKAN</th>
			</tr>
			<c:forEach var="result" items="${oc.rows}">
				<tr>
					<td class="donationID">
						<c:out value="${result.rank}"/>
					</td>
					<td class="donationName">
						<c:out value="${result.donationName}"/>
					</td>
					<td class="donationDescription">
						<c:out value="${result.donationDescription}"/>
					</td>
					<td class="donationOpenDate">
						<c:out value="${result.donationOpenDate}"/>
					</td>
					<td class="donationCloseDate">
						<c:out value="${result.donationCloseDate}"/>
					</td>
					<td>
						<form method="post">
							<button  class="action"  type="update" formaction="updateDonation.jsp?id=${result.donationID}">KEMASKINI
							</button>
						</form>
						<form method="post">
							<input type="hidden" name="donationID" value="${result.donationID}">
							<input type="hidden" name="action" value="deleteDonation">
							<button  class="action"  type="delete" formaction="DonationHandler">PADAM</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br><br><br>
</div>
</body>
<style>
	body{
		font-family: "Lucida Console", "Courier New", monospace;
		color: black;
		background-color: #ffffff;
	}
	*{
		margin: 0;
		padding: 0;
		box-sizing: border-box;}
	a, a:hover{
		text-decoration: none;}
	nav a.navi:hover{
		margin-top: 10px;
		color: #BBE9FE;}
	.add {
		position: absolute;
		left: 90px;
		width: 270px;
		border: none;
		padding: 20px 16px;;
		font-size: 14px;
		color: #455a64;
		font-family: "Bahnschrift", "Courier New", monospace;}
	.logo{
		flex: 1;}
	.logo a{
		display: flex;
		align-items: center;
		font-size: 20px;
	}
	.logo img{
		width: 100px;
		height: 100px;
		margin-right: 10px;
	}
	ul {
		list-style-type: none;
		overflow: hidden;
		background-color: #BBE9FE;
		height: 100px;
		width:100%;}
	li {
		float: right;}
	.navi {
		display: block;
		color: #455a64;
		font-weight: bold;
		text-align: center;
		padding: 30px 16px;
		text-decoration: none;
		margin-top: 10px;
		margin-right: 10px;
	}
	li a.navi:hover {
		background-color: #617C8D;
		height: 5px;
	}
	div.a {
		position: relative;
		display: block;
	}
	table, th, td {
		border: 1px solid;
		border-collapse: collapse;
		text-align: left;
		margin-top: 50px;
		margin-left: auto;
		margin-right: auto;
	}
	td {
		padding-left: 10px;
		font-family: "Bahnschrift Light", "Courier New", monospace;
	}
	th {
		text-align: center;
		font-family: "Bahnschrift SemiBold", "Courier New", monospace;
	}
	.title {
		font-weight: bold;
		font-size: 30px;
		font-family: "Bahnschrift", "Courier New", monospace;
		color: #000000;
		margin-left: 15px;
	}
	.action {
		background-color: #b3e6ff;
		font-size: 10px;
		height: 35px;
		width: 100px;
		padding: 10px;
		margin: 10px 0;
		cursor: pointer;
		border-radius: 25px;
	}
	.tambah {
		background-color: #b3e6ff;
		color: black;
		font-size: 18px;
		width: 98px;
		padding: 10px;
		margin: 10px 0;
		border: 2px solid black;
		cursor: pointer;
		border-radius: 25px;
		position: absolute;
		top: 120px;
		right: 60px;
	}
</body>
</html>