/**
 *	This script has the purpose of sending the data used by the patient to login to a control.
 *
 */
$("form[name=loginPatient]").submit(function(){
	
	$.post($(this).attr("action"), $(this).serialize(), function(resp){
		if(resp==1){
			window.location.href = '/CheckUp/Patient/ReservedArea.jsp';
		}
		
		else{
		    errorMessagePatient.innerHTML = "Codice fiscale o Password errati.";
		    errorMessagePatient.style.color = 'red';
			return false;  
		}
	});
	
		return false;
	
});


function removeError(){
	errorMessagePatient.innerHTML ="";
}