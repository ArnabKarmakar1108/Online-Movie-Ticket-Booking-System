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
                <input type="text" id="cardNumber" placeholder="Enter Card Number" class="form-control" pattern="(?:\d[ -]*?){13,16}" title="Please enter a valid credit card number">
            </div>
            <div class="form-group">
                <label>Card Holder Name:</label>
                <input type="text" id="cardHolderName" placeholder="Enter Card Holder Name" class="form-control">
            </div>
            <div class="form-group">
                <label>Month:</label>
                <input type="text" id="month" placeholder="Enter Month" class="form-control">
            </div>
            <div class="form-group">
                <label>Year:</label>
                <input type="text" id="year" placeholder="Enter Year" class="form-control">
            </div>
            <div class="form-group">
                <label>CVV:</label>
                <input type="text" id="cvv" placeholder="Enter CVV" class="form-control">
            </div>            
            <input type="submit" name="operation" class="btn btn-primary pull-right" value="Confirm Payment" onclick="return validateCreditCard()">
        </sf:form>
    </div>
</div>

<script>
    function validateCreditCard() {
        // Validate Card Number
        var cardNumber = document.getElementById("cardNumber").value.replace(/[ -]/g, ''); // Remove spaces and dashes
        var sum = 0;
        var doubleUp = false;
        for (var i = cardNumber.length - 1; i >= 0; i--) {
            var curDigit = parseInt(cardNumber.charAt(i));
            if (doubleUp) {
                curDigit *= 2;
                if (curDigit > 9) {
                    curDigit -= 9;
                }
            }
            sum += curDigit;
            doubleUp = !doubleUp;
        }
        if (sum % 10 != 0 || sum == 0) {
            alert("Invalid Credit Card Number!");
            return false;
        }

        // Validate Card Holder Name
        var cardHolderName = document.getElementById("cardHolderName").value.trim();
        if (cardHolderName === "") {
            alert("Please Enter Valid Name");
            return false;
        }

        // Validate Month
        var month = document.getElementById("month").value.trim();
        if (month === "" || month < 1 || month > 12) {
            alert("Please Enter Valid Expiration Month");
            return false;
        }

        // Validate Year
        var year = document.getElementById("year").value.trim();
        var curYear = new Date().getFullYear();
        if (year === "" || year < curYear) {
            alert("Please Enter Valid Expiration Year");
            return false;
        }

        // Validate CVV
        var cvv = document.getElementById("cvv").value.trim();
        if (cvv === "" || cvv.length != 3 || isNaN(cvv)) {
            alert("Please Enter Valid CVV");
            return false;
        }

        // All validations passed
        return true;
    }
</script>

