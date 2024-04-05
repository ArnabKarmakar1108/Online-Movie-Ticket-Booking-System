<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
 <nav
		aria-label="breadcrumb" role="navigation"  >
	<ol class="breadcrumb">
		
		<li class="breadcrumb-item active" aria-current="page">Payment</li>
	</ol>
	</nav>

<div col-md-5 img-thumbnail">
           <div id="feedback"> <div class="container">
<div class="col-md-5">
    <div class="form-area">  
       <sf:form method="post" action="${pageContext.request.contextPath}/invoice"  modelAttribute="form" >
        <br style="clear:both">
                    <h3 style="margin-bottom: 15px; text-align: left: ;">Payment</h3>
                	
							
							<div class="form-group">
								<label >Card Number :</label> 
								<input type="text" placeholder="Enter Card Number" class="form-control">
							</div>
							
							<div class="form-group">
								<label >Card Holder Name :</label> 
								<input type="text" placeholder="Enter Card Holder Name" class="form-control">
							</div>
							
							<div class="form-group">
								<label >Month :</label> 
								<input type="text" placeholder="Enter Month" class="form-control">
							</div>
							
							<div class="form-group">
								<label >Year :</label> 
								<input type="text" placeholder="Enter Year" class="form-control">
							</div>
							
							<div class="form-group">
								<label >CVV :</label> 
								<input type="text" placeholder="Enter CVV" class="form-control">
							</div>
														
        					 <input type="submit" name="operation"
								class="btn btn-primary pull-right" value="Confirm Payment"">
        </sf:form>
    </div>
</div>
</div> </div> <!--feedback-->
<br>

	