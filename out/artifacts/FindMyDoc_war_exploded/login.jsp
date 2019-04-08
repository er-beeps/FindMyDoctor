<%--
  Created by IntelliJ IDEA.
  User: Bipin Khatiwada
  Date: 7/3/2018
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Login || FindMyDoc</title>
    <!-- Bootstrap core CSS-->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom fonts for this template-->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <!-- Custom styles for this template-->
    <link href="/CSS/sb-admin.css" rel="stylesheet">
</head>

<body class="bg-dark">
<div class="container">
    <div class="card card-login mx-5 mt-5">
        <div class="card-header">Login</div>
        <div class="card-body">
            <form action="/login" method="Post">
                <input type="hidden" name="page" value="login">

                <div>
                    <img src="/images/logo.png" class="logo">
                </div>
                <div class="form-group">
                    <label>User Name</label>
                    <input class="form-control" name="uname" type="text" placeholder="Enter username"
                           required="required">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input class="form-control" name="pass" type="password" id="password" placeholder="Enter password"
                           required="required">
                    <span toggle="#password" class="fa fa-fw fa-eye field-icon toggle-password "></span>
                </div>
                <div class="form-group">
                    <div class="form-check">
                        <label class="form-check-label">
                            <input class="form-check-input" type="checkbox"> Remember Password</label>
                    </div>
                </div>
                <input type="submit" class="btn btn-primary btn-block" value="Login">
            </form>
            <div class="text-center">
                <a class="d-block small mt-3" href="/register?page=register">Register an Account</a>
                <a class="d-block small" href="/reset?page=reset">Forgot Password?</a>
            </div>
        </div>
    </div>
</div>
<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<script>
    $(".toggle-password").click(function () {
        $(this).toggleClass("fa-eye fa-eye-slash");
        var input=$($(this).attr("toggle"));
        if (input.attr("type")=="password"){
            input.attr("type","text");
        }else {
            input.attr("type","password");
        }
    });
</script>

</body>
</html>
