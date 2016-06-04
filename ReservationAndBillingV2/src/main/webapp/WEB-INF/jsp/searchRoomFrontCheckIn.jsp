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


<link rel="stylesheet"
	href='<c:url value="/assets/css/daterangepicker.css"/>'>
<!-- Custom CSS -->
<link href='<c:url value="/assets/css/sb-admin.css"/>' rel="stylesheet">

<!-- Morris Charts CSS -->
<link href='<c:url value="/assets/css/plugins/morris.css"/>'
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href='<c:url value="/assets/font-awesome/css/font-awesome.min.css"/>'
	rel="stylesheet" type="text/css">
<!-- Custom Added-->

<link rel="stylesheet"
	href='<c:url value='/assets/resources/css/font-awesome-4.0.3/css/font-awesome.css'/>' />

<link rel="stylesheet"
	href='<c:url value='/assets/resources/css/jquery-ui-1.10.4.custom.css'/>' />
	<link rel="stylesheet"
	href='<c:url value='/assets/css/datatables.min.css'/>' />

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
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html"><img src=""></a>
			</div>
			<!-- Top Menu Items -->
			<ul class="nav navbar-right top-nav">

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><i class="fa fa-user"></i> Chino
						Castillo <b class="caret"></b></a>
					<ul class="dropdown-menu">

						<li><a href="#"><i class="fa fa-fw fa-power-off"></i> Log
								Out</a></li>
					</ul></li>

				<!-- Addon rani dapita para mu sibog -->
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"></a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"></a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"></a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"></a></li>
				<!-- Addon rani dapita para mu sibog -->


			</ul>
			<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
			<%@ include file="/WEB-INF/jsp/dashboard.jsp"%>
			<!-- INCLUDE DASHBOARD -->			
			
			
			<!-- /.navbar-collapse -->
		</nav>

		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">
							<font color="#208000" face="verdana" size="5px">
								&nbsp;&nbsp;&nbsp; Manage Reservation </font>
						</h1>
						<ol class="breadcrumb">
							<li class="active"><i class="fa fa-dashboard"></i> 
								Welcome to the Administrator Panel.</li>
						</ol>
					</div>
					
				</div>

	<form:form method="POST" action="search.do" commandName="searchDate">
				<div class="form-group">
					
					<label for="endDate">Check-Out Date</label>

					<form:input path="check_out" placeholder="YYYY-MM-DD"
						class="datepicker" />
				</div>

				<div class="row">
					<div class="col-lg-12">

						<button id="send" type="submit" class="btn btn-success">Search</button>


					</div>

				</div>
			</form:form>            

					<br>
					<table class="table table-striped table-bordered" cellspacing="0" width="100%" id="example">
						<thead>
							<tr>
								<th width="4%">Room Number</th>
								<th width="12%">Room Description</th>
								<th width="12%">Rate</th>
								<th width="12%">Capacity</th>
								<th width="12%">Status</th>
								<th width="12%">Type</th>
								<th width="12%"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${roomAvailableList}" var="room" varStatus="loopCounter">
								<tr>
									<td>${room.room_no}</td>
									<td>${room.description}</td>
									<td>
									<fmt:setLocale value="en_PH" scope="session"/>
<fmt:formatNumber value="${room.rate}"
          type="currency" />
									
									</td>
									<td>${room.capacity}</td>
									<c:set var="string1" value="${room.type}" />
									<c:set var="string2"
										value="${fn:replace(string1, 
                                '_', ' ')}" />

									<td>${room.status}</td>
									<td>${string2}</td>
									<td><nobr>
											<a href="#" data-toggle="modal" data-target="#myModal${room.id }"
											 class="pure-button pure-button-primary"
											 role = "button">
     <i class="fa fa-plus"> </i>Check-in
   </a>

										
										</nobr></td>
									
								</tr>
							 <!-- Start of Modal 1 -->
  <div class="modal fade" id="myModal${room.id }" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Room ${room.room_no } (Details)</h4>
        </div>
        <div class="modal-body">
           <form:form action="${pageContext.request.contextPath}/auth/check_in/cif" commandName="preOccupancy" method="POST">
     
		  <font size="3" face="calibri" color="000000">Room Capacity:</font> &nbsp;  <font size="3" face="calibri" color="a54b0f">${room.capacity}</font><br />
		  <font size="3" face="calibri" color="000000">Room Type:</font> &nbsp;  <font size="3" face="calibri" color="a54b0f">${room.type}</font><br />
		  <font size="3" face="calibri" color="000000">Room Number</font> &nbsp;  <font size="3" face="calibri" color="a54b0f">${room.room_no}</font><br />
		  <font size="3" face="calibri" color="000000">Rate:</font> &nbsp;  <font size="3" face="calibri" color="a54b0f">${room.rate}</font><br /><br /><br />
		  
		  <font size="3" face="calibri" color="000000">Description</font> &nbsp;  <font size="3" face="calibri" color="a54b0f">${room.description}</font><br />
		 
		  
        </div>
        <div class="modal-footer">
          <form:input path="room_id" value="${room.id }" type="hidden"/>
        <form:input path="check_in" value="${dates.formatedCheck_in }" type="hidden"/>
         <form:input path="check_out" value="${dates.formatedCheck_out}" type="hidden"/>
		  <button type="submit" class="btn btn-default">Procceed Check-In</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          </form:form>
        </div>
      </div>
      
    </div>
  </div>
<!-- End of Modal 1 -->
								
							</c:forEach>
						</tbody>
					</table>
					
					

				</div>

				<!-- /.container-fluid -->
		<!-- /#wrapper -->

	
 <!-- jQuery -->
	<script src='<c:url value="/assets/js/jquery.js"/>'></script>

	<!-- Bootstrap Core JavaScript -->
	<script src='<c:url value="/assets/js/bootstrap.min.js"/>'></script>


	<script type="text/javascript"
		src='<c:url value="/assets/js/lib/jquery-1.10.2.js"/>'></script>

	<script type="text/javascript"
		src='<c:url value="/assets/js/lib/jquery-ui-1.10.4.custom.js"/>'></script>

	<script type="text/javascript"
		src='<c:url value="/assets/js/lib/jquery.ui.datepicker.js"/>'></script>

	<script type="text/javascript"
		src='<c:url value="/assets/js/js-for-guest.js"/>'></script>

	<!-- end script code for datepicker -->
	<<script type="text/javascript" src='<c:url value="/assets/js/datatables.min.js"/>'></script>
			<script>var $dt = jQuery.noConflict(true);</script>
		
	
 <script type="text/javascript"
       src='<c:url value="/assets/js/js-for-rooms.js"/>'></script>
       
		<script type="text/javascript" charset="utf-8">
			$dt(document).ready(function() {
				$dt('#example').DataTable();
			} );
		</script>
		
		
		
	
  
</body>

</html>
