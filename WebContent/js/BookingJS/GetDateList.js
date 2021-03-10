/**
 *	This script has the purpose of sending the data of the doctor selected by the patient
 *	to a control that processes them and returns the relative availability dates. 
 *	These dates are added to the select field through the same script.
 */

$("#doctors").on('click',function(){

	$("#date").children("option").remove();
	$("#hours").children("option").remove();
	hours.add(new Option("Seleziona una data."));
	hours.children[0].setAttribute("disabled", "");
	hours.children[0].setAttribute("hidden", "");
	
	var param = $("#fiscal_code").val();
	
	$.post("BookingDate",  {fiscal_code : param}, function(response){
		if(response.length == 0){
			date.add(new Option("Attualmente non ci sono date disponibili per il medico selezionato"));
			date.children[0].setAttribute("disabled", "");
			date.children[0].setAttribute("hidden", "");
			hours.add(new Option("Attualmente non ci sono orari disponibili per il medico selezionato"));
			hours.children[0].setAttribute("disabled", "");
			hours.children[0].setAttribute("hidden", "");
		}
		$.each(response, function(index, item) {
			date.add(new Option(item));
        });
	});
		return false;
});