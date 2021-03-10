<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8">
<title>CheckUp - Reserved Area</title>
<link rel="stylesheet" href="../css/FragmentsCSS/Header.css"
	type="text/css" />
<link rel="stylesheet" href="../css/FragmentsCSS/Footer.css"
	type="text/css" />
<link rel="stylesheet"
	href="../css/ReservedAreaCSS/ReservedAreaEmployee.css" type="text/css" />
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
		<%if(user != null && user instanceof DoctorBean){
		DoctorBean doctor = (DoctorBean) user;%>
		<div class="row" id="row1">
			<h1>Area riservata</h1>
		</div>
		<div class="row" id="row2">
			<div class="col-lg-12">
				<a href="#">
					<button class="icon">Lista pazienti</button>
				</a>
			</div>
		</div>

		<div class="row" id="row3">
			<div class="col-lg-12">
				<a href="../Shared/Profile.jsp">
					<button class="icon">Il mio profilo</button>
				</a>
			</div>
		</div>

		<div class="row" id="row4">
			<div class="col-lg-12">
				<a href="#">
					<button class="icon">Nuovi referti</button>
				</a>
			</div>
		</div>

		<div class="row" id="row5">
			<div class="col-lg-12">
				<a href="#">
					<button class="icon">I miei orari</button>
				</a>
			</div>
		</div>
		<%} %>
	</div>

	<!-- INCLUSIONE FOOTER-->
	<%@include file="../Fragments/Footer.jsp"%>

</body>
</html>