<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form name="loginEmployee" method="post" id="employeeForm"
	action="../LoginEmployee">
	<h5>E-mail:</h5>
	<input type="text" name="email" autocomplete="on"
		onkeyup="removeError()" required></input>
	<h5>Password:</h5>
	<input type="password" name="user_password" autocomplete="on"
		onkeyup="removeError()" required></input> <br>
	<p id="errorMessageEmployee"></p>
	<br> <input type="submit" value="Login" id="confirmEmployeeLogin">
</form>
