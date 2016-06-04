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



   <style>
   
   
   .selectit { background-color: green; }


.container .btn-group .active { background-color : red }
   
   </style>

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
                            <i class="fa fa-info-circle"></i> Welcome to the reservation area. Kindly pick a date when you wish to reserve your stay. Dont forget to check room/s you wish to stay. 
                        </div>
                    </div>
                </div>
				<br />

 <div class="col-md-4 col-md-offset-0 demo">
            <h4>Select date to reserve</h4>
            <input type="text" id="demo" class="form-control">
          </div>
			<br /> <br /> <br />
			<form:form method="POST" action="search.do" commandName="searchDate" class="form-inline">
			
		<form:input path="check_in" type="hidden"/>	
		<form:input path="check_out" type="hidden"/>			
				

				<div class="row">
					<div class="col-lg-12">
<br />
		&nbsp;&nbsp;				<button id="send" type="submit" class="btn btn-success">Check Availbility</button>


					</div>

				</div>
			</form:form>
			 
			  &nbsp;&nbsp;&nbsp;
			  &nbsp;&nbsp;&nbsp;
			  &nbsp;&nbsp;&nbsp;
			  &nbsp;&nbsp;&nbsp;
<font color="eaeaea">________________________________________________________________________________________________________________________________________________</font>


				<br />
				<br />
				
 <div class="col-lg-7">
 	  </div>
	  <div class="col-lg-5">
	  
	  </div>
	<form:form commandName="reservePreLoad" method="POST" action="test">
	
		
				 <div class="col-lg-6" style="width: 1175px;padding-left: 170px;">
                        <h3>Rooms Available</h3>
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover table-striped" >
                                <thead>
                                    <tr>
                                        <th>Room</th>
                                        <th>Rate</th>
                                        <th>Type</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${roomAvailableList}" var="room" varStatus="loopCounter">
								<tr>
									<td>${room.room_no}</td>
									
									<c:set var="string1" value="${room.type}" />
									<c:set var="string2"
										value="${fn:replace(string1, 
                                '_', ' ')}" />
                                	
									<td>
									<fmt:setLocale value="en_PH" scope="session"/>
<fmt:formatNumber value="${room.rate}"
          type="currency" />
									
									</td>
									<td>${string2}</td>
									<td>
									
									<div class="btn-group" data-toggle="buttons">
    <label class="btn btn-primary">
      <form:checkbox path="ar.room_id" value="${room.id }" class="cbox"/> Reserve
    </label>
    
  </div>
										
									</td>
									
								</tr>
			
								
							</c:forEach>
                                </tbody>
                            </table>
                        </div>
						<br />
                    </div>
					
	<div class="col-lg-8">
	</div>	
	<div class="col-lg-4">
	  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  &nbsp;&nbsp;&nbsp;&nbsp;<button id="send2" type="submit" class="btn btn-primary size-lg-12">Proceed Transaction</button>	 
	  </div>
	  	<form:input path="check_in" value="${dates.formatedCheck_in }" type="hidden"/>
	  	<form:input path="check_out" value="${dates.formatedCheck_out }" type="hidden"/>
              </form:form>  </div> <br /><br />
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


	<!-- jQuery -->
	<script type="text/javascript"
		src='<c:url value="/assets/js/jquery-1.11.3.min.js"/>'></script>

	<!-- Bootstrap Core JavaScript -->
	<script src='<c:url value="/assets/js/bootstrap.min.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/assets/js/moment.js"/>'></script>
		<script type="text/javascript"
		src='<c:url value="/assets/js/daterangepicker.js"/>'></script>

	
	

	

	<!-- end script code for datepicker -->
	
	
	<script type="text/javascript">
	  var todayDate = new Date();
	  var todayMin = new Date(todayDate.getFullYear(), todayDate.getMonth(), todayDate.getDate(), 0, 0, 0, 0);
	  var check = "${check_in}";
	  <c:set var="myVal" value="${searchDate.formatedCheck_in2}"/> 

		    <c:set var="myVa2" value="${searchDate.formatedCheck_out2}"/> 

			    var val1="${myVal}";
			    var val2="${myVa2}";
      $('#demo').daterangepicker(
    		    
    		  
    		  {
    	    "startDate": val1,
    	    "endDate": val2,
    	    "minDate": todayMin,
    	    maxDays: 7,
    		minDays: 3
    	    
    	}, 
    	
    	function(start, end, label) {
    	  console.log("New date range selected: ' + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD') + ' (predefined range: ' + label + ')");
    	  console.log("Callback has been called!");
          $('#reportrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
$('#check_in').val(start.format('YYYY-MM-DD'));
$('#check_out').val(end.format('YYYY-MM-DD'));
    	}
    	
      
      );
	
      
      

      $('.btn-group .btn').on('click',function(){
        
        var self = $(this);
        
                if ( self.find(':checkbox').length > 0 )
              {
                //alert('checkbox clicked');
                
                if ( self.hasClass('selectit' ) )
                {
                  self.removeClass('selectit');
      			self.addClass('btn-primary');
                }
      			else
                  {
                  self.addClass('selectit');
      			self.removeClass('btn-primary');

                  }              
                    
                return;
              }
        
        
        
        
                  if ( self.find(':radio').length > 0 )
              {
                //alert('radiobutton clicked');
        
        
        
      // CHANGE SELECTED ITEM TO GREEN   
           

      self.siblings("label").addBack().each(function(index, value){    
        $(this).removeClass("selectit");
          	$(this).addClass("btn-primary");
      });  
        
        
        //alert($(this).text());
      self.removeClass("btn-primary");
      self.addClass("selectit");
       
              return;
              }
                
      });
	
      
   
	</script>
	
	<script type="text/javascript">
 
$(document).ready(function() { 
 
   $('#send2').attr("disabled",true);
 
   $('.cbox').change(function() {
      $('#send2').attr('disabled', $('.cbox:checked').length == 0);
   });
 
});
 
</script>
	  

	  <!-- end script code for datepicker -->
</body>

</html>
