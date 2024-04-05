<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
 <nav
		aria-label="breadcrumb" role="navigation"  >
	<ol class="breadcrumb">
		
		<li class="breadcrumb-item active" aria-current="page">Booking Movie</li>
	</ol>
	</nav>

<div col-md-5 img-thumbnail">
           <div id="feedback"> <div class="container">
<div class="col-md-5">
    <div class="form-area">  
       <sf:form method="post" action="${pageContext.request.contextPath}/invoice"  modelAttribute="form" >
        <br style="clear:both">
                    <h3 style="margin-bottom: 15px; text-align: left: ;">Book Ticket</h3>
                    <b><%@ include file="businessMessage.jsp"%></b>
                	
							<sf:hidden path="id" />
							
							<div class="form-group">
								<s:bind path="name">
								<label >Name :</label> 
								<sf:input path="${status.expression}" placeholder="Enter Name" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
							</s:bind>
							</div>
							
							<div class="form-group">
								<s:bind path="email">
								<label >Email Id :</label> 
								<sf:input path="${status.expression}" placeholder="Enter Email Id" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
							</s:bind>
							</div>
							
							<div class="form-group">
								<s:bind path="mobileNo">
								<label >Mobile No:</label> 
								<sf:input path="${status.expression}" placeholder="Enter Mobile No" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
							</s:bind>
							</div>
							
							<div class="form-group">
								<s:bind path="showtime">
								<label >Show Time:</label> 
								<sf:select class="form-control" path="${status.expression}">
									<sf:option value="" label="Select" />
									<sf:options   items="${showTime}" />
								</sf:select>
								<font color="red"><sf:errors path="${status.expression}" /></font>
							</s:bind>
							</div>
							
							<div class="form-group">
								<s:bind path="noOfSeat">
								<label >No Of Person:</label> 
								<sf:input path="${status.expression}" placeholder="Enter No of Person" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
							</s:bind>
							</div>
						
							
        					 <input type="submit" name="operation"
								class="btn btn-primary pull-right" value="Payment">
        </sf:form>
    </div>
</div>
</div> </div> <!--feedback-->
<br>

	