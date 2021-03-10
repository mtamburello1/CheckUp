/**
  *	This script has the purpose of sending the data used by the employee to login to a control.
  *
  */
$("form[name=loginEmployee]").submit(function(){
	
	$.post($(this).attr("action"), $(this).serialize(), function(resp){
		if(resp==1){
			window.location.href = '/CheckUp/Doctor/ReservedArea.jsp';
		}
		else if(resp==2){
			window.location.href = '/CheckUp/Secretary/ReservedArea.jsp';
		}
		else{
		    errorMessageEmployee.innerHTML = "E-mail o Password errati.";
		    errorMessageEmployee.style.color = 'red';
			return false;  
		}
	});
	
		return false;
	
});

