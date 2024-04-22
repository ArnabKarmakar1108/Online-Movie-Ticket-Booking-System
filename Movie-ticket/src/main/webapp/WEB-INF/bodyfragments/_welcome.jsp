<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<c:url var="homeSearch" value="/home/movie?tid=" />

<br>
<nav aria-label="breadcrumb" role="navigation">
    <ol class="breadcrumb">
        <li class="breadcrumb-item active" aria-current="page">Welcome</li>
    </ol>
</nav>
<b><%@ include file="businessMessage.jsp"%></b>
<sf:form action="${pageContext.request.contextPath}/welcome" method="post" modelAttribute="form">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-8"> <!-- Adjust the column size to your preference -->
                <h3 style="margin-bottom: 15px; text-align: center;">Theaters Around You</h3>
                <div class="row">
                    <div class="col-lg-4"> <!-- Adjust the column size to your preference -->
                        <s:bind path="name">
                            <sf:input path="${status.expression}" placeholder="Enter Theater Name" class="form-control" />
                        </s:bind>
                    </div>
                    <div class="col-lg-4"> <!-- Adjust the column size to your preference -->
                        <s:bind path="city">
                            <sf:input path="${status.expression}" placeholder="Enter City" class="form-control" />
                        </s:bind>
                    </div>
                    <div class="col-lg-4"> <!-- Adjust the column size to your preference -->
                        <input type="submit" name="operation" class="btn btn-primary" value="Search">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <hr>
    <!-- Your hidden inputs and theater list code here -->
    <sf:input type="hidden" path="id" />
    <sf:input type="hidden" path="pageNo" />
    <sf:input type="hidden" path="pageSize" />
    <sf:input type="hidden" path="listsize" />
    <sf:input type="hidden" path="total" />
    <sf:input type="hidden" path="pagenosize" />
</sf:form>


<div class="container">
    <!-- <%-- Error message styling --%>
    <c:if test="${not empty error}">
        <div class="alert alert-danger" role="alert">
            ${error}
        </div>
    </c:if>

    <%-- Success message styling --%>
    <c:if test="${not empty success}">
        <div class="alert alert-success" role="alert">
            ${success}
        </div>
    </c:if> -->

    <%-- Display records --%>
    <div class="row">
        <c:forEach items="${list}" var="th" varStatus="cs">
            <!-- Record display content -->
        </c:forEach>
    </div>
    <div class="row">
        <c:forEach items="${list}" var="th" varStatus="cs">
            <div class="col-lg-4 mb-4"> <!-- Adjust the column size to your preference -->
                <div class="card">
                    <img src="${pageContext.request.contextPath}/theater/getImage/<c:out value='${th.id}'/>" class="card-img-top img-fluid" style="height: 200px; object-fit: cover;" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">${th.name}</h5>
                        <p class="card-text">Type: ${th.type} || City: ${th.city}</p>
                        <a href="${homeSearch}${th.id}" class="btn btn-primary">See Movie</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
