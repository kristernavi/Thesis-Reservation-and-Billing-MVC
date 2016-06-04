<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Bodare Pension House | Dashboard</title>

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

            <!-- /.navbar-collapse -->

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                           <font color="#208000" face="verdana" size="5px"> &nbsp;&nbsp;&nbsp;  Generate Report </font>
                        </h1>
                        <ol class="breadcrumb">
                            <li class="active">
                                <i class="fa fa-dashboard"></i> Monthly Reports
                            </li>
                        </ol>
                    </div>
                </div>
                ${message }
                
         		


                <!-- /.row -->

<div class="row">



<!-- START MODAL AREA -->

    <!-- Start of Modal 1 -->
  <div class="modal fade" id="myModal1" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title"><font color="000000" size="3px">Monthly Billing Collection Report</font></h4>
        </div>
        <div class="modal-body">
		<form:form class="form-inline" commandName="search" action="pdf/collection">
<div class="form-group input-group">
<select class="form-control" id="month" name="month"style="width: 200px" >
    <option value="01">January</option>
    <option value="02">February</option>
    <option value="03">March</option>
    <option value="04">April</option>
	<option value="05">May</option>
	<option value="06">June</option>
	<option value="07">July</option>
	<option value="08">August</option>
	<option value="09">September</option>
	<option value="10">October</option>
	<option value="11">November</option>
	<option value="12">December</option>
  </select>
 
  <form:select path="year" style="width: 86px;" class="form-control">
					<form:options items="${yearList}" />
				</form:select>
<span class="input-group-btn"><button class="btn btn-success" type="submit" >Search</button></span>
</div>
		</form:form>
        </div>
        <div class="modal-footer">
		  <button type="submit" class="btn btn-default" data-dismiss="modal">Print</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        </div>
      </div>
      
    </div>
  </div>
  
  

    <!-- End of Modal 1 -->
	
	    <!-- Start of Modal 2 -->
  <div class="modal fade" id="myModal2" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title"><font color="000000" size="3px">Monthly Nationality Report</font></h4>
        </div>
        <div class="modal-body">
<form:form class="form-inline" commandName="search" action="pdf/nationality">
<div class="form-group input-group">
<select class="form-control" id="month" name="month" style="width: 200px">
    <option value="01">January</option>
    <option value="02">February</option>
    <option value="03">March</option>
    <option value="04">April</option>
	<option value="05">May</option>
	<option value="06">June</option>
	<option value="07">July</option>
	<option value="08">August</option>
	<option value="09">September</option>
	<option value="10">October</option>
	<option value="11">November</option>
	<option value="12">December</option>
  </select>
 <form:select path="year" style="width: 86px;" class="form-control">
					<form:options items="${yearList}" />
				</form:select>
<span class="input-group-btn"><button class="btn btn-primary" type="submit" >Search</button></span>
</div>
		</form:form>
        </div>
        <div class="modal-footer">
		  <button type="submit" class="btn btn-default" data-dismiss="modal">Print</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        </div>
      </div>
      
    </div>
  </div>
    <!-- End of Modal 2 -->
	
	    <!-- Start of Modal 3 -->
  <div class="modal fade" id="myModal3" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title"><font color="000000" size="3px">Monthly Occupancy Report</font></h4>
        </div>
        <div class="modal-body">

	<form:form class="form-inline" commandName="searchWithRoom" action="pdf/occupancy">
<div class="form-group input-group">
<select class="form-control" id="month" name="month" style="width: 200px">
    <option value="01">January</option>
    <option value="02">February</option>
    <option value="03">March</option>
    <option value="04">April</option>
	<option value="05">May</option>
	<option value="06">June</option>
	<option value="07">July</option>
	<option value="08">August</option>
	<option value="09">September</option>
	<option value="10">October</option>
	<option value="11">November</option>
	<option value="12">December</option>
</select>
<form:select path="year" style="width: 86px;" class="form-control">
					<form:options items="${yearList}" />
				</form:select>
 <span class="input-group-btn"><button class="btn btn-warning" type="submit">Search</button></span>
</div>

	</form:form>
        </div>
        <div class="modal-footer">
		
		  <button type="submit" class="btn btn-default" data-dismiss="modal">Print</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        </div>
      </div>
      
    </div>
  </div>
    <!-- End of Modal 3 -->

<!-- END MODAL AREA -->
<br /><br />


 <div class="col-lg-4">
 <button type="submit" class="btn btn-success btn-lg" style=" width:326px;height:164px;" data-toggle="modal" data-target="#myModal1">Billing Collection Report</button>
<br /><br /><br />                 
</div>
 <div class="col-lg-4">
  <button type="submit" class="btn btn-primary btn-lg" style="width: 326px;height: 164px;" data-toggle="modal" data-target="#myModal2">Nationality Report</button>
<br /><br /><br />                
</div>
 <div class="col-lg-4">
  <button type="submit" class="btn btn-warning btn-lg" style="width: 326px;height: 164px;" data-toggle="modal" data-target="#myModal3">Occupancy Report</button>
<br /><br /><br />                
</div>
							
 </div>

<br /><br /><br /><br /><br />			
				
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

   <%@ include file="/WEB-INF/jsp/includeScripts.jsp"%>
	<script type="text/javascript"
       src='<c:url value="/assets/js/js-for-guest.js"/>'></script>

</body>

</html>
