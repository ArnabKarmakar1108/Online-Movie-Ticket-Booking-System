<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<c:url var="addUrl" value="${pageContext.request.contextPath}/movie" />

<c:url var="addSearch" value="${pageContext.request.contextPath}/movie/search" />

<c:url var="editUrl" value="/movie?id=" />
<br>
 	<nav
		aria-label="breadcrumb" role="navigation">
	<ol class="breadcrumb">
		<li class="breadcrumb-item active" aria-current="page">Movie List</li>
	</ol>
	</nav>
	
  <sf:form action="${pageContext.request.contextPath}/movie/search" method="post" modelAttribute="form">
		<div id="feedback">
			<div class="container">
				<div class="col-md-9">
					<div class="form-area">
							<h3 style="margin-bottom: 15px; text-align: left;">Movie List</h3>
							<div class="form-row">
    							<div class="form-group col-lg-4">
								<s:bind path="name">
								<sf:input path="${status.expression}" placeholder="Enter name" class="form-control" />
							</s:bind>
							</div>
							<div class="form-group col-lg-4">
								<s:bind path="language">
								<sf:input path="${status.expression}" placeholder="Enter language" class="form-control" />
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
				<th scope="col">Theater Name</th>
				<th scope="col">Name</th>
				<th scope="col">Code</th>
				<th scope="col">Language</th>
				<th scope="col">Cast</th>
				<th scope="col">Director Name</th>
				<th scope="col">Price</th>
				<th scope="col">Edit</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="mv" varStatus="cs">
			<tr>
				<td ><input type="checkbox" class="case"
						name="ids" value="${mv.id}"></td>
				<td><img height="40%" width="40%" src="${pageContext.request.contextPath}/movie/getImage/<c:out value='${mv.id}'/>" alt="Image" class="img-fluid"></td>
				<td>${mv.theaterName}</td>
				<td>${mv.name}</td>
				<td>${mv.code}</td>
				<td>${mv.language}</td>
				<td>${mv.cast}</td>
				<td>${mv.directorName}</td>
				<td>${mv.price}</td>
				<td align="center">
						<a class="btn btn-success" href="${editUrl}${mv.id}">Edit</a> 
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
	