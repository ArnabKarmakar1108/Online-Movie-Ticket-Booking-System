<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
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
<body>
    <nav aria-label="breadcrumb" role="navigation">
        <ol class="breadcrumb">
            <li class="breadcrumb-item active" aria-current="page">Change Password</li>
        </ol>
    </nav>
    <div class="center-container">
        <div class="form-area">
            <sf:form method="post" action="${pageContext.request.contextPath}/ctl/changepassword" modelAttribute="form">
                <br style="clear:both">
                <h3 style="margin-bottom: 15px; text-align: left;">Change Password</h3>
                <b><%@ include file="businessMessage.jsp"%></b>
                <div class="form-group">
                    <s:bind path="oldPassword">
                        <label for="pwd">Old Password:</label>
                        <sf:input type="password" path="${status.expression}" placeholder="Enter Old Password" class="form-control" />
                        <font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
                    </s:bind>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <s:bind path="newPassword">
                            <label for="pwd">Password:</label>
                            <sf:input type="password" path="${status.expression}" placeholder="Enter New Password" class="form-control" />
                            <font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
                        </s:bind>
                    </div>
                    <div class="form-group col-md-6">
                        <s:bind path="confirmPassword">
                            <label for="pwd">Confirm Password:</label>
                            <sf:input type="password" path="${status.expression}" placeholder="Enter Confirm Password" class="form-control" />
                            <font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
                        </s:bind>
                    </div>
                </div>
                <input type="submit" name="operation" class="btn btn-primary pull-right" value="Save" onclick="clearFormFields()">
            </sf:form>
        </div>
    </div>
</body>
</html>
