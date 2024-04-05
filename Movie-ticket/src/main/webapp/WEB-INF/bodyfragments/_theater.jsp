<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
 <nav
		aria-label="breadcrumb" role="navigation"  >
	<ol class="breadcrumb">
		
		<li class="breadcrumb-item active" aria-current="page">Add Theater</li>
	</ol>
	</nav>

<div col-md-5 img-thumbnail">
           <div id="feedback"> <div class="container">
<div class="col-md-5">
    <div class="form-area">  
       <sf:form method="post" action="${pageContext.request.contextPath}/theater"  modelAttribute="form" enctype="multipart/form-data">
        <br style="clear:both">
                    <h3 style="margin-bottom: 15px; text-align: left: ;">Add Theater</h3>
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
								<s:bind path="city">
								<label >City :</label> 
								<sf:input path="${status.expression}" placeholder="Enter City" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
							</s:bind>
							</div>
							
							<div class="form-group">
								<s:bind path="type">
								<label >Theater Type:</label> 
								<sf:select class="form-control" path="${status.expression}">
									<sf:option value="" label="Select" />
									<sf:options   items="${type}" />
								</sf:select>
								<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
							</s:bind>
							</div>
							
							<div class="form-group">
								<s:bind path="address">
								<label >Address:</label> 
								<sf:textarea rows="3"  cols="5" path="${status.expression}"
									placeholder="Enter Address" class="form-control" />
								<font color="red"><sf:errors path="${status.expression}" /></font>
							</s:bind>
							</div>
							
							<div class="form-group">
								<s:bind path="image">
								<label >Image:</label> 
								<sf:input type="file"  path="${status.expression}"
									placeholder="Enter Image" class="form-control" required="required" />
								<font color="red"><sf:errors path="${status.expression}" /></font>
							</s:bind>
							</div>
							
        					 <input type="submit" name="operation"
								class="btn btn-primary pull-right" value="Save">or<input type="submit" name="operation"
								class="btn btn-primary pull-right" value="Reset">
        </sf:form>
    </div>
</div>
</div> </div> <!--feedback-->
<br>

	