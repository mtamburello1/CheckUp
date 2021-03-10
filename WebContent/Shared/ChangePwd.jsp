<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8">
<title>CheckUp - Homepage</title>
<link rel="stylesheet" href="../css/FragmentsCSS/Header.css"
	type="text/css" />
<link rel="stylesheet" href="../css/FragmentsCSS/Footer.css"
	type="text/css" />
<link rel="stylesheet" href="../css/SharedCSS/ChangePwd.css"
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
		<div class="row" id="row">
			<%
			if (user != null) {
			%>

			<div class="col-lg-6 col-xs-12">
				<form name="changePwd" action="/CheckUp/ChangePassword">
					<label for="password">Password attuale:</label> <input
						type="password" class="password" id="pwd" name="password"
						autocomplete="off" required>
					<p id="formatErrorMessage"></p>

					<label for="password">Nuova password:</label> <input
						type="password" class="password" id="newPwd" name="newPassword"
						autocomplete="off" onkeyup="pwdMatch()" required> <label
						for="password">Conferma password:</label> <input type="password"
						class="password" id="newPwdConfirm" name="passwordConfirm"
						autocomplete="off" onkeyup="pwdMatch()" required>
					<p id="errorMessage"></p>

					<input type="submit" value="Conferma" id="buttonConfirm" disabled>
				</form>
			</div>
			<%
			}

			else {
			%>
			<p id="userNotLogged">PAGINA RISERVATA.</p>

			<%
			}
			%>
		</div>

	</div>

	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="../js/ChangePwdJS/ChangePwd.js"></script>

	<!-- INCLUSIONE FOOTER-->
	<%@include file="../Fragments/Footer.jsp"%>

</body>
</html>