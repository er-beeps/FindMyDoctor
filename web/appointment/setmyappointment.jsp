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
    <title>Set appointment</title>
    <!-- Bootstrap core CSS-->
    <link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom fonts for this template-->
    <link href="/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="/CSS/sb-admin.css" rel="stylesheet">

    <link rel="stylesheet" href="/multipagecss/css/style.css">
    <link rel="stylesheet" href="/multipagecss/css/form-elements.css">

    </head>

<body>
<jsp:include page="/navbar/navbar.jsp"/>
<div class="content-wrapper">
    <div class="container-fluid">
        <ol class="breadcrumb">
            <li class="breadcrumb-item">
                <a href="/dashboard.jsp">Dashboard</a>
            </li>
            <li class="breadcrumb-item active">Make an appointment...</li>
        </ol>
        <div class="card  mx-auto mt-3 bg-light" style="width:70%;">
            <div class="card-header">
                <i class="fa fa-fw fa-pencil"> </i> Fill the following details and submit to make an appointment !!
            </div>
            <div class="card-body">
                <form role="form" action="/appointment" method="POST" class="f1">
                    <input type="hidden" name="page" value="setmyAppointment"/>
                    <input type="hidden" name="uname" value="${uname}">
                    <input type="hidden" name="selecthealthinstitute" value="${s.hiName}">
                    <input type="hidden" name="selectdoctor" value="${s.docName}">
                    <input type="hidden" name="preferred_time" value="${s.startTime}">
                    <input type="hidden" name="id" value="${ml.id}">

                    <div class="form-group">
                        <div class="col-md-6">
                            <label>Member</label>
                            <select class="custom-select" name="member" id="member" onchange="getMember()">
                                <option selected disabled>--Select Member--</option>
                                <c:forEach items="${mylist}" var="ml">
                                    <option value="${ml.id}">${ml.firstName} ${ml.lastName} </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>


                    <div class="f1-steps">
                        <div class="f1-progress">
                            <div class="f1-progress-line" data-now-value="0" data-number-of-steps="1"
                                 style="width: 0%;"></div>
                        </div>
                        <div class="f1-step active">
                            <div class="f1-step-icon"><i class="fa fa-fw fa-user"></i></div>
                            <p>Personal Information</p>
                        </div>
                        <div class="f1-step">
                            <div class="f1-step-icon"><i class="fa fa-fw fa-hospital-o"></i></div>
                            <p>Department and Doctor</p>
                        </div>
                    </div>

                    <fieldset>
                        <h3>Personal Information:</h3><br>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-6">
                                    <label for="firstName">First name:</label>
                                    <input class="form-control" id="firstName" type="text" name="firstname" >
                                </div>

                                <div class="col-md-6">
                                    <label for="lastName">Last name:</label>
                                    <input class="form-control" id="lastName" type="text"
                                           name="lastname">
                                </div>
                            </div>
                        </div>

                        <div id="selectgender">
                        <div class="form-group">
                            <label>Gender:</label><br>
                            <input type="radio" name="gender" value="Male" >Male<br>
                            <input type="radio" name="gender" value="Female" >Female<br>
                            <input type="radio" name="gender" value="Other" >Other<br>
                        </div>
                        </div>

                        <div class="form-group">
                            <label for="dob">D.O.B:</label>
                            <input class="form-control" id="dob" type="date" name="dateofbirth"
                                   aria-describedby="nameHelp"  required>
                        </div>


                        <div class="form-group">
                            <label for="email">Email address:</label>
                            <input class="form-control" id="email" type="email" name="email">
                        </div>


                        <div class="form-group">
                            <label for="phone">Phone:</label>
                            <input class="form-control" id="phone" type="tel" name="phone" >
                        </div>

                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-6">
                                    <label for="address">Street Address:</label>
                                    <input class="form-control" id="address" type="text" name="address"
                                           maxlength="40" required>
                                </div>
                                <div class="col-md-6">
                                    State:<select class="form-control" name="province" id="province" required>
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
                                        <option value="Taplejung">Taplejung</option>
                                        <option value="Sankhuwasabha">Sankhuwasabha</option>
                                        <option value="Solukhumbu">Solukhumbu</option>
                                        <option value="Okhaldhunga">Okhaldhunga</option>
                                        <option value="Khotang">Khotang</option>
                                        <option value="Bhojpur">Bhojpur</option>
                                        <option value="Dhankuta">Dhankuta</option>
                                        <option value="Terhathum">Terhathum</option>
                                        <option value="Panchthar">Panchthar</option>
                                        <option value="Ilam">Ilam</option>
                                        <option value="Jhapa">Jhapa</option>
                                        <option value="Morang">Morang</option>
                                        <option value="Sunsari">Sunsari</option>
                                        <option value="Udayapur">Udayapur</option>
                                        <option value="Saptari">Saptari</option>
                                        <option value="Siraha">Siraha</option>
                                        <option value="Dhanusa">Dhanusa</option>
                                        <option value="Mahottari">Mahottari</option>
                                        <option value="Sarlahi">Sarlahi</option>
                                        <option value="Rautahat ">Rautahat</option>
                                        <option value="Bara">Bara</option>
                                        <option value="Parsa">Parsa</option>
                                        <option value="Dolakha">Dolakha</option>
                                        <option value="Sindhupalchok">Sindhupalchok</option>
                                        <option value="Rasuwa">Rasuwa</option>
                                        <option value="Dhading">Dhading</option>
                                        <option value="Nuwakot">Nuwakot</option>
                                        <option value="Kathmandu">Kathmandu</option>
                                        <option value="Bhaktapur">Bhaktapur</option>
                                        <option value="Lalitpur">Lalitpur</option>
                                        <option value="Kavrepalanchok">Kavrepalanchok</option>
                                        <option value="Ramechhap">Ramechhap</option>
                                        <option value="Sindhuli">Sindhuli</option>
                                        <option value="Makwanpur">Makwanpur</option>
                                        <option value="Chitwan">Chitwan</option>
                                        <option value="Gorkha">Gorkha</option>
                                        <option value="Manang">Manang</option>
                                        <option value="Mustang">Mustang</option>
                                        <option value="Myagdi">Myagdi</option>
                                        <option value="Kaski">Kaski</option>
                                        <option value="Lamjung">Lamjung</option>
                                        <option value="Tanahu">Tanahu</option>
                                        <option value="Nawalparasi East">Nawalparasi East</option>
                                        <option value="Syangja">Syangja</option>
                                        <option value="Parbat">Parbat</option>
                                        <option value="Baglung">Baglung</option>
                                        <option value="Rukum East">Rukum East</option>
                                        <option value="Rolpa">Rolpa</option>
                                        <option value="Pyuthan">Pyuthan</option>
                                        <option value="Gulmi">Gulmi</option>
                                        <option value="Arghakhanchi">Arghakhanchi</option>
                                        <option value="Palpa">Palpa</option>
                                        <option value="Nawalparasi West">Nawalparasi West</option>
                                        <option value="Rupandehi">Rupandehi</option>
                                        <option value="Kapilvastu">Kapilvastu</option>
                                        <option value="Dang ">Dang </option>
                                        <option value="Banke">Banke</option>
                                        <option value="Bardiya">Bardiya</option>
                                        <option value="Dolpa">Dolpa</option>
                                        <option value="Mugu">Mugu</option>
                                        <option value="Humla">Humla</option>
                                        <option value="Jumla">Jumla</option>
                                        <option value="Kalikot">Kalikot</option>
                                        <option value="Dailekh">Dailekh</option>
                                        <option value="Jajarkot">Jajarkot</option>
                                        <option value="Rukum West">Rukum West</option>
                                        <option value="Salyan">Salyan</option>
                                        <option value="Surkhet">Surkhet</option>
                                        <option value="Bajura">Bajura</option>
                                        <option value="Bajhang">Bajhang</option>
                                        <option value="Darchula">Darchula</option>
                                        <option value="Baitadi">Baitadi</option>
                                        <option value="Dadeldhura">Dadeldhura</option>
                                        <option value="Doti">Doti</option>
                                        <option value="Achham">Achham</option>
                                        <option value="Kailali">Kailali</option>
                                        <option value="Kanchanpur">Kanchanpur</option>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="f1-buttons">
                            <button type="button" class="btn btn-next">Next</button>
                        </div>
                    </fieldset>


                    <fieldset>
                        <h3> Department and Doctor Information:</h3><br>

                                <div class="form-group">
                                    <label>Select Healthinstitute:</label>
                                    <input class="form-control"  type="text" name="selecthealthinstitute" value="${s.hiName}" required="required" disabled>
                                </div>

                            <div class="form-group">
                            <label>Department:</label>
                            <select class="form-control" name="department" required>
                                <option selected disabled>--Select Department--</option>
                                <option>Anesthesiology</option>
                                <option>Laboratory Services</option>
                                <option>Cardiothoracic &amp; Vascular Surgery</option>
                                <option>General Surgery, Digestive Diseases and Laparoscopic Surgery</option>
                                <option>Urology &amp; Kidney Transplant Surgery</option>
                                <option>ENT &amp; Head Neck Surgery</option>
                                <option>Department of Neuro Sciences</option>
                                <option>Orthopedics &amp; Traumatology</option>
                                <option>Radiology &amp; Interventions</option>
                                <option>Emergency Medicine &amp; EMS</option>
                                <option>Pediatrics &amp; Neonatology</option>
                                <option>Neonatal Critical Care</option>
                                <option>Nephrology &amp; Transplant Medicine</option>
                                <option>Psychiatry</option>
                                <option>Dentistry &amp; Dental Surgery</option>
                                <option>Dermatovenerology &amp; Cosmetic Dermatology</option>
                                <option>Ophthalmology &amp; Vision Sciences</option>
                                <option>Obstetrics &amp; Gynecology</option>
                                <option>Oncology</option>
                                <option>Wellness &amp; Family Medicine</option>
                                <option>Internal Medicine</option>
                                <option>Cardiology &amp; Cardiac Surgery</option>
                                <option>Gastroenterology &amp; Hepatology</option>
                                <option>Endocrinology and Diabetology</option>
                                <option>Pulmonary Medicine</option>
                                <option>Infectious Diseases</option>
                                <option>Physical Therapy and Rehabilitation</option>
                                <option>Plastic, Reconstructive &amp; Cosmetic Surgery</option>
                                <option>Critical Care Medicine</option>
                                <option>Geriatric Medicine</option>
                                <option>Transfusion Medicine and Blood Bank</option>
                                <option>Neonatal &amp; Pediatric Surgery</option>
                            </select>
                        </div>


                        <div class="form-group">
                            <label>Appointment Type:</label>
                            <select class="form-control" name="atype" required>
                                <option selected disabled>--Select appointment type--</option>
                                <option> Routine checkup</option>
                                <option> Sick visit</option>
                                <option> Mental Health and Counseling</option>
                                <option> Vaccinations</option>
                                <option> Travel clinic</option>
                                <option> Eyecare</option>
                                <option> Dental</option>
                                <option> Other medical specialties, including radiology</option>
                                <option> I am not sure what kind of appointment I need</option>
                            </select>
                        </div>


                            <div class="form-group">
                                <label for="exampleInputDocName">Select Doctor:</label>
                                <input class="form-control" id="exampleInputDocName" type="text" name="selectdoctor" value="${s.docName}" required="required" disabled>
                            </div>

                        <div class="form-group">
                            <label for="pda">Preferred date for appointment</label>
                            <input class="form-control" id="pda" type="date" name="preferred_date"
                                   aria-describedby="nameHelp"  required>
                        </div>

                        <div class="form-group">
                            <label> Preferred Time</label>
                            <input class="form-control" type="time" name="preferred_time" value="${s.startTime}" required="required"
                                   autocomplete="off">
                        </div>


                        <div class="form-group">
                            Description:<br>
                            <textarea rows="5" cols="70" name="description"
                                      placeholder="Describe the symptoms in few lines..." required></textarea>
                        </div>

                        <div class="f1-buttons">
                            <button type="button" class="btn btn-previous">Previous</button>
                            <button type="submit" class="btn btn-success">Submit</button>

                        </div>
                    </fieldset>
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

    function getMember() {
        var name = $('#member').val();
        $.ajax({
            url: "/getMember",
            type: "get",
            data: {page: "getMember", val: name},
            success: function (result) {
                console.log(result);
                $('#firstName').val(result.fname);
                $('#lastName').val(result.lname);
                $('#gender').val(result.gender);
                $('#dob').val(result.dob);
                $('#email').val(result.email);
                $('#phone').val(result.phone);
                $('#address').val(result.address);
                $('#province').val(result.province)
                $('#zone').val(result.zone);
                $('#district').val(result.district);

                if (result.gender == 'Male'){
                    $('#selectgender').find(':radio[name=gender][value="Male"]').prop('checked', true)
                } else{
                    $('#selectgender').find(':radio[name=gender][value="Female"]').prop('checked', true)
                }
            },
            error: function (result) {
                console.log("error");
            }
    });
    }

</script>


</body>
</html>






