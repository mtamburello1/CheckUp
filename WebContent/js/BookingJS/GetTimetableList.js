/**
 * 
 * This script has the purpose of sending the value of the date field selected by the patient
 * to a control which returns the list of available times. 
 * This list is added to the appropriate select field through the same script.
 *
 */

$("#date").on('click',function(){

	$("#hours").children("option").remove();
	var param = $("#date").val();
	
	$.post("BookingHour",  {booking_date : param}, function(response){
		$.each(response, function(index, item) { 
			var time = item.hour;
			var hours = Number(time.match(/^(\d+)/)[1]);
			var minutes = Number(time.match(/:(\d+)/)[1]);
			var AMPM = time.match(/\s(.*)$/)[1];
			if(AMPM == "PM" && hours<12) hours = hours+12;
			if(AMPM == "AM" && hours==12) hours = hours-12;
			var sHours = hours.toString();
			var sMinutes = minutes.toString();
			if(hours<10) sHours = "0" + sHours;
			if(minutes<10) sMinutes = "0" + sMinutes;
			$("#hours").append(new Option(sHours + ":" + sMinutes + ":00"));
			$("#timetable_code").val(item.timetable_code);
        });
	});
	
		return false;
});