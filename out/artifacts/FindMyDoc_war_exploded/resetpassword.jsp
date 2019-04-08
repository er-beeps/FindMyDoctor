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
    <title>Reset Password</title>
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
        <div class="card-header">Reset your password</div>
        <div class="card-body">
            <form action="/reset" method="POST">
                <input type="hidden" name="email" value="${email}">
                <div class="form-group">


                    <div class="form-group">
                        <label for="exampleInputPassword2">Email</label>
                        <input class="form-control" id="exampleInputEmail1" type="email" name="email" value="${email}"
                               aria-describedby="emailHelp" disabled>
                    </div>



                    <div class="form-group">
                        <label for="exampleInputPassword2">New Password</label>
                        <input class="form-control" id="exampleInputPassword2" type="password" name="newpass" placeholder="Enter your new password">
                    </div>


                    <div class="form-group">
                        <label for="exampleInputPassword3"> Verify New Password</label>
                        <input class="form-control" id="exampleInputPassword3" type="password" name="verpass" placeholder="Re-enter your new password">
                    </div>

                    <input type="submit" name="Submit" class="btn btn-success btn-block" value="Reset Password"><br>
                </div>
            </form>
            <center><a class="btn btn-danger" href="/login?page=login">Cancel</a></center>
        </div>
    </div>
</div>
<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
</body>

</html>
