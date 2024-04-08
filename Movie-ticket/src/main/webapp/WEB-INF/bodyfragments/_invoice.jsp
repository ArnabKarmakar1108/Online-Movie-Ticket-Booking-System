<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<head>
    <style>
        /* Fancy form styling */
        body {
            height: 100vh;
            background: linear-gradient(to top, #c9c9ff 50%, #9090fa 90%) no-repeat;
        }

        .form-area {
            background-color: #f9f9f9;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            width: 80%; /* Adjust the width as needed */
            max-width: 600px; /* Maximum width for responsiveness */
            margin: 0 auto; /* Center the form horizontally */
        }

        .form-area h3 {
            color: #333;
            text-align: left;
            margin-bottom: 15px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        label {
            font-weight: bold;
        }

        .form-control {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            transition: border-color 0.3s ease;
        }

        .form-control:focus {
            outline: none;
            border-color: #66afe9;
        }

        .btn-primary {
            background-color: #007bff;
            color: #fff;
            border: none;
            width: 100%;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .btn-primary:hover {
            background-color: #0056b3;
        }
    </style>
</head>

<nav aria-label="breadcrumb" role="navigation">
    <ol class="breadcrumb">
        <li class="breadcrumb-item active" aria-current="page">Booking Movie</li>
    </ol>
</nav>

<div class="center-container">
    <div class="form-area">
        <sf:form method="post" action="${pageContext.request.contextPath}/invoice" modelAttribute="form">
            <br style="clear:both">
            <h3 style="margin-bottom: 15px; text-align: left;">Book Ticket</h3>
            <b><%@ include file="businessMessage.jsp"%></b>
            <sf:hidden path="id" />
            <div class="form-group">
                <s:bind path="name">
                    <label>Name:</label>
                    <sf:input path="${status.expression}" placeholder="Enter Name" class="form-control" />
                    <font color="red" style="font-size: 13px"><sf:errors path="${status.expression}" /></font>
                </s:bind>
            </div>
            <div class="form-group">
                <s:bind path="email">
                    <label>Email Id:</label>
                    <sf:input path="${status.expression}" placeholder="Enter Email Id" class="form-control" />
                    <font color="red" style="font-size: 13px"><sf:errors path="${status.expression}" /></font>
                </s:bind>
            </div>
            <div class="form-group">
                <s:bind path="mobileNo">
                    <label>Mobile No:</label>
                    <sf:input path="${status.expression}" placeholder="Enter Mobile No" class="form-control" />
                    <font color="red" style="font-size: 13px"><sf:errors path="${status.expression}" /></font>
                </s:bind>
            </div>
            <div class="form-group">
                <s:bind path="showtime">
                    <label>Show Time:</label>
                    <sf:select class="form-control" path="${status.expression}">
                        <sf:option value="" label="Select" />
                        <sf:options items="${showTime}" />
                    </sf:select>
                    <font color="red"><sf:errors path="${status.expression}" /></font>
                </s:bind>
            </div>
            <div class="form-group">
                <s:bind path="noOfSeat">
                    <label>No Of Person:</label>
                    <sf:input path="${status.expression}" placeholder="Enter No of Person" class="form-control" />
                    <font color="red" style="font-size: 13px"><sf:errors path="${status.expression}" /></font>
                </s:bind>
            </div>
            <input type="submit" name="operation" class="btn btn-primary pull-right" value="Payment">
        </sf:form>
    </div>
</div>
