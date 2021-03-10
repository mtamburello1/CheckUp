/**
 * This script has the purpose of sending the value of the type of visit selected by the patient
 * to a control which returns the list of doctors. 
 * This list is added to the appropriate select field through the same script.
 */

$("#type").on('click',function(){
	
	$("#doctors").children("option").remove();
	$("#date").children("option").remove();
	$("#hours").children("option").remove();
	
	$.post("BookingDoctor", $(this).serialize(), function(response){
		$.each(response, function(index, item) { 
			doctors.add(new Option(item.name));
			$("#fiscal_code").val(item.fiscal_code);
        });
	});
		return false;
});