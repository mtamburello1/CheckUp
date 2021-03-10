<%@page import="model.Bean.PatientBean"%>
<div class="row" id="row">
	<div class="col-lg-4 col-sm-12">
		<%
		if (request.getSession().getAttribute("user") != null
				&& request.getSession().getAttribute("user") instanceof PatientBean) {
		%>
		<a href="/CheckUp/Booking/BookingForm">Effettua una prenotazione</a>
		<%
		} else {
		%>
		<a href="/CheckUp/Shared/Login.jsp">Effettua una prenotazione</a>
		<%
		}
		%>
	</div>
	<div class="col-lg-4 col-sm-12">
		<a href="#">Come fare per</a>
	</div>
	<div class="col-lg-4 col-sm-12">
		<a href="#">La struttura</a>
	</div>
</div>