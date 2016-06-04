<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Bodare Pension House</title>  
	<link rel="stylesheet"
	href='<c:url value="/assets/css/bootstrap.min.css"/>'>

<link rel="stylesheet"
	href='<c:url value="/assets/css/daterangepicker.css"/>'>

<!-- Custom CSS -->
<link href='<c:url value="/assets/css/sb-admin.css"/>' rel="stylesheet">

<!-- Morris Charts CSS -->
<link href='<c:url value="/assets/css/plugins/morris.css"/>'
	rel="stylesheet">




    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

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
                           <font color="#208000" face="verdana" size="5px"> &nbsp;&nbsp;&nbsp;  Reservation Form </font>
                        </h1>
                        <ol class="breadcrumb">
                            <li class="active">
                                <i class="fa fa-dashboard"></i> <font color="red">Full Payment is require to confirm the reservation. When cancellation, refund from reservation will no longer be given. </font>
                            </li>
                        </ol>
                    </div>
                </div>
                		${message }

<form:form id="clientForm" commandName="rpl"
						action="proccesReservation" class="form-horizontal" method="POST">
						
			<div class="row">
				<div class="col-lg-6">
					<div class="table-responsive">
							<!-- Part 1 -->
							<ol class="breadcrumb">
								<li class="active"><br />
								<br />

									<div class="form-group">
										<label class="col-xs-3 control-label">Firstname </label>
										<div class="col-xs-3" style="width: 300px;">
											<form:input
												path="ccBillingReservation.reservation.client.firstname"
												cssClass="form-control" />
											<br />
										</div>
									</div>
									<div class="form-group">
										<label class="col-xs-3 control-label">Lastname </label>
										<div class="col-xs-3" style="width: 300px;">
											<form:input
												path="ccBillingReservation.reservation.client.lastname"
												cssClass="form-control" />
											<br />
										</div>
									</div>

									<div class="form-group">
										<label class="col-xs-3 control-label">Contact Number </label>
										<div class="col-xs-3" style="width: 300px;">
											<form:input
												path="ccBillingReservation.reservation.client.contactNumber"
												cssClass="form-control" />
											<br />
										</div>
									</div>
									<div class="form-group">
										<label class="col-xs-3 control-label">Address </label>
										<div class="col-xs-3" style="width: 300px;">
											<form:input
												path="ccBillingReservation.reservation.client.address"
												cssClass="form-control" />
											<br />
										</div>
									</div> <%-- 						<div class="form-group" style="width:350px;">
                             &nbsp;&nbsp;   <label>Email</label> &nbsp;&nbsp;&nbsp;&nbsp;
                                 <form:input path="" cssClass="form-control" style="width: 280.22222px;"/>
                            </div> --%>

									<div class="form-group">
										<label  class="col-xs-3 control-label">Gender</label>
										&nbsp;&nbsp;&nbsp;&nbsp;
										<div class="col-sm-5">
											<select id="creservation.client.sex"
												name="ccBilling.billing.reserve.guest.gender"
												class="form-control">
												<option value="M">Male</option>
												<option value="F">Female</option>
											</select>
										</div>

									</div> <!-- Part 6 --> <!-- Part 7 --> <br /></li>
							</ol>
					</div>
				</div>
				<div class="col-lg-6">
					<div >
						<!-- Part 1 -->
						&nbsp;
						<div class="form-group">

							<ol class="breadcrumb">

								<li class="active"><font color="eaeaea">
										________________________________________________________</font><br />
								<br />
								<br />



									<div class="form-group">
										<label class="col-xs-4 control-label">Number of Room/s
											Reserve </label>
										<div class="col-xs-3" style="width: 300px;">
											<p>${counter }</p>
										</div>
										<br />
									</div>
									<div class="form-group">
										<label class="col-xs-4 control-label">Number of Days </label>
										<div class="col-xs-3" style="width: 300px;">
											<p>${rpl.numberOfDays }</p>
										</div>
										<br />
									</div>
									<div class="form-group">
										<label class="col-xs-4 control-label">Room Total Fee</label>
										<div class="col-xs-3" style="width: 300px;">
											<p>
												<fmt:setLocale value="en_PH" scope="session" />
												<fmt:formatNumber value="${payable}" type="currency" />

											</p>
											<p></p>
											<br />
										</div>
										<br />
									</div>

<div class="form-group" >
			<label class="col-sm-4	 control-label">Payment Option</label>
			<div class="col-sm-4">
				 <select id="multiOptions" name="ccBillingReservation.billing.method" class="form-control">
				  <option value="CASH">CASH</option><option value="CREDIT_CARD">CREDIT CARD</option>
				</select>

			</div>

		</div>

									<div class="form-group" id="creditcard">
										<label class="col-xs-4 control-label">Credit Card
											Number </label>
										<div class="col-xs-3" style="width: 300px;">
											<form:input path="ccBillingReservation.cc.number"
												cssClass="form-control" />

											<br />
										</div>
									</div>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;


									&nbsp;&nbsp; <form:input path="ccBillingReservation.amount_pay"
										value="${payable }" type="hidden" /> <form:input
										path="payable" value="${payable }" type="hidden" /> <form:input
										path="ar.room_id" values="${test }" type="hidden" /> <form:input
										path="check_in" value="${rpl.formatedCheck_in }" type="hidden" />
									<form:input path="check_out" value="${rpl.formatedCheck_out }"
										type="hidden" /> <form:input path="counter"
										value="${counter }" type="hidden" />

									<button type="submit" class="btn btn-primary" name="save" id="myBtn"
										value="Sumbit">Save</button>
									<a href="#" data-toggle="modal" data-target="#cancelModal"
											class="btn btn-danger"
											 role = "button">
     <i class="fa fa-plus"> </i>Cancel
   </a>
	
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;




									<br /> <font color="eaeaea">
										________________________________________________________</font> <br />
							
								<br /></li>
							</ol>
						</div>
						</div>
						</div>
						</div>
														</form:form>
              <br/>
					</div>
                </div>

				
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    <!-- /#wrapper -->

<%@ include file="/WEB-INF/jsp/includeScripts.jsp"%>
 <script type="text/javascript"
       src='<c:url value="/assets/js/js-for-client.js"/>'></script>
       <script type="text/javascript">
       function myFunction() {
    	    document.getElementById("myBtn").disabled = false;
    	}
       function myFunction2() {
   	    document.getElementById("myBtn").disabled = true;
   	}
       $(document).ready(function () {
	          $('#creditcard').hide();
    	   $("#multiOptions").change(function () {
    	       if ($(this).val() == "CASH" ) {
    	    	   myFunction();
    	    	   $('#creditcard').hide();
    	       }
    	    else if ($(this).val() == "CREDIT_CARD") {
    	        $('#creditcard').show();
    	       }
    	       
    	   });
    	   });
       
       </script>
	
</body>

</html>
