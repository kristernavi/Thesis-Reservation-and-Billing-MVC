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
								&nbsp;&nbsp;&nbsp; Manage Check-In </font>
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
								<div id="checkinDialog" style="display: none;">
						<%@ include file="check-inFormWithReservation.jsp"%>
					</div>

<br />
					


					
					<br>
					<table class="pure-table pure-table-bordered pure-table-striped" id="example">
						<thead>
							<tr>
								<th width="4%">#</th>
								<th width="12%">Room Number</th>
								<th width="12%">Room Type</th>
								<th width="12%">Capacity</th>								
								<th width="12%">Check-In Date</th>
								<th width="12%">Check-Out Date</th>
								
								
								<th width="12%"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${viewReservation}" var="rr" varStatus="loopCounter">
								<tr>
									<td>${loopCounter.count}</td>
									<td>${rr.room.room_no}</td>
									<td>${rr.room.type}</td>
									<td>${rr.room.capacity}</td>
									<td>
									<fmt:formatDate type="date" 
            dateStyle="long"
            value="${rr.from}" />
									</td>
									<td>
									<fmt:formatDate type="date" 
            dateStyle="long"
            value="${rr.to}" />
									</td>
									
									
									<td>
									<nobr>
									<button class="pure-button pure-button-primary"
												onclick="check_inForm(${rr.id});">

												<i class="fa fa-pencil"></i> Check-In
											</button>
									</nobr>
									
									
									</td>
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
       src='<c:url value="/assets/js/js-for-rr.js"/>'></script>
		<script type="text/javascript" charset="utf-8">
			$dt(document).ready(function() {
				$dt('#example').DataTable();
			} );
		</script>
</body>

</html>
