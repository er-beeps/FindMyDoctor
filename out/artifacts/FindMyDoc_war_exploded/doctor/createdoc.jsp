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
    <title>Doctor || Entry</title>
    <!-- Bootstrap core CSS-->
    <link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom fonts for this template-->
    <link href="/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="/CSS/sb-admin.css" rel="stylesheet">
</head>

<body class="bg-dark">
<div class="container">
    <div class="card card-register mx-auto mt-2">
        <div class="card-header">Fill the following details</div>
        <div class="card-body">
            <form action="/doctor" method="POST">
                <input type="hidden" name="page" value="createDoctor"/>

                <div class="form-group">
                    <label>NMC Code</label>
                    <input class="form-control" type="text" name="nmcCode"
                           aria-describedby="nameHelp" placeholder="Enter NMC code" required="required"
                           autocomplete="off">
                </div>

                <div class="form-group">
                    <div class="form-row">
                        <div class="col-md-6">
                            <label>First name</label>
                            <input class="form-control" type="text" name="firstName"
                                   aria-describedby="nameHelp" placeholder="Enter first name" required="required"
                                   autocomplete="off">
                        </div>


                        <div class="col-md-6">
                            <label>Last name</label>
                            <input class="form-control" type="text" name="lastName"
                                   aria-describedby="nameHelp" placeholder="Enter last name" required="required"
                                   autocomplete="off">
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label>Specialization</label>
                    <input class="form-control" type="text" name="speciality"
                           aria-describedby="nameHelp" placeholder="Enter Specialization" required="required"
                           autocomplete="off">
                </div>


                <div class="form-group">
                    <label>Degree</label>
                    <input class="form-control" type="text" name="degree"
                           aria-describedby="degreeHelp"
                           placeholder="Enter degree" autocomplete="off">
                </div>


                <div class="form-group">
                    <label>Passed Year</label>
                    <input class="form-control" type="number" name="passedYear"
                           placeholder=" Enter Passed Year">
                </div>


                <input type="submit" name="Save" value="Save" class="btn btn-success btn-block"></br>
            </form>
            <a class="btn btn-danger btn-block" href="/dashboard.jsp">Cancel</a>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="/vendor/jquery/jquery.min.js"></script>
<script src="/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Core plugin JavaScript-->
<script src="/vendor/jquery-easing/jquery.easing.min.js"></script>
</body>

</html>
