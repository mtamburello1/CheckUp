<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8">
<title>CheckUp - Login</title>
<link rel="stylesheet" href="../css/FragmentsCSS/Header.css" type="text/css" />
<link rel="stylesheet" href="../css/FragmentsCSS/Footer.css" type="text/css" />
<link rel="stylesheet" href="../css/LoginCSS/Login.css" type="text/css" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
</head>
<body>
	<!-- INCLUSIONE HEADER -->
	<%@include file="../Fragments/Header.jsp"%>

	<%
	if (request.getSession().getAttribute("user") == null) {
	%>
	<div class="container-fluid" id="container-fluid">
		<div class="row">
			<div class="col-md-4">
				<p id="changeFormPatient" onclick="rechangeForm()">Login
					paziente</p>
				<p id="changeForm" onclick="changeForm()">Login dipendente</p>
				<h3>Login</h3>
				<!-- INCLUDE PATIENT FORM -->
				<%@include file="Login/FormLoginPatient.jsp"%>
				<!-- INCLUSIONE EMPLOYEE FORM -->
				<%@include file="Login/FormLoginEmployee.jsp"%>
			</div>
		</div>
	</div>
	<%
	} else {
	%>
	<div class="container" style="min-height: 300px;">
		<p>HAI GIA' EFFETTUATO L'ACCESSO.</p>
	</div>
	<%
	}
	%>
	<!-- INCLUSIONE FOOTER-->
	<%@include file="../Fragments/Footer.jsp"%>

	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="/CheckUp/js/LoginJS/CheckLoginEmployee.js" type="text/Javascript"></script>
	<script src="/CheckUp/js/LoginJS/CheckLoginPatient.js" type="text/Javascript"></script>
	<script src="/CheckUp/js/LoginJS/ChangeLogin.js"></script>

</body>
</html>