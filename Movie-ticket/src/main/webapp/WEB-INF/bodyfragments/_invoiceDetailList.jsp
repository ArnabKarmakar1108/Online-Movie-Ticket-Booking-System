<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>


<c:url var="addSearch" value="${pageContext.request.contextPath}/invoice/detail/search" />

<br>
 	<nav
		aria-label="breadcrumb" role="navigation">
	<ol class="breadcrumb">
		<li class="breadcrumb-item active" aria-current="page">Movie List</li>
	</ol>
	</nav>
	
  <sf:form action="${pageContext.request.contextPath}/invoice/detail/search" method="post" modelAttribute="form">
		<div id="feedback">
			<div class="container">
				<div class="col-md-9">
					<div class="form-area">
							<h3 style="margin-bottom: 15px; text-align: left;">Invoice Detail List</h3>
							<div class="form-row">
    							<div class="form-group col-lg-4">
								<s:bind path="invoiceNumber">
								<sf:input path="${status.expression}" placeholder="Enter InvoiceNumber" class="form-control" />
							</s:bind>
							</div>
							<%-- <div class="form-group col-lg-4">
								<s:bind path="movieName">
								<sf:input path="${status.expression}" placeholder="Enter Movie Name" class="form-control" />
							</s:bind>
							</div> --%>
							<div class="form-group col-lg-4">
							 <input type="submit" name="operation"
								class="btn btn-primary pull-right mr-2" value="Search">or<input type="submit" name="operation"
								class="btn btn-primary pull-right ml-2" value="Reset">
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
				<th scope="col">Theater Name</th>
				<th scope="col">Movie Name</th>
				<th scope="col">Date</th>
				<th scope="col">Show Time</th>
				<th scope="col">No of Seat</th>
				<th scope="col">Price</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="ind" varStatus="cs">
			<tr>
				<td>${ind.invoiceNumber}</td>
				<td>${ind.theaterName}</td>
				<td>${ind.movieName}</td>
				<td>${ind.date}</td>
				<td>${ind.show_time}</td>
				<td>${ind.seatNo}</td>
				<td>${ind.price}</td>
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
	