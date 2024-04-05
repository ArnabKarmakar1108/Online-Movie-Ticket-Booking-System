<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <style>
        body {
            height: 100vh;
            background: linear-gradient(to top, #c9c9ff 50%, #9090fa 90%) no-repeat;
        }
        .form-area {
            padding: 20px;
            border-radius: 10px;
            background-image: url("../../../webapp/resources/images/theaterBg.jpg");
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        }
        .form-group {
            margin-bottom: 20px;
        }
        .form-control {
            padding: 10px;
        }
        .btn {
            margin-top: 15px;
            padding: 10px 20px;
            width: 100%;
        }
        .container {
            width: 100%;
            margin: auto;
        }
        img {
            width: 40px;
            height: 40px;
            object-fit: cover;
            border-radius: 50%;
            position: relative;
        }
        .bordert {
            margin-top: 20px; /* Adjust margin-top as needed */
            border-top: 1px solid #aaa;
            display: flex;
            align-items: center;
            justify-content: center;
            position: relative;
        }
        .bordert:before,
        .bordert:after {
            content: "";
            flex: 1;
            height: 1px;
            background-color: #aaa;
        }
        .bordert:before {
            margin-right: 10px; /* Adjust margin-right as needed */
        }
        .bordert:after {
            margin-left: 10px; /* Adjust margin-left as needed */
        }
        .bordert span {
            background-color: #fff;
            padding: 0px 8px;
            position: relative;
            z-index: 1;
        }
        .social-icons {
            display: flex;
            justify-content: center;
            margin-top: 10px; /* Adjust margin-top as needed */
        }
        .social-icons a {
            margin: 0 10px; /* Adjust margin as needed */
        }
        @media(max-width: 360px) {
            #forgot {
                margin-left: 0;
                padding-top: 10px;
            }
            body {
                height: 100%;
            }
            .container {
                margin-top: 50px;
                margin: 30px 0;
            }
            .bordert:after {
                left: 25%;
            }
        }
    </style>
</head>
<body>

<nav aria-label="breadcrumb" role="navigation">
    <ol class="breadcrumb justify-content-center">
        <li class="breadcrumb-item active" aria-current="page">Login</li>
    </ol>
</nav>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-5 img-thumbnail">
            <div id="feedback">
                <div class="form-area">
                    <sf:form method="post" action="${pageContext.request.contextPath}/login" modelAttribute="form">
                        <h3 style="margin-bottom: 15px; text-align: center;">Login</h3>
                        <b><%@ include file="businessMessage.jsp"%></b>
                        <div class="form-group">
                            <s:bind path="login">
                                <label>Login Id:</label>
                                <sf:input path="${status.expression}" placeholder="Enter Login" class="form-control" />
                                <font color="red" style="font-size: 13px"><sf:errors path="${status.expression}" /></font>
                            </s:bind>
                        </div>
                        <div class="form-group">
                            <s:bind path="password">
                                <label for="pwd">Password:</label>
                                <sf:input type="password" path="${status.expression}" placeholder="Enter Password" class="form-control" />
                                <font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
                            </s:bind>
                        </div>
                        <input type="submit" name="operation" class="btn btn-primary pull-right" value="Sign In"> 
                        <div class="bordert">
                            <span>or connect with</span>
                        </div>
                        <div class="social-icons">
                            <a href="https://wwww.facebook.com" target="_blank"> <img src="https://www.dpreview.com/files/p/articles/4698742202/facebook.jpeg" alt=""> </a>
                            <a href="https://www.google.com" target="_blank"> <img src="https://www.freepnglogos.com/uploads/google-logo-png/google-logo-png-suite-everything-you-need-know-about-google-newest-0.png" alt=""> </a>
                            <a href="https://www.github.com" target="_blank"> <img src="https://www.freepnglogos.com/uploads/512x512-logo-png/512x512-logo-github-icon-35.png" alt=""> </a>
                        </div>
                    </sf:form>
                </div>
            </div>
            <!-- feedback -->
            <br>
        </div>
    </div>
</div>

</body>
</html>
