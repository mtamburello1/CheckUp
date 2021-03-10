<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8">
<title>CheckUp - SessionTimeOut</title>
<link rel="stylesheet" href="../css/FragmentsCSS/Header.css" type="text/css" />
<link rel="stylesheet" href="../css/FragmentsCSS/Footer.css" type="text/css" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<link rel="stylesheet" href="../css/SharedCSS/SessionTimeOut.css"
	type="text/css" />
</head>
<body>

	<!-- INCLUSIONE HEADER -->
	<%@include file="../Fragments/Header.jsp"%>

	<div class="container" id="container">
		<div class="containerImg">
			<img src="../Img/smileSad.png">
		</div>
		<h2>SESSIONE SCADUTA.</h2>
		<h5>Effettua nuovamente il <a href="Login.jsp"><i>LOGIN</i></a></h5>
	</div>

	<!-- INCLUSIONE FOOTER-->
	<%@include file="../Fragments/Footer.jsp"%>

</body>
</html>