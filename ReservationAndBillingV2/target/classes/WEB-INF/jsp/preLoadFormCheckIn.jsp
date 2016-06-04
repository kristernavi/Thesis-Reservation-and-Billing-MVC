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

   <link rel="stylesheet"
	href='<c:url value="/assets/css/bootstrap.min.css"/>'>



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
                           <font color="#208000" face="verdana" size="5px"> &nbsp;&nbsp;&nbsp;  Check-In Form </font>
                        </h1>
                        <ol class="breadcrumb">
                            <li class="active">
                                <i class="fa fa-dashboard"></i> <font color="red">Reservation Fee will be deducted on the total payment. When cancellation, refund from reservation will no longer be given. </font>
                            </li>
                        </ol>
                    </div>
                    
                </div>
                ${message }
         
			

                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-6">
					<div class="table-responsive">
							 <!-- Part 1 -->
						<ol class="breadcrumb">
                            <li class="active"> 
	                  &nbsp;<div class="form-group">
                          <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<font color="474b43" face="Calibri" size="4px">Room Number</font></label><br />
                          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<font face="calibri" size="3px" color="000000"> ${preOccupancy.room.room_no }  </font>
                          </div><br />
						 <!-- Part 2 -->
						 <div class="form-group">
                          <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<font color="474b43" face="calibri" size="4px">Room Rate</font></label><br />
                          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<font face="calibri" size="3px" color="000000">
								
								
									<fmt:setLocale value="en_PH" scope="session"/>
<fmt:formatNumber value="${preOccupancy.room.rate}"
          type="currency" /> / Day </font>
                          </div><br />
						  <!-- Part 3 -->
						 <div class="form-group">
                          <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<font color="474b43" face="calibri" size="4px">Checked In</font></label><br />
                          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<font face="calibri" size="3px" color="000000">
								
								<fmt:formatDate type="date" 
            dateStyle="long"
            value="${preOccupancy.check_in }" />
									 </font>
                          </div><br />
						   <!-- Part 4 -->
						 <div class="form-group">
                          <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<font color="474b43" face="calibri" size="4px">Checked Out</font></label><br />
                          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<font face="calibri" size="3px" color="000000">	
								<fmt:formatDate type="date" 
            dateStyle="long"
            value="${preOccupancy.check_out }" />
								
								</font>
                          </div><br />
						   <!-- Part 5 -->
						 <div class="form-group">
                          <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<font color="474b43" face="calibri" size="4px">Number Of Days</font></label><br />
                          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<font face="calibri" size="3px" color="000000">	${preOccupancy.numberOfDays } </font>
                          </div><br />
						   <!-- Part 6 -->

						  						  <!-- Part 7 -->
						 <div class="form-group">
                          <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<font color="474b43" face="calibri" size="4px">Total Fee</font></label><br />
                          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<font face="calibri" size="3px" color="000000">	
								
<fmt:setLocale value="en_PH" scope="session"/>
<fmt:formatNumber value="${preOccupancy.totalFee}"
          type="currency" />
								
								
								 </font>
                          </div>
						  						
						  <br />
						                              </li>
                        </ol>
                    </div>
					</div>
					 <div class="col-lg-6">
					 <div class="table-responsive">
 <!-- Part 1 -->
	                  &nbsp;<div class="form-group">

						<ol class="breadcrumb">
						
                            <li class="active"> 
							<font color="eaeaea"> ________________________________________________________</font><br /><br /><br />	
                   
<%--                    <c:url var="actionUrl" value="save" /> --%>

<form:form id="guestForm" commandName="preOccupancy" class="form-horizontal" method="POST" action="${pageContext.request.contextPath}/auth/check_in/saveWalkIn">
          <fieldset>
         	 <div class="form-group">
                       
								<label class="col-sm-4 control-label">Firstname</label>
			<div class="col-sm-5">
				<form:input name="firstname" path="occ.guest.firstname"
					placeholder="Firstname" cssClass="form-control" />
			</div>

		</div>

		<div class="form-group">
			<label class="col-sm-4 control-label">Lastname</label>
			<div class="col-sm-5">
				<form:input name="lastname" path="occ.guest.lastname" placeholder="Lastname"
					cssClass="form-control" />
			</div>

		</div>
		
		<div class="form-group">
			<label class="col-sm-4	 control-label">Nationality</label>
			<div class="col-sm-6">
				<form:select path="occ.guest.nationality" cssClass="form-control">
					<form:options items="${countryList}" />
				</form:select>
			</div>

		</div>
		
		<div class="form-group">
			<label class="col-sm-4 control-label">Contact #</label>
			<div class="col-sm-5">
				<form:input name="contactNumber" path="occ.guest.contactNumber"
					placeholder="091234567" cssClass="form-control" />
			</div>

		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Email</label>
			<div class="col-sm-5">
				<form:input name="email" path="occ.guest.email"
					placeholder="example@bodare.com" cssClass="form-control" />
			</div>

		</div>

	
		<div class="form-group">
			<label class="col-sm-4 control-label">Address</label>
			<div class="col-sm-5">
				<form:input name="address" path="occ.guest.address" placeholder="Address"
					cssClass="form-control" />
			</div>

		</div>
								
																
                     
          
                           
	
	<div class="form-group">
			<label class="col-sm-4	 control-label">Payment Option</label>
			<div class="col-sm-6">
				 <select id="multiOptions" name="billing.method" class="form-control">
				  <option value="CASH">CASH</option><option value="CREDIT_CARD">CREDIT CARD</option>
				</select>

			</div>

		</div>

    <div class="form-group" id="creditcard">
        <label class="col-xs-4 control-label">Credit Card Number   </label>
<div class="col-xs-3" style="
    width: 300px;
">
<form:input path="cc.number" cssClass="form-control"/>

        </div>
    </div>

 <%-- <c:set var="now" value="" /> --%>
 
<form:hidden path="occ.from" value="${preOccupancy.formatedCheck_in }"/>
<form:input path="occ.to" type="hidden" value="${preOccupancy.formatedCheck_out }"/>
<form:input path="check_in" type="hidden" value="${preOccupancy.formatedCheck_in }" />
<form:input path="check_out" type="hidden" value="${preOccupancy.formatedCheck_out }"/>
<form:input path="room_id" type="hidden" value="${preOccupancy.room.id }"/>
<form:input path="occ.status" type="hidden" value="CHECK_IN"/>
<form:input path="occ.payable" type="hidden" values="0" />
<form:input path="payable" type="hidden" value=" ${preOccupancy.totalFee } "/>

<%-- <input type="hidden" name="${_csrf.parameterName}"
                                               value="${_csrf.token}" /> --%>

 <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;



</fieldset>

<button type="submit" id="myBtn" class="btn btn-success">Submit</button> &nbsp;&nbsp; 
<a href="${pageContext.request.contextPath}/auth/check_in/search"><button type="button" class="btn btn-danger">Cancel</button></a>                           
</form:form>


<!-- <script>
$(document).ready(function() {
    $('#integerForm').formValidation();
});
</script>
 -->

							<br />
							<font color="eaeaea"> ________________________________________________________</font>
							
							<br /><br /><br /><br /><br /><br /><br /><br />
                            </li>
                        </ol>		
                          </div><br />
						
					 </div>
					</div>
                </div>

				
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

   
			<%@ include file="/WEB-INF/jsp/includeScripts.jsp"%>
	<script type="text/javascript"
       src='<c:url value="/assets/js/js-for-reservationform.js"/>'></script>
       
       
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
    	        $('#cash').hide();
    	        $('#creditcard').show();
    	       }
    	       
    	   });
    	   });
       
       </script>

</body>

</html>
