/**
 *	This script has the purpose to hide the patient login form and show the employee login form and vice versa.
 *
 */

function changeForm(){
	document.getElementById("patientForm").style.display="none";
	document.getElementById("employeeForm").style.display="block";
	document.getElementById("changeForm").style.backgroundColor="rgba(0,137,137,0.8)";
	document.getElementById("changeForm").style.color="white";
	document.getElementById("changeFormPatient").style.backgroundColor="white";
	document.getElementById("changeFormPatient").style.color="darkcyan";
}

function rechangeForm(){
	window.location.reload();
}

function removeError(){
	errorMessagePatient.innerHTML ="";
	errorMessageEmployee.innerHTML ="";
}