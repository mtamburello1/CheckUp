/**
 *	
 * This script has the purpose of carrying out checks on the password fields
 * during the user's password change and at the end sending them to a control.
 */
function pwdMatch(){
	var NewPwd= $("#newPwd").val();
	var NewPwdConfirm= $("#newPwdConfirm").val();
	
	if(NewPwd == NewPwdConfirm){
		errorMessage.innerHTML = "";
		$("#buttonConfirm").removeAttr("disabled");
		return false;
	}
	
	else {
		buttonConfirm.setAttribute("disabled","");
		errorMessage.innerHTML = "Le due password non corrispondono.";
		errorMessage.style.color = 'red';
		return false;
	}
};

$("#pwd").on('click',function(){
		formatErrorMessage.innerHTML = "";
});

$("#newPwd").on('keyup',function(){
		errorMessage.innerHTML = "";
		pwdMatch();
});


$("form[name=changePwd]").submit(function(){
	
	var NewPwd= $("#newPwd").val();
	var pwdFormat=/^[A-Za-z0-9]{6,20}$/;
	
	if(NewPwd.match(pwdFormat)){
		$.post($(this).attr("action"), $(this).serialize(), function(resp){
			if(resp==-1){
				formatErrorMessage.innerHTML = "La password non corrisponde.";
			    formatErrorMessage.style.color = 'red';
			}
			else if(resp==-2){
				errorMessage.innerHTML = "Le due password non corrispondono.";
				errorMessage.style.color = 'red';
			}
			else if(resp==-3){
				errorMessage.innerHTML = "La nuova password non può corrispondere alla precedente.";
				errorMessage.style.color = 'red';
			}
			else if(resp==1){
				errorMessage.innerHTML = "Password modificata con successo.";
			   	errorMessage.style.color = 'darkblue';
			}
		});
		
		}
	
	else {
		errorMessage.innerHTML = "Formato nuova password non valido";
		errorMessage.style.color = 'red';
		return false;
	}
	
		return false;
	
});