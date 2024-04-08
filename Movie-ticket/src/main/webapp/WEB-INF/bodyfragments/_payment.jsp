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
        <li class="breadcrumb-item active" aria-current="page">Payment</li>
    </ol>
</nav>

<div class="center-container">
    <div class="form-area">
        <sf:form method="post" action="${pageContext.request.contextPath}/invoice" modelAttribute="form">
            <br style="clear:both">
            <h3 style="margin-bottom: 15px; text-align: left;">Payment</h3>
            <div class="form-group">
                <label>Card Number:</label>
                <input type="text" placeholder="Enter Card Number" class="form-control">
            </div>
            <div class="form-group">
                <label>Card Holder Name:</label>
                <input type="text" placeholder="Enter Card Holder Name" class="form-control">
            </div>
            <div class="form-group">
                <label>Month:</label>
                <input type="text" placeholder="Enter Month" class="form-control">
            </div>
            <div class="form-group">
                <label>Year:</label>
                <input type="text" placeholder="Enter Year" class="form-control">
            </div>
            <div class="form-group">
                <label>CVV:</label>
                <input type="text" placeholder="Enter CVV" class="form-control">
            </div>
            <input type="submit" name="operation" class="btn btn-primary pull-right" value="Confirm Payment">
        </sf:form>
    </div>
</div>
