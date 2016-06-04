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



   

    <!-- Custom Fonts -->
   
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
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <!-- Top Menu Items -->
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->

            </div>
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                          
                        </h1>

                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-12">
                        <div class="alert alert-info alert-dismissable">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            <i class="fa fa-danger-circle"></i> Thank you for choosing to stay with us at the Bodare Pension House. We are pleased to confirm your reservation as follows:  </font>
    
                        </div>
                    </div>
                </div>
				<br /> 
<div class="row">  
<div class="col-lg-4">
	  </div>
 </div>

			  &nbsp;&nbsp;&nbsp;
			  &nbsp;&nbsp;&nbsp;
			  &nbsp;&nbsp;&nbsp;
			  &nbsp;&nbsp;&nbsp;
<font color="eaeaea">________________________________________________________________________________________________________________________________________________</font>


				<br />
				<br />
				
 <div class="col-lg-3">
 	  </div>
 	   <div class="col-lg-9">
	  
	  
	  </div>
	 

				 <div class="col-lg-6" style="width: 900px;padding-left: 400px;height: 300px;">
                        <div class="table-responsive">
					 
                            <table class="table table-default" border="0">
                                <thead align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                
                                </thead>
								<br /><br />
                                <tbody>
                                    <tr>
                                        <td></td>
                                        <td><b>Name</b></td>
                                        <td>${rpl.ccBillingReservation.reservation.client.fullname}</td>

                                    </tr>
									<tr>
                                        <td></td>
                                        <td><b>Address</b></td>
                                        <td>${rpl.ccBillingReservation.reservation.client.address}</td>

                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td><b>Check-in Expected Date</b></td>
                                        <td>${rpl.check_in}</td>

                                    </tr>
									<tr>
                                        <td></td>
                                        <td><b>Check-out Expected Date</b></td>
                                        <td>${rpl.check_out }</td>

                                    </tr>
									<tr>
                                        <td></td>
                                        <td><b>Reference Key</b></td>
                                        <td>${rpl.ccBillingReservation.reservation.reference }</td>

                                    </tr>

                                </tbody>
                            </table>
                        </div>
						<br />
                    </div>
					
	<div class="col-lg-8">
	</div>	
	<div class="col-lg-4">
	  </div>
                </div> <br /><br /><br /><br /><br /><br />
                <!-- /.row -->
				
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<font color="eaeaea">__________________________________________________________________________________________________</font><br /><br /><br />
                
	
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->


	  

	  <!-- end script code for datepicker -->
</body>

</html>
