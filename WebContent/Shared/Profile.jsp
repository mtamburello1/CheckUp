<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8">
<title>CheckUp - Profile</title>
<link rel="stylesheet" href="../css/FragmentsCSS/Header.css"
	type="text/css" />
<link rel="stylesheet" href="../css/FragmentsCSS/Footer.css"
	type="text/css" />
<link rel="stylesheet" href="../css/SharedCSS/Profile.css"
	type="text/css" />
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

	<div class="container" id="container">
		<%
		if (user != null) {
		%>
		<div class="row" id="row0">
			<img src="../Img/avatar.jpg">
		</div>

		<div class="row" id="row1">
			<label for="name">Nome: </label>
			<%=user.getUser_name()%>
		</div>

		<div class="row" id="row2">
			<label for="surname">Cognome: </label>
			<%=user.getSurname()%>
		</div>

		<div class="row" id="row3">
			<label for="birth_date">Data di nascita: </label>
			<%=user.getBirth_date()%>
		</div>

		<div class="row" id="row4">
			<label for="birth_place">Luogo di nascita: </label>
			<%=user.getBirth_place()%>
		</div>

		<div class="row" id="row5">
			<label for="residence">Residenza: </label>
			<%=user.getResidence()%>
		</div>

		<div class="row" id="row6">
			<label for="fiscal_code">Codice fiscale: </label>
			<%=user.getFiscal_code()%>
		</div>

		<div class="row" id="row7">
			<label for="phone_number">Numero di telefono: </label>
			<%=user.getPhone_number()%>
		</div>

		<div class="row" id="row8">
			<label for="email">E-mail: </label>
			<%=user.getEmail()%>
		</div>
		<%
		if (user instanceof DoctorBean) {
			DoctorBean doctor = (DoctorBean) user;
		%>

		<div class="row" id="row9">
			<label for="specialization">Specializzazione: </label>
			<%=doctor.getSpecialization()%>
		</div>
		<%
		}
		%>
		<div class="row" id="row10">
			<a href="ChangePwd.jsp">Modifica Password 🔑</a>
		</div>
		<%
		}

		else {
		%>

		<div class="row" id="row1">
			<p>PAGINA RISERVATA.</p>
		</div>

		<%
		}
		%>
	</div>

	<!-- INCLUSIONE FOOTER-->
	<%@include file="../Fragments/Footer.jsp"%>

</body>
</html>