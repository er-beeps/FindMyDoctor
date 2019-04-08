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
    <title>Schedule || Entry</title>
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
            <form action="/schedule" method="POST">
                <input type="hidden" name="page" value="createSchedule"/>

                <div class="form-group">
                    <label>NMC Code</label>
                    <input class="form-control" type="text" name="nmccode"
                           placeholder="Enter NMC code" required="required"
                           autocomplete="off">
                </div>

                <div class="form-group">
                    <label>Doctor Name</label>
                    <input class="form-control" type="text" name="docname"
                           placeholder="Enter doctor name" required="required"
                           autocomplete="off">
                </div>

                <div class="form-group">
                    <label>Health Institute ID</label>
                    <input class="form-control" type="text" name="hid"
                           placeholder="Enter institute ID" required="required"
                           autocomplete="off">
                </div>


                <div class="form-group">
                    <label>Health Institute Name</label>
                    <input class="form-control" type="text" name="hname"
                           placeholder="Enter institute name" required="required"
                           autocomplete="off">
                </div>


                <div class="form-group">
                    <label>Health Institute Type</label>
                    <select class="form-control" name="htype">
                        <option>----------</option>
                        <option>Hospital</option>
                        <option>Clinic</option>
                    </select>
                </div>

                <div class="form-group">
                    <label>Day</label>
                        <select class="form-control" name="day">
                            <option>----------</option>
                            <option>Sunday</option>
                            <option>Monday</option>
                            <option>Tuesday</option>
                            <option>Wednesday</option>
                            <option>Thursday</option>
                            <option>Friday</option>
                            <option>Saturday</option>
                        </select>
                </div>

                <div class="form-group">
                    <label>Start time</label>
                    <input class="form-control" type="time" name="starttime" required="required"
                           autocomplete="off">
                </div>


                <div class="form-group">
                    <label >End time</label>
                    <input class="form-control"  type="time" name="endtime" required="required"
                            autocomplete="off">
                </div>


                <input type="submit" name="Save" value="Save" class=" btn btn-success btn-block"><br>
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
