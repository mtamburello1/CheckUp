<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking details</title>
<link rel="stylesheet" href="././css/FragmentsCSS/Header.css"
	type="text/css" />
<link rel="stylesheet" href="././css/FragmentsCSS/Footer.css"
	type="text/css" />
<link rel="stylesheet"
	href="././css/BookingCSS/BookingCancelConfirmation.css" type="text/css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
</head>
<body>
	<!-- INCLUSIONE HEADER -->
	<%@include file="../../Fragments/Header.jsp"%>


	<%@page import="model.Bean.BookingVisitBean"%>
	<div class="container" id="container">
		<%
		if (user != null && user instanceof PatientBean) {
			BookingVisitBean booking = (BookingVisitBean) request.getAttribute("bookingToDelete");
		%>

		<div class="row" id="row0">
			<h1>Dettagli prenotazione</h1>
		</div>

		<div class="row" id="row1">
			<table>
				<tr>
					<td>Paziente: <%=booking.getPatient().getSurname()%> <%=booking.getPatient().getUser_name()%>
					</td>
				</tr>
				<tr>
					<td>Data di nascita : <%=booking.getPatient().getBirth_date()%>
					</td>
				</tr>
				<tr>
					<td>CF: <%=booking.getPatient().getFiscal_code()%>
					</td>
				</tr>
				<tr>
					<td>Medico: <%=booking.getDoctor().getSurname()%> <%=booking.getDoctor().getUser_name()%>
					</td>
				</tr>

				<tr>
					<td>Data: <%=booking.getBooking_day().toString()%>
					</td>
				</tr>
				<tr>
					<td>Ora: <%=booking.getBooking_hour().toString()%>
					</td>
				</tr>
				<tr>
					<td>Tipo: <%=booking.getBooking_type()%>
					</td>
				</tr>
			</table>
			<h1 id="question">Vuoi eliminare questa prenotazione?</h1>


			<form action="BookingCancelConfirmation">
				<input type="hidden" value="<%=booking.getBooking_code()%>" name="booking_code"></input>
				<input type="submit" value="Conferma" class="buttonChoice">
				<a href="BookingList"><input type="button" value="Annulla"
					class="buttonChoice" id="returnList"></input></a>
			</form>
		</div>
		<%
		} else {
		%>
		<div class="row" id="row2">
			<p>PAGINA RISERVATA.</p>
		</div>
		<%
		}
		%>
	</div>

	<!-- INCLUSIONE FOOTER-->
	<%@include file="../../Fragments/Footer.jsp"%>
</body>
</html>