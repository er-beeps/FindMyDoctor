<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Display list || Health Institute </title>
    <!-- Bootstrap core CSS-->
    <link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom fonts for this template-->
    <link href="/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <!-- Page level plugin CSS-->
    <link href="/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="/CSS/sb-admin.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/navbar/navbar.jsp"/>
<div class="content-wrapper">
    <div class="container-fluid">
        <!-- Breadcrumbs-->
        <ol class="breadcrumb">
            <li class="breadcrumb-item">
                <a href="/dashboard.jsp">Dashboard</a>
            </li>
            <li class="breadcrumb-item active">View/List</li>
        </ol>
        <!-- Example DataTables Card-->
        <div class="card mb-3">
            <div class="card-header">
                <i class="fa fa-table"></i> List of Health Institute
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="1">
                        <thead>
                        <tr>
                            <th>Health Institute ID</th>
                            <th>Health Institute Name</th>
                            <th>Health Institute Type</th>
                            <th>Address</th>
                            <th>Phone</th>
                            <c:if test="${role=='admin'}">
                                <th>Edit</th>
                                <th>Delete</th>
                            </c:if>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${hlist}" var="i">
                            <tr>
                                <td>${i.hid}</td>
                                <td>${i.name}</td>
                                <td>${i.type}</td>
                                <td>${i.address}</td>
                                <td>${i.phone} </td>
                                <c:if test="${role=='admin'}">
                                    <td><a href="/editHealthinstitute?page=editHealthinstitute&&id=${i.id}"><i class="fa fa-fw fa-edit"></i></a></td>
                                    <td><a href="/deleteHealthinstitute?page=deleteHealthinstitute&&id=${i.id}"
                                           onclick="return confirm('Are you Sure?')"><i class="fa fa-fw fa-trash-o"></i></a></td>
                                </c:if>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
            <div class="card-footer small text-muted">Updated today !!</div>
        </div>
    </div>
</div>

    <!-- Bootstrap core JavaScript-->
    <script src="/vendor/jquery/jquery.min.js"></script>
    <script src="/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="/vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Page level plugin JavaScript-->
    <script src="/vendor/datatables/jquery.dataTables.js"></script>
    <script src="/vendor/datatables/dataTables.bootstrap4.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="/js/sb-admin.min.js"></script>
    <!-- Custom scripts for this page-->
    <script src="/js/sb-admin-datatables.min.js"></script>

</body>
</html>
