<%@page import="in.co.movie.ticket.entity.UserEntity"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<style>
	/* Custom styles for navbar */
	.navbar {
	  position: fixed;
	  top: 0;
	  width: 100%;
	  z-index: 1000; /* Ensure it's above other content */
	  font-size: 18px; /* Increase font size */
	}
	.navbar-brand {
    color: white !important; /* Ensure text color is white */
  }
</style>
<nav class="navbar navbar-expand-lg navbar-light "style="background-color: gray;">
	<b class="navbar-brand">Movie Ticket Booking</b>
</nav>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">

			<li class="nav-item active"><a class="nav-link"
				href="<c:url value="/home"/>">Home <span class="sr-only">(current)</span></a>
			</li>

			<%
				UserEntity userBean = (UserEntity) session.getAttribute("user");
			boolean userLoggedIn = userBean != null;
			%>

			<%
				if (userLoggedIn) {
			%>
			<%
				if (userBean.getRoleId() == 1) {
			%>

			<li class="nav-item active"><a class="nav-link"
				href="<c:url value="/theater"/>">Add Theater</a></li>

			<li class="nav-item active"><a class="nav-link"
				href="<c:url value="/theater/search"/>">Theater List</a></li>

			<li class="nav-item active"><a class="nav-link"
				href="<c:url value="/movie"/>">Add Movie</a></li>

			<li class="nav-item active"><a class="nav-link"
				href="<c:url value="/movie/search"/>">Movie List</a></li>

			<li class="nav-item active"><a class="nav-link"
				href="<c:url value="/invoice/search"/>">Invoice Details</a></li>

			<!-- <li class="nav-item active"><a class="nav-link"
				href="<c:url value="/invoice/detail/search"/>">Invoice </a></li> -->

			<%-- <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Theater
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="<c:url value="/theater"/>">Add Theater</a>
          <a class="dropdown-item" href="">User List</a>
        </div>
      </li> --%>
			<%
				} else if (userBean.getRoleId() == 2) {
			%>
			<li class="nav-item active"><a class="nav-link"
				href="<c:url value="/welcome"/>">Movies<span class="sr-only">(current)</span></a>
			</li>
			<li class="nav-item active"><a class="nav-link"
				href="<c:url value="/invoice/search"/>">Invoice Details</a></li>
			<!-- <li class="nav-item active"><a class="nav-link"
				href="<c:url value="/invoice/detail/search"/>">Invoice</a></li> -->


			<%
				}
			%>

			<li class="nav-item active"><a class="nav-link"
				href="<c:url value="/ctl/profile"/>">My Profile</a></li>

			<li class="nav-item active"><a class="nav-link"
				href="<c:url value="/ctl/changepassword"/>">Change Password</a></li>

			<%
				} else {
			%>
			<li class="nav-item active"><a class="nav-link"
				href="<c:url value="/welcome"/>">Movies<span class="sr-only">(current)</span></a>
			</li>
			<%
				}
			%>


		</ul>


	</div>


	<ul class="nav justify-content-end">


		<%
			if (userLoggedIn) {
		%>
		<li class="nav-item"><a class="nav-link"
			href="<c:url value="/login"/>">Logout</a></li>
		<%
			} else {
		%>
		<li class="nav-item"><a class="nav-link"
			href="<c:url value="/login"/>">Sign In</a></li>
		<li class="nav-item "><a class="nav-link"
			href="<c:url value="/signUp"/>">Sign Up</a></li>
		<%
			}
		%>

	</ul>

</nav>

