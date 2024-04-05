<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<br>
 	<nav
		aria-label="breadcrumb" role="navigation">
	<ol class="breadcrumb">
		<li class="breadcrumb-item active" aria-current="page">Book Tickets</li>
	</ol>
	</nav>
	
	<center>
		  <b><%@ include file="businessMessage.jsp"%></b>
	</center>
	

	
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Invoice Number</th>
				<th scope="col">Theater Name</th>
				<th scope="col">Movie Name</th>
				<th scope="col">Show Time</th>
				<th scope="col">Date</th>
				<th scope="col">Screen No</th>
				<th scope="col">Seat No</th>
				<th scope="col">Price</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="in" varStatus="cs">
			<tr>
				<td>${in.invoiceNumber}</td>
				<td>${in.theaterName}</td>
				<td>${in.movieName}</td>
				<td>${in.show_time}</td>
				<td>${in.date}</td>
				<td>${in.screenNo}</td>
				<td>${in.seatNo}</td>
				<td>${in.price}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<hr>
	
<br>
	