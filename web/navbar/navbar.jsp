<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="../dashboard.jsp">
        <i class="fa fa-fw fa-user-md"></i> FindMyDoc</a>
    <a class="navbar-brand" href="#">
        <i class="fa fa-fw fa-user"></i>Welcome ${uname}</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
            data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">

            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Home">
                <a class="nav-link" href="../dashboard.jsp">
                    <i class="fa fa-fw fa-home"></i>
                    <span class="nav-link-text">Home</span>
                </a>
            </li>

            <c:if test="${role=='admin'}">
                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Master Entry">
                    <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseComponents"
                       data-parent="#exampleAccordion">
                        <i class="fa fa-fw fa-envelope"></i>
                        <span class="nav-link-text">Master Entry</span>
                    </a>
                    <ul class="sidenav-second-level collapse" id="collapseComponents">
                        <li>
                            <a href="/doctor/createdoc.jsp">
                                <i class="fa fa-fw fa-user-md"></i>Doctor</a>
                        </li>
                        <li>
                            <a href="/healthinstitute/createhi.jsp">
                                <i class="fa fa-fw fa-building"></i>Health Institute</a>
                        </li>
                        <li>
                            <a href="/schedule/createschedule.jsp">
                                <i class="fa fa-fw fa-book"></i>Schedule</a>
                        </li>
                    </ul>
                </li>
            </c:if>

            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="View/List">
                <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseExamplePages"
                   data-parent="#exampleAccordion">
                    <i class="fa fa-fw fa-file"></i>
                    <span class="nav-link-text">View/List</span>
                </a>
                <ul class="sidenav-second-level collapse" id="collapseExamplePages">
                    <li>
                        <a href="/doctor?page=doctorList">
                            <i class="fa fa-fw fa-user-md"></i>Doctor</a>
                    </li>
                    <li>
                        <a href="/healthinstitute?page=healthinstituteList">
                            <i class="fa fa-fw fa-building"></i>Health Institute</a>
                    </li>
                    <li>
                        <a href="/schedule?page=scheduleList">
                            <i class="fa fa-fw fa-book"></i>Schedule</a>
                    </li>
                </ul>
            </li>

            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Members">
                <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseExamplePatient"
                   data-parent="#exampleAccordion">
                    <i class="fa fa-fw fa-users"></i>
                    <span class="nav-link-text">Members</span>
                </a>
                <ul class="sidenav-second-level collapse" id="collapseExamplePatient">
                    <li>
                        <a href="/createMember?page=createMember">
                            <i class="fa fa-fw fa-user"></i>Add new Member</a>
                    </li>

                    <li>
                        <a href="/viewMember?page=viewMember">
                            <i class="fa fa-fw fa-eye"></i>View Members</a>
                    </li>


                    <c:if test="${role=='admin'}">
                        <li>
                            <a href="/viewMembers?page=viewMembers">
                                <i class="fa fa-fw fa-eye"></i>View All Members</a>
                        </li>
                    </c:if>
                </ul>
            </li>


            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Appointments">
                <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseExamplePages1"
                   data-parent="#exampleAccordion">
                    <i class="fa fa-fw fa-book"></i>
                    <span class="nav-link-text">Appointments</span>
                </a>
                <ul class="sidenav-second-level collapse" id="collapseExamplePages1">
                    <li>
                        <a href="/setAppointment?page=setAppointment">
                            <i class="fa fa-fw fa-file"></i>Make Appointment Request</a>
                    </li>

                    <li>
                        <a href="/viewAppointment?page=viewAppointment">
                            <i class="fa fa-fw fa-eye"></i>View Appointment Status</a>
                    </li>

                    <c:if test="${role=='admin'}">
                        <li>
                            <a href="/viewAppointments?page=viewAppointments">
                                <i class="fa fa-fw fa-eye"></i>View All Appointments</a>
                        </li>
                    </c:if>
                </ul>
            </li>


            <c:if test="${role=='admin'}">
                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Users">
                    <a class="nav-link" href="/user?page=userList">
                        <i class="fa fa-fw fa-users"></i>
                        <span class="nav-link-text">Users</span>
                    </a>
                </li>
            </c:if>


            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Settings">
                <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseExampleSettings"
                   data-parent="#exampleAccordion">
                    <i class="fa fa-fw fa-wrench"></i>
                    <span class="nav-link-text">Settings</span>
                </a>
                <ul class="sidenav-second-level collapse" id="collapseExampleSettings">
                    <li>
                        <a href="changepassword.jsp">
                            <i class="fa fa-fw fa-key"></i>Change Password</a>
                    </li>
                </ul>
            </li>
        </ul>

        <ul class="navbar-nav sidenav-toggler">
            <li class="nav-item">
                <a class="nav-link text-center" id="sidenavToggler">
                    <i class="fa fa-fw fa-angle-left"></i>
                </a>
            </li>
        </ul>

        <ul class="navbar-nav ml-auto">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle mr-lg-2" id="messagesDropdown" href="#" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    <i class="fa fa-fw fa-envelope"></i>
                    <span class="d-lg-none">Messages
              <span class="badge badge-pill badge-primary">N New</span>
            </span>
                    <span class="indicator text-primary d-none d-lg-block">
              <i class="fa fa-fw fa-circle"></i>
            </span>
                </a>
                <div class="dropdown-menu" aria-labelledby="messagesDropdown">
                    <h6 class="dropdown-header">New Messages:</h6>
                    <div class="dropdown-divider"></div>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle mr-lg-2" id="alertsDropdown" href="#" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    <i class="fa fa-fw fa-bell"></i>
                    <span class="d-lg-none">Alerts
              <span class="badge badge-pill badge-warning">N New</span>
            </span>
                    <span class="indicator text-warning d-none d-lg-block">
              <i class="fa fa-fw fa-circle"></i>
            </span>
                </a>
                <div class="dropdown-menu" aria-labelledby="alertsDropdown">
                    <h6 class="dropdown-header">New Alerts:</h6>
                    <div class="dropdown-divider"></div>
                </div>
            </li>

            <li class="nav-item">
                <form action="/search.jsp" class="form-inline my-2 my-lg-0 mr-lg-2" method="POST">
                    <div class="input-group">
                        <input class="form-control" type="text" name="search" placeholder="Search for...">
                        <span class="input-group-append">
                <button class="btn btn-primary" type="submit">
                  <i class="fa fa-search"></i>
                </button>
              </span>
                    </div>
                </form>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
                    <i class="fa fa-fw fa-sign-out"></i>Logout</a>
            </li>
        </ul>
    </div>
</nav>

<footer class="sticky-footer">
    <div class="container">
        <div class="text-center">
            <small>Copyright © FindMyDoc || 2018 || All Rights Reserved!!</small>
        </div>
    </div>
</footer>
<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fa fa-angle-up"></i>
</a>
<!-- Logout Modal-->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true"><i class="fa fa-fw fa-times"></i> </span>
                </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
            <div class="modal-footer">
                <button class="btn btn-danger" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="/login?page=login">Logout</a>
            </div>
        </div>
    </div>
</div>

</div>
<!-- Toggle between fixed and static navbar-->
<script src="/vendor/jquery/jquery.min.js"></script>
<script>
    $('#toggleNavPosition').click(function () {
        $('body').toggleClass('fixed-nav');
        $('nav').toggleClass('fixed-top static-top');
    });

</script>
</body>
