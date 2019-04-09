<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Bipin Khatiwada
  CurrentDate: 7/3/2018
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
    <title>Add new Member</title>
    <!-- Bootstrap core CSS-->
    <link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom fonts for this template-->
    <link href="/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="/CSS/sb-admin.css" rel="stylesheet">

    <link rel="stylesheet" href="/multipagecss/css/style.css">
    <link rel="stylesheet" href="/multipagecss/css/form-elements.css">

    <script type="text/javascript" src="/appointment/district.js">
    </script>
</head>

<body>
<jsp:include page="/navbar/navbar.jsp"/>
<div class="content-wrapper">
    <div class="container-fluid">
        <ol class="breadcrumb">
            <li class="breadcrumb-item">
                <a href="/dashboard.jsp">Dashboard</a>
            </li>
            <li class="breadcrumb-item active">Add a new member</li>
        </ol>
        <div class="card  mx-auto mt-3 bg-light" style="width:70%;">
            <div class="card-header">
                <i class="fa fa-fw fa-pencil"> </i> Fill the following details and submit to add a new member !!
            </div>
            <div class="card-body">
                <form action="/member" method="POST">
                    <input type="hidden" name="page" value="createMember"/>
                    <input type="hidden" name="uname" value="${uname}">

                    <fieldset>
                        <h3>Personal Information:</h3><br>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-6">
                                    <label for="exampleInputName">First name:</label>
                                    <input class="form-control" id="exampleInputName" type="text" name="firstname" placeholder="Enter first name" required="required" autocomplete="off">
                                </div>

                                <div class="col-md-6">
                                    <label for="exampleInputLastName">Last name:</label>
                                    <input class="form-control" id="exampleInputLastName" type="text"
                                           name="lastname" placeholder="Enter last name" required="required" autocomplete="off">
                                </div>
                            </div>
                        </div>


                        <div class="form-group">
                            <label>Gender:</label><br>
                            <input type="radio" name="gender" value="Male" required="required">Male<br>
                            <input type="radio" name="gender" value="Female" required="required">Female<br>
                            <input type="radio" name="gender" value="Other" required="required">Other<br>
                        </div>


                        <div class="form-group">
                            <label for="exampleInputDate">D.O.B:</label>
                            <input class="form-control" id="exampleInputDate" type="date" name="dateofbirth"
                                   aria-describedby="nameHelp" placeholder="Enter date of birth" required>
                        </div>


                        <div class="form-group">
                            <label for="exampleInputEmail1">Email address:</label>
                            <input class="form-control" id="exampleInputEmail1" type="email" name="email" placeholder="Enter email" required="required" autocomplete="off">
                        </div>


                        <div class="form-group">
                            <label for="exampleInputPhone">Phone:</label>
                            <input class="form-control" id="exampleInputPhone" type="tel" name="phone" placeholder="Enter phone no." required="required" autocomplete="off">
                        </div>

                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-6">
                                    <label for="exampleInputAddress">Street Address:</label>
                                    <input class="form-control" id="exampleInputAddress" type="text" name="address"
                                           placeholder="Enter street address" maxlength="40" required>
                                </div>
                                <div class="col-md-6">
                                    Province:<select class="form-control" name="province" id="province"
                                                  onchange="setDistricts();" required>
                                    <option selected disabled>--Select Province--</option>
                                    <option value="Province 1">Province 1</option>
                                    <option value="Province 2">Province 2</option>
                                    <option value="Province 3">Province 3</option>
                                    <option value="Province 4">Province 4</option>
                                    <option value="Province 5">Province 5</option>
                                    <option value="Province 6">Province 6</option>
                                    <option value="Province 7">Province 7</option>
                                </select>
                                </div>

                                <div class="col-md-6">
                                    Zone:<select class="form-control" name="zone" id="zone" required>
                                    <option selected disabled>--Select Zone--</option>
                                    <option value="Mechi">Mechi</option>
                                    <option value="Koshi">Koshi</option>
                                    <option value="Sagarmatha">Sagarmatha</option>
                                    <option value="Janakpur">Janakpur</option>
                                    <option value="Bagmati">Bagmati</option>
                                    <option value="Narayani">Narayani</option>
                                    <option value="Gandaki">Gandaki</option>
                                    <option value="Lumbini">Lumbini</option>
                                    <option value="Dhaulagiri">Dhaulagiri</option>
                                    <option value="Rapti">Rapti</option>
                                    <option value="Karnali">Karnali</option>
                                    <option value="Bheri">Bheri</option>
                                    <option value="Seti">Seti</option>
                                    <option value="Mahakali">Mahakali</option>
                                </select>
                                </div>

                                <div class="col-md-6">
                                    District:
                                    <select class="form-control" name="district" id="district" required>
                                        <option selected disabled>--Select District--</option>

                                    </select>
                                </div>
                            </div>
                        </div>
                    </fieldset>
                    <button type="submit" class="btn btn-success">Submit</button>

                </form>
            </div>
        </div>


    </div>
</div>

<!-- Bootstrap core JavaScript-->
<%--<script src="/vendor/jquery/jquery.min.js"></script>--%>
<script
        src="https://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
<script src="/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Core plugin JavaScript-->
<script src="/vendor/jquery-easing/jquery.easing.min.js"></script>
<!-- Page level plugin JavaScript-->
<!-- Custom scripts for all pages-->
<script src="/js/sb-admin.min.js"></script>
<!-- Custom scripts for this page-->
<script src="/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="/multipagecss/js/retina-1.1.0.min.js"></script>
<script src="/multipagecss/js/jquery-1.11.1.min.js"></script>
<script src="/multipagecss/js/scripts.js"></script>

<script>
    $(document).ready(function () {

        if ('${msg}' != '') {
            alert('${msg}');
        }
    });
</script>


</body>
</html>






