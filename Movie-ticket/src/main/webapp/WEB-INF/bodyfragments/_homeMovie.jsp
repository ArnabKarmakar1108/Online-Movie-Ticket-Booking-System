<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<br>
<c:url var="invoicePage" value="/invoice?mId="/>
<c:url var="loginPage" value="/login?tid="/>
<nav aria-label="breadcrumb" role="navigation">
    <ol class="breadcrumb">
        <li class="breadcrumb-item active" aria-current="page">Movies</li>
    </ol>
</nav>
<b><%@ include file="businessMessage.jsp"%></b>
<sf:form action="${pageContext.request.contextPath}/home/movie/" method="post" modelAttribute="form">
    <div class="container">

        <sf:input type="hidden" path="id" />

        <sf:input type="hidden" path="pageNo" />
        <sf:input type="hidden" path="pageSize" />

        <sf:input type="hidden" path="listsize" />
        <sf:input type="hidden" path="total" />
        <sf:input type="hidden" path="pagenosize" />

        <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3"> <!-- Adjusted layout for different screen sizes -->
            <c:forEach items="${list}" var="mv" varStatus="cs">
                <div class="col mb-4"> <!-- Added margin bottom -->
                    <div class="card">
                        <img height="400px" object-fit="cover"
                            src="${pageContext.request.contextPath}/movie/getImage/<c:out value='${mv.id}'/>"
                            class="card-img-top" alt="...">
                        <div class="card-body">
                            <h4 class="card-title">${mv.name}</h4>
                            <h6 class="card-title">${mv.directorName}</h6>
                            <p class="card-text">Cast : ${mv.cast}</p>
                            <p class="card-text">Language : ${mv.language}</p>
                            <h5 class="card-title">Price :${mv.price} Rs</h5>
                            <%if(session.getAttribute("user")!=null){ %>
                            <a href="${invoicePage}${mv.id}" class="btn btn-primary">Book Movie</a>
                            <%}else{%>
                            <a href="${loginPage}${mv.id}" class="btn btn-primary">Book Movie</a>
                            <%} %>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</sf:form>
