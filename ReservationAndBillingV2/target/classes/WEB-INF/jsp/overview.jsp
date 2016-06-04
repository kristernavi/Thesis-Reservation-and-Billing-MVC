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
        <%@ include file="/WEB-INF/jsp/dashboard.jsp"%>
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                           <font color="#208000" face="verdana" size="5px"> &nbsp;&nbsp;&nbsp;  Account Overview </font>
                        </h1>
                        <ol class="breadcrumb">
                            <li class="active">
                                <i class="fa fa-dashboard"></i> Hello! Welcome to the Administrator Panel.
                            </li>
                        </ol>
                    </div>
                </div>
         


                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-6">
					<div class="table-responsive">
							<form role="form">
							 <!-- Part 1 -->
						<ol class="breadcrumb">
                            <li class="active"> 
	                  &nbsp;<div class="form-group">
						  <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<font color="376b09" face="calibri" size="6px"><b><strong>Profile</strong></b></font></label>
									<br /><br /><br />
                          <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<font color="474b43" face="Calibri" size="4px">Username</font></label><br />
                          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<font face="calibri" size="3px" color="000000">	${currentUser.username } </font>
                          </div><br />
						 <!-- Part 2 -->
						 <div class="form-group">
                          <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<font color="474b43" face="calibri" size="4px">Email Address</font></label><br />
                          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<font face="calibri" size="3px" color="000000">	${currentUser.email } </font>
                          </div><br />
						
						   <!-- Part 4 -->
						
						   <!-- Part 5 -->
						 <div class="form-group">
                          <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<font color="474b43" face="calibri" size="4px">Name</font></label><br />
                          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<font face="calibri" size="3px" color="000000">${currentUser.fullname }</font>
                          </div><br />
						   <!-- Part 6 -->

						  						  <!-- Part 7 -->
						 <div class="form-group">
                          <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<font color="474b43" face="calibri" size="4px">Account Type</font></label><br />
                          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<font face="calibri" size="3px" color="000000">	<sec:authentication property="authorities"/> </font>
                          </div>
						  <br />
						                              </li>
                        </ol>
                    </div>
					</div>
					 <div class="col-lg-6">
					 <div class="table-responsive">
					 							<form role="form">
<!-- Part 1 -->
	                  &nbsp;<div class="form-group">

									<br /><br /><br />

						<ol class="breadcrumb">
						
                            <li class="active"> 
						
							<br /><br />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="
							<c:url value="/assets/images/Check.png"/>
							" width="100" height="90">&nbsp;&nbsp;&nbsp;
							<font face="calibri" size="3px" color="376b09">	Reminders </font> 
							<font color="eaeaea"> ________________________________________________________</font><br /><br /><br />	
							<font color="000000"> Be sure to always logout your account whenever you are not using<br />
												  to avoid issues and problems that will occur in the system.
							</font>
							
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

    <!-- jQuery -->
    
    
    <%@ include file="/WEB-INF/jsp/includeScripts.jsp"%>


</body>

</html>
