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
    <title>Health Institute || Edit</title>
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
        <div class="card-header">Edit the following details</div>
        <div class="card-body">
            <form action="/healthinstitute" method="POST">
                <input type="hidden" name="page" value="updateHealthinstitute"/>
                <input type="hidden" name="id" value="${h.id}"/>
                <input type="hidden" name="hid" value="${h.hid}"/>


                <div class="form-group">
                    <label>Health Institute ID</label>
                    <input class="form-control" type="text" name="hid" value="${h.hid}"
                            required="required" disabled>
                </div>

                <div class="form-group">
                    <label>Health Institute Name</label>
                    <input class="form-control" type="text" name="hname" value="${h.name}"
                         required="required">
                </div>


                <div class="form-group">
                    <label>Health Institute Type</label>
                    <select class="form-control" name="htype">
                        <option>${h.type}</option>
                        <option>Hospital</option>
                        <option>Clinic</option>
                    </select>
                </div>

                <div class="form-group">
                    <label>Address</label>
                    <input class="form-control" type="text" name="haddress" value="${h.address}"
                           required="required">
                </div>


                <div class="form-group">
                    <label>Phone</label>
                    <input class="form-control" type="tel" name="hphone" value="${h.phone}" required="required">
                </div>


                <input type="submit" name="update" value="Update" class="btn btn-primary btn-block"><br>
            </form>
            <center><a class="btn btn-danger" href="/healthinstitute?page=healthinstituteList">Cancel</a></center>
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
