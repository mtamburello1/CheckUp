<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>

<div class="container">
	<div class="row" id="row">
		<div class="col-md-6">
			<form method="post" action="NewBooking">
				<label for="type">Che tipo di visita vuoi prenotare?</label> 
				<select name="specialization" id="type" required>
					<%ArrayList<String> specializations=new ArrayList<String>();
					specializations=(ArrayList<String>)request.getAttribute("specializations");
				if(specializations!=null){
				for(int i=0; i<specializations.size(); i++) {%>
					<option value="<%=specializations.get(i) %>"><%=specializations.get(i) %></option>
					<%}
				} %>
				</select>
				
				<label for="doctor">Seleziona un medico:</label> 
				<select name="doctors" id="doctors" required>
				<option value="" disabled selected hidden>Scegliere il tipo di visita</option>
				</select>
				<input type="hidden" id="fiscal_code" name="fiscal_code" value="">
			
				<label for="date">Seleziona una data:</label> 
				<select name="date" id="date" required>
				<option value="" disabled selected hidden>Scegliere un medico</option>
				</select>
				
				<label for="hours">Seleziona l'orario:</label>
				<select name="hours" id="hours" required>
				<option value="" disabled selected hidden>Scegliere una data</option>
				</select>
				<input type="hidden" value="" name="timetable_code" id="timetable_code"></input>
				
				<br/>
				<br/>
				<input type="submit" value="Conferma">
			</form>
		</div>
	</div>
</div>
