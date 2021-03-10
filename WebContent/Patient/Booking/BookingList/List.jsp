<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container" id="container">
	<div class="row" id="row">
		<%@page import="java.util.ArrayList"%>
		<%@page import="model.Bean.BookingVisitBean"%>

		<%
		ArrayList<BookingVisitBean> bookings = (ArrayList<BookingVisitBean>) request.getAttribute("bookingList");
		if (bookings.size() != 0) {
		%>
		<div class="container" id="containerElements">
			<table style="width: 100%">
				<tr class="table_row">
					<th><p class="title">TIPO</p></th>
					<th><p class="title">MEDICO</p></th>
					<th><p class="title">DATA</p></th>
					<th><p class="title">ORARIO</p></th>
					<th><p class="title">STATO</p></th>
					<th></th>
				</tr>
				<%
				for (BookingVisitBean booking : bookings) {
				%>
				<tr class="table_row">
					<td><p id="booking_type"><%=booking.getBooking_type().toUpperCase()%></p></td>
					<td><p id="booking_doctor"><%=booking.getDoctor().getSurname()%>
							<%=booking.getDoctor().getUser_name()%></p></td>
					<td><p id="booking_date"><%=booking.getBooking_day()%></p></td>
					<td><p id="booking_hour"><%=booking.getBooking_hour().toString().substring(0, 5)%></p></td>
					<td>
						<%
						if (booking.isCarried_out()) {
						%>
						<p id="booking_carried_Out">Effettuata</p> <%
 } else {
 %>
						<p id="booking_carried_Out">In attesa</p> <%
 }
 %>
					</td>
					<td>
						<form action="RequestDeleteBooking" method="POST"
							class="formDelete">
							<input type="hidden" value="<%=booking.getBooking_type()%>"
								name="booking_type"> <input type="hidden"
								value="<%=booking.getBooking_code()%>" name="booking_code">
							<input type="hidden" name="booking_date"
								value="<%=booking.getBooking_day()%>"> <input
								type="hidden" name="booking_hour"
								value="<%=booking.getBooking_hour()%>"> <input
								type="hidden" name="doctor_fiscal_code"
								value="<%=booking.getDoctor().getFiscal_code()%>"> <input
								type="hidden" name="doctor_surname"
								value="<%=booking.getDoctor().getSurname()%>"><input
								type="hidden" name="doctor_user_name"
								value="<%=booking.getDoctor().getUser_name()%>"><input
								type="hidden" name="carried_out"
								value="<%=booking.isCarried_out()%>">

							<input type="submit" class="deleteBookingButton" value="Disdici">
						</form>
					</td>
				</tr>
				<%
				}
				%>
			</table>
		</div>
		<div class="container" id="newBookingContainer">
			<div class="row" id="row">
				<a href="BookingForm" id="newBookingLink">➕ Aggiungi</a>
			</div>
		</div>
		<%
		}

		else {
		%>
		<p id="noBooking">NON RISULTANO ANCORA PRENOTAZIONI EFFETTUATE.</p>
		<%
		}
		%>
	</div>
</div>