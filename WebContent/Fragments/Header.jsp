<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<header>
	<nav role="navigation">
		<div class="row">
			<div id="menuToggle">

				<input type="checkbox" />

				<div class="burger">
					<span></span> 
					<span></span> 
					<span></span>
				</div>
				<%@page import="model.Bean.UserBean"%>
				<%@page import="model.Bean.PatientBean"%>
				<%@page import="model.Bean.DoctorBean"%>
				<%@page import="model.Bean.SecretaryBean"%>
				<%
				UserBean user = (UserBean) request.getSession().getAttribute("user");
				%>
				<ul id="menu">
					<a href="/CheckUp/index.jsp"><li>Home</li></a>
					<%
					if (user == null) {
					%>
					<a href="/CheckUp/Shared/Login.jsp"><li>Login</li></a>
					<a href="#"><li>Richiesta registrazione</li></a>
					<%
					} else {
					%>
					<%
					if (user instanceof PatientBean) {
					%>
					<a href="/CheckUp/Patient/ReservedArea.jsp"><li>Area riservata</li></a>
					<a href="/CheckUp/BookingForm"><li>Effettua una
							prenotazione</li></a>
					<%
					} else if (user instanceof SecretaryBean) {
					%>
					<a href="./Secretary/ReservedArea.jsp"><li>Area riservata</li></a>
					<%
					}
					else if (user instanceof DoctorBean){
					%>
					<a href="./Doctor/ReservedArea.jsp"><li>Area riservata</li></a>
					<%} %>
					<a href="/CheckUp/Logout"><li>Logout</li></a>
					<%
					}
					%>
				</ul>
			</div>
			<img src="/CheckUp/Img/Logo.png" />
		</div>
	</nav>
</header>