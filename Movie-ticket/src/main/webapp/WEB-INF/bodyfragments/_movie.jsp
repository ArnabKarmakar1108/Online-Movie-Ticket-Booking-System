<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
 <nav
		aria-label="breadcrumb" role="navigation"  >
	<ol class="breadcrumb">
		
		<li class="breadcrumb-item active" aria-current="page">Add Movie</li>
	</ol>
	</nav>

<div col-md-5 img-thumbnail">
           <div id="feedback"> <div class="container">
<div class="col-md-5">
    <div class="form-area">  
       <sf:form method="post" action="${pageContext.request.contextPath}/movie"  modelAttribute="form" enctype="multipart/form-data">
        <br style="clear:both">
                    <h3 style="margin-bottom: 15px; text-align: left: ;">Add Movie</h3>
                    <b><%@ include file="businessMessage.jsp"%></b>
							<sf:hidden path="id" />
							
							<div class="form-group">
								<s:bind path="theaterId">
								<label >Theater Name :</label> 
								<sf:select class="form-control" path="${status.expression}">
									<sf:option value="-1" label="Select" />
									<sf:options itemLabel="name" itemValue="id" items="${theaterList}" />
								</sf:select>
								<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
							</s:bind>
							</div>
							
							<div class="form-group">
								<s:bind path="name">
								<label >Name :</label> 
								<sf:input path="${status.expression}" placeholder="Enter Name" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
							</s:bind>
							</div>
							
							<div class="form-group">
								<s:bind path="code">
								<label >Code:</label> 
								<sf:input path="${status.expression}" placeholder="Enter Code" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
							</s:bind>
							</div>
							
							<div class="form-group">
								<s:bind path="screenNo">
								<label >Screen No:</label> 
								<sf:input path="${status.expression}" placeholder="Enter Screen No" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
							</s:bind>
							</div>
							
							<div class="form-group">
								<s:bind path="language">
								<label >Language:</label> 
								<sf:input path="${status.expression}" placeholder="Enter language" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
							</s:bind>
							</div>
							
							<div class="form-group">
								<s:bind path="directorName">
								<label >Director Name:</label> 
								<sf:input path="${status.expression}" placeholder="Enter directorName" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
							</s:bind>
							</div>
							
							<div class="form-group">
								<s:bind path="cast">
								<label >Star Cast:</label> 
								<sf:textarea rows="3"  cols="5" path="${status.expression}"
									placeholder="Enter Star Cast" class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
							</s:bind>
							</div>
							
							<div class="form-group">
								<s:bind path="price">
								<label >Price:</label> 
								<sf:input path="${status.expression}" placeholder="Enter Price" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
							</s:bind>
							</div>
							
							
							
							<div class="form-group">
								<s:bind path="image">
								<label >Image:</label> 
								<sf:input type="file"  path="${status.expression}"
									placeholder="Enter Image"  required="required" class="form-control" />
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

	