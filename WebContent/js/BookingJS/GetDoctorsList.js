/**
 * This script has the purpose of sending the value of the type of visit selected by the patient
 * to a control which returns the list of doctors. 
 * This list is added to the appropriate select field through the same script.
 */

$("#type").on('click',function(){

	
	
	$("#doctors").children("option").remove();
	$("#date").children("option").remove();
	$("#hours").children("option").remove();
	hours.add(new Option("Seleziona una data"));
	hours.children[0].setAttribute("disabled", "");
	hours.children[0].setAttribute("hidden", "");
	date.add(new Option("Seleziona un medico"));
	date.children[0].setAttribute("disabled", "");
	date.children[0].setAttribute("hidden", "");
	
	$.post("BookingDoctor", $(this).serialize(), function(response){
		$.each(response, function(index, item) { 
			doctors.add(new Option(item.name));
			$("#fiscal_code").val(item.fiscal_code);
        });
	});
		return false;
});