<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<html>
<head>
    <style>
        /* Centering container */
        body {
            height: 100vh;
            background: linear-gradient(to top, #c9c9ff 50%, #9090fa 90%) no-repeat;
        }
        .center-container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh; /* Adjust as needed */
            background-image: url('../../resources/images/theaterBg.jpg'); /* Add your background image URL here */
            background-size: cover;
            background-position: center;
        }

        /* Fancy form styling */
        .form-area {
            background-color: rgba(255, 255, 255, 0.8); /* Adjust the background color with opacity as needed */
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            width: 80%; /* Adjust the width as needed */
            max-width: 600px; /* Maximum width for responsiveness */
            margin: 0 auto; /* Center the form horizontally */
        }

        .form-area h3 {
            color: #333;
            text-align: center;
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
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            width: 45%;
        }

        .btn-primary:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="center-container">
    <div class="form-area">
        <sf:form method="post" action="${pageContext.request.contextPath}/theater" modelAttribute="form" enctype="multipart/form-data">
            <br style="clear:both">
            <h3 style="margin-bottom: 15px; text-align: center ;">Add Theater</h3>
            <b><%@ include file="businessMessage.jsp"%></b>

            <sf:hidden path="id" />

            <div class="form-group">
                <s:bind path="name">
                    <label>Name :</label>
                    <sf:input path="${status.expression}" placeholder="Enter Name" class="form-control" />
                    <font color="red" style="font-size: 13px"><sf:errors path="${status.expression}" /></font>
                </s:bind>
            </div>

            <div class="form-group">
                <s:bind path="city">
                    <label>City :</label>
                    <sf:input path="${status.expression}" placeholder="Enter City" class="form-control" />
                    <font color="red" style="font-size: 13px"><sf:errors path="${status.expression}" /></font>
                </s:bind>
            </div>

            <div class="form-group">
                <s:bind path="type">
                    <label>Theater Type:</label>
                    <sf:select class="form-control" path="${status.expression}">
                        <sf:option value="" label="Select" />
                        <sf:options items="${type}" />
                    </sf:select>
                    <font color="red" style="font-size: 13px"><sf:errors path="${status.expression}" /></font>
                </s:bind>
            </div>

            <div class="form-group">
                <s:bind path="address">
                    <label>Address:</label>
                    <sf:textarea rows="3" cols="5" path="${status.expression}" placeholder="Enter Address" class="form-control" />
                    <font color="red"><sf:errors path="${status.expression}" /></font>
                </s:bind>
            </div>

            <div class="form-group">
                <s:bind path="image">
                    <label>Image:</label>
                    <sf:input type="file" path="${status.expression}" placeholder="Enter Image" class="form-control" required="required" />
                    <font color="red"><sf:errors path="${status.expression}" /></font>
                </s:bind>
            </div>
            
            <div class="ml-4">
                <input type="submit" name="operation" class="btn btn-primary pull-right mr-2" value="Save">or<input type="submit" name="operation" class="btn btn-primary pull-right ml-2" value="Reset">
            </div>
        </sf:form>
    </div>
</div>
</body>
</html>
