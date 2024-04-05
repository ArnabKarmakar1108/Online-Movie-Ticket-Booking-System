<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>


<c:url var="addSearch" value="${pageContext.request.contextPath}/invoice/search" />

<br>
 	<nav
		aria-label="breadcrumb" role="navigation">
	<ol class="breadcrumb">
		<li class="breadcrumb-item active" aria-current="page">Movie List</li>
	</ol>
	</nav>
	
  <sf:form action="${pageContext.request.contextPath}/invoice/search" method="post" modelAttribute="form">
		<div id="feedback">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-md-9">
						<div class="form-area text-center">
							<h3 style="margin-bottom: 15px;">Invoice List</h3>
							<div class="form-group d-flex justify-content-center">
								<s:bind path="invoiceNumber">
									<sf:input path="${status.expression}" placeholder="Enter Invoice Number" class="form-control" />
								</s:bind>
								<input type="submit" name="operation" class="btn btn-primary ml-2" value="Search">
								<input type="submit" name="operation" class="btn btn-primary ml-2" value="Reset">
							</div>
						</div>
					</div>
				</div>
			</div>
				
		</div>
	<center>
		  <b><%@ include file="businessMessage.jsp"%></b>
	</center>
	
		<sf:input type="hidden" path="id" />

		<sf:input type="hidden" path="pageNo" />
		<sf:input type="hidden" path="pageSize" />

		<sf:input type="hidden" path="listsize" />
		<sf:input type="hidden" path="total" />
		<sf:input type="hidden" path="pagenosize" />
	
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Invoice Number</th>
				<th scope="col">Name</th>
				<th scope="col">Email</th>
				<th scope="col">Mobile No</th>
				<th scope="col">Theater Name</th>
				<th scope="col">Movie Name</th>
				<th scope="col">Date</th>
				<th scope="col">Show Time</th>
				<th scope="col">Total Seat</th>
				<th scope="col">Price</th>
				<th scope="col">Total Price</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="in" varStatus="cs">
			<tr>
				<td>${in.invoiceNumber}</td>
				<td>${in.name}</td>
				<td>${in.email}</td>
				<td>${in.mobileNo}</td>
				<td>${in.theatorName}</td>
				<td>${in.movieName}</td>
				<td>${in.date}</td>
				<td>${in.show_time}</td>
				<td>${in.noOfSeat}</td>
				<td>${in.price}</td>
				<td>${in.total}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<hr>
	<table width="99%" style=" bottom: 45px">
				<tr>

					<td><input type="submit" name="operation" <c:if test="${form.pageNo == 1}">disabled="disabled"</c:if>
								class="btn btn-primary" value="Previous"
								></td>
					
					
					<td align="right"><input type="submit" name="operation" <c:if test="${total == pagenosize  || listsize < pageSize}">disabled="disabled"</c:if>
								class="btn btn-primary" value="Next"></td>
				</tr>
			</table>
</sf:form>
<br>
	