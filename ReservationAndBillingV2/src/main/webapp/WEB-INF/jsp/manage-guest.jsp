<%@ include file="/WEB-INF/jsp/includes.jsp"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Bodare Pension House | Dashboard</title>

<!-- Bootstrap Core CSS -->
<link rel="stylesheet"
	href='<c:url value="/assets/css/bootstrap.min.css"/>'>



<!-- Custom CSS -->
<link href='<c:url value="/assets/css/sb-admin.css"/>' rel="stylesheet">

<!-- Morris Charts CSS -->
<link href='<c:url value="/assets/css/plugins/morris.css"/>'
	rel="stylesheet">
<link rel="stylesheet"
	href='<c:url value='/assets/css/datatables.min.css'/>' />
<!-- Custom Fonts -->
<link
	href='<c:url value="/assets/font-awesome/css/font-awesome.min.css"/>'
	rel="stylesheet" type="text/css">
<!-- Custom Added-->

<link rel="stylesheet"
	href='<c:url value='/assets/resources/css/font-awesome-4.0.3/css/font-awesome.css'/>' />

<link rel="stylesheet"
	href='<c:url value='/assets/resources/css/jquery-ui-1.10.4.custom.css'/>' />


<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<style type="text/css">
th {
	text-align: left
}
</style>
</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
			<%@ include file="/WEB-INF/jsp/dashboard.jsp"%>
			<!-- INCLUDE DASHBOARD -->
			<!-- /.navbar-collapse -->

		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">
							<font color="#208000" face="verdana" size="5px">
								&nbsp;&nbsp;&nbsp; Manage Guest </font>
						</h1>
						<ol class="breadcrumb">
							<li class="active"><i class="fa fa-dashboard"></i> Hello!
								Welcome to the Administrator Panel.</li>
						</ol>
					</div>
				</div>
				${message }



				<!-- /.row -->

				<div class="row">
					<div id="guestDialog" style="display: none;">
						<%@ include file="guestForm.jsp"%>
					</div>



					<br>
					<table class="pure-table pure-table-bordered pure-table-striped" id="example">
						<thead>
							<tr>
								<th width="4%">Fullname</th>
								<th width="12%">Email</th>
								<th width="12%">Gender</th>
								<th width="12%">Nationality</th>
								<th width="12%">Address</th>
								
								<th width="12%"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${guestList}" var="guest" varStatus="loopCounter">
								<tr>
									<td>${guest.fullname}</td>
									<td>${guest.email}</td>
									<td>${guest.gender == "M" ? "Male" : "Female"}
									</td>
									<td>${guest.nationality}</td>
									<td>${guest.address}</td>
									
									<td><nobr>
											<button class="pure-button pure-button-primary"
												onclick="editGuest(${guest.id});">

												<i class="fa fa-pencil"></i> Edit
											</button>


										</nobr></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>

				<!-- /.container-fluid -->

			</div>
			<!-- /#page-wrapper -->

		</div>
		<!-- /#wrapper -->

	<%@ include file="/WEB-INF/jsp/includeScripts.jsp"%>
	<script type="text/javascript"
       src='<c:url value="/assets/js/js-for-guest.js"/>'></script>
       
       
		<script type="text/javascript" charset="utf-8">
			$dt(document).ready(function() {
				$dt('#example').DataTable();
			} );
		</script>
</body>

</html>
