<%--
  Created by IntelliJ IDEA.
  User: Bipin Khatiwada
  Date: 7/3/2018
  Time: 3:41 PM
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
    <title>Register || New member</title>
    <!-- Bootstrap core CSS-->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom fonts for this template-->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="/CSS/sb-admin.css" rel="stylesheet">
</head>

<body class="bg-dark">
<div class="container">
    <div class="card card-register mx-auto mt-5">
        <div class="card-header">Register for an Account</div>
        <div class="card-body">
            <form action="/register" method="POST">
                <div class="form-group">
                    <div class="form-row">

                        <div class="col-md-6">
                            <label for="exampleInputName">First name</label>
                            <input class="form-control" id="exampleInputName" type="text" name="fname"
                                   aria-describedby="nameHelp" placeholder="Enter first name" required="required"
                                   autocomplete="off">
                        </div>

                        <div class="col-md-6">
                            <label for="exampleInputLastName">Last name</label>
                            <input class="form-control" id="exampleInputLastName" type="text" name="lname"
                                   aria-describedby="nameHelp" placeholder="Enter last name" required="required"
                                   autocomplete="off">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="exampleInputUserName">User name</label>
                        <input class="form-control" id="exampleInputUserName" type="text" name="uname"
                               aria-describedby="nameHelp" placeholder="Enter username" required="required"
                               autocomplete="off">
                    </div>


                    <div class="form-group">
                        <label for="exampleInputEmail1">Email address</label>
                        <input class="form-control" id="exampleInputEmail1" type="email" name="email" aria-describedby="emailHelp"
                               placeholder="Enter email" autocomplete="off">
                    </div>


                    <div class="form-group">
                        <label for="exampleInputPassword1">Password</label>
                        <input class="form-control" id="exampleInputPassword1" type="password" name="pass" placeholder="Password" autocomplete="off">
                    </div>

                    <div class="form-group">
                        <label for="exampleInputPhone">Phone</label>
                        <input class="form-control" id="exampleInputPhone" type="tel"  name="phone" aria-describedby="emailHelp"
                               placeholder="Enter phone" autocomplete="off">
                    </div>

                    <input type="submit" name="Register" class="btn btn-primary btn-block" value="Register">
                </div>
            </form>
            <div class="text-center">
                <a class="d-block small mt-3" href="/login?page=login">Login Page</a>
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
    $( document ).ready(function() {

        if('${msg}'!=''){
            alert('${msg}');
        }
    });
</script>
</body>

</html>
