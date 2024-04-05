<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<c:url var="addUrl" value="${pageContext.request.contextPath}/theater" />

<c:url var="addSearch" value="${pageContext.request.contextPath}/theater/search" />

<c:url var="editUrl" value="/theater?id=" />
<br>
 	<nav
		aria-label="breadcrumb" role="navigation">
	<ol class="breadcrumb">
		<li class="breadcrumb-item active" aria-current="page">Theater List</li>
	</ol>
	</nav>
	
  <sf:form action="${pageContext.request.contextPath}/theater/search" method="post" modelAttribute="form">
		<div id="feedback">
			<div class="container">
				<div class="col-md-9">
					<div class="form-area">
							<h3 style="margin-bottom: 15px; text-align: left;">Theater List</h3>
							<div class="form-row">
    						<div class="form-group col-lg-4">
								<s:bind path="city">
								<sf:input path="${status.expression}" placeholder="Enter City" class="form-control" />
							</s:bind>
							</div>
							<div class="form-group col-lg-4">
							 <input type="submit" name="operation"
								class="btn btn-primary pull-right" value="Search">or<input type="submit" name="operation"
								class="btn btn-primary pull-right" value="Reset">
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
				<th scope="col">Select </th>
				<th scope="col">Image</th>
				<th scope="col">Name</th>
				<th scope="col">Theater Type</th>
				<th scope="col">City</th>
				<th scope="col">Address</th>
				<th scope="col">Edit</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="th" varStatus="cs">
			<tr>
				<td ><input type="checkbox" class="case"
						name="ids" value="${th .id}"></td>
				<td><img height="40%" width="40%" src="${pageContext.request.contextPath}/theater/getImage/<c:out value='${th.id}'/>" alt="Image" class="img-fluid"></td>
				<td>${th.name}</td>
				<td>${th.type}</td>
				<td>${th.city}</td>
				<td>${th.address}</td>
				<td align="center">
						<a class="btn btn-success" href="${editUrl}${th.id}">Edit</a> 
				</td>
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
					<td><input type="submit" name="operation" 
								class="btn btn-primary" value="New"	
								></td>
					<td><input type="submit" name="operation" <c:if test="${listsize== 0}">disabled="disabled"</c:if>
								class="btn btn-primary" value="Delete"	
								></td>
					
					<td align="right"><input type="submit" name="operation" <c:if test="${total == pagenosize  || listsize < pageSize}">disabled="disabled"</c:if>
								class="btn btn-primary" value="Next"></td>
				</tr>
			</table>
</sf:form>
<br>
	