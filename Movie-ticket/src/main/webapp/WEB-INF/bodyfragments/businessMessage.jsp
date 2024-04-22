<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <c:if test="${success != null}">
                <div class="alert alert-success" role="alert">
                    <strong>${success}</strong>
                </div>
            </c:if>
            <c:if test="${error != null}">
                <div class="alert alert-danger" role="alert">
                    <strong>${error}</strong>
                </div>
            </c:if>
        </div>
    </div>
</div>
