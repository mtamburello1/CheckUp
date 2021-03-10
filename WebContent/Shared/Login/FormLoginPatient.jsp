<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<form name="loginPatient" method="post" id="patientForm"
	action="../LoginPatient">
	<h5>CF:</h5>
	<input type="text" name="fiscal_code" autocomplete="on"
		onkeyup="removeError()" required></input>
	<h5>Password:</h5>
	<input type="password" name="user_password" autocomplete="on"
		onkeyup="removeError()" required></input> <br>
	<p id="errorMessagePatient"></p>
	<br> <input type="submit" value="Login" id="confirmPatientLogin">
	<br> Non hai ancora un account? <a href="#">Richiedi la
		registrazione.</a>
</form>
