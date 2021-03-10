<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8">
<title>CheckUp - Homepage</title>
<link rel="stylesheet" href="././css/FragmentsCSS/Header.css"
	type="text/css" />
<link rel="stylesheet" href="././css/FragmentsCSS/Footer.css"
	type="text/css" />
<link rel="stylesheet" href="././css/BookingCSS/NewBooking.css"
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
	<%@include file="../../Fragments/Header.jsp"%>

	<!-- INCLUSIONE FORM -->
	<%@include file="BookingForm.jsp"%>

	<!-- INCLUSIONE FOOTER-->
	<%@include file="../../Fragments/Footer.jsp"%>


	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="./js/BookingJS/GetDoctorsList.js"></script>
	<script src="./js/BookingJS/GetDateList.js"></script>
	<script src="./js/BookingJS/GetTimetableList.js"></script>
</body>
</html>