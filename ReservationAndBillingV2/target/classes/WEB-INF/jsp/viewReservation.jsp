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

	<div id="page-wrapper">

			


			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">
							<font color="#208000" face="verdana" size="5px">
								&nbsp;&nbsp;&nbsp; Mr./Mrs. ${reserveList.client.fullname } </font>
						</h1>
						<ol class="breadcrumb">
							<li class="active"><i class="fa fa-dashboard"></i> Hello!
								Welcome to the Manage Reservation.</li>
						</ol>
					</div>
				</div>
				${message }



				<!-- /.row -->

				<div class="row">
								<div id="changeRoomDialog" style="display: none;">
								<%@ include file="changeDateForm2.jsp"%>
					</div>
					<div id="changeRoomDialog2" style="display: none;">
					</div>

<br />
					


					
					<br>
					<table class="pure-table pure-table-bordered pure-table-striped" id="example">
						<thead>
							<tr>
								<th width="4%">#</th>
								<th width="5%">Room #</th>
								<th width="12%">Room Type</th>
								<th width="12%">Capacity</th>								
								<th width="12%">Check-In Date</th>
								<th width="20%">Check-Out Date</th>
								
								
								<th width="12%"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${rrList}" var="rr" varStatus="loopCounter">
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
												onclick="check_inForm2('${rr.formatedCheck_in}','${rr.formatedCheck_out}',${rr.id},'${rr.room.rate}','${reserveList.reference}');">

												<i class="fa fa-pencil"></i> Change Room
											</button>
									
									</nobr>
									
									
									</td>
								</tr>
								
							</c:forEach>
						</tbody>
					</table>
					<button class="pure-button pure-button-primary" onclick="changeDate()">
						<i class="fa fa-plus"></i> Change Date
					</button>
						<a href="#" data-toggle="modal" data-target="#cancelModal"
											class="btn btn-danger"
											 role = "button">
     <i class="fa fa-times"> </i>Cancel
   </a>
   	<a href="#" data-toggle="modal" data-target="#backModal"
											class="btn btn-danger"
											 role = "button">
     <i class="fa fa-pencil"> </i>Back to Home
   </a>

<!-- Start of Modal 1 -->
  <div class="modal fade" id="cancelModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title"><font color="red">Warning</font></h4>
        </div>
        <div class="modal-body">
          <font font="calibri" size="3"> You are sure you want to cancel this reservation?<br/>
          This reservation will no longer appear if you click confirm button.
           </font>
        </div>
        <div class="modal-footer">
		  <a href="${pageContext.request.contextPath}/delete/${reserveList.id}" class="btn btn-default" role="button" >Confirm</a>
          <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        </div>
      </div>
      
    </div>
  </div>
<!-- End of Modal 1 -->
<!-- Start of Modal 1 -->
  <div class="modal fade" id="backModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title"><font color="red">Warning</font></h4>
        </div>
        <div class="modal-body">
          <font font="calibri" size="3"> You are sure you want to go back home? </font>
        </div>
        <div class="modal-footer">
		  <a href="${pageContext.request.contextPath}/" class="btn btn-default" role="button" >Confirm</a>
          <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        </div>
      </div>
      
    </div>
  </div>
<!-- End of Modal 1 -->
				</div>

				<!-- /.container-fluid -->

			</div>
			<!-- /#page-wrapper -->

		<!-- /#wrapper -->
 <%@ include file="/WEB-INF/jsp/includeScripts.jsp"%>
 <script type="text/javascript"
		src='<c:url value="/assets/js/jquery-1.11.3.min.js"/>'></script>

	<!-- Bootstrap Core JavaScript -->
	<script src='<c:url value="/assets/js/bootstrap.min.js"/>'></script>
	<script type="text/javascript"
		src='<c:url value="/assets/js/moment.js"/>'></script>
		<script type="text/javascript"
		src='<c:url value="/assets/js/daterangepicker.js"/>'></script>
		<script>var $drp = jQuery.noConflict(true);</script>
 <script type="text/javascript"
       src='<c:url value="/assets/js/js-for-changeroom.js"/>'></script>
       
		<script type="text/javascript" charset="utf-8">
			$dt(document).ready(function() {
				$dt('#example').DataTable();
			} );
		</script>
		
		
		
	<script type="text/javascript">
	  var todayDate = new Date();
	  var todayMin = new Date(todayDate.getFullYear(), todayDate.getMonth(), todayDate.getDate(), 0, 0, 0, 0);
	  var check = "${check_in}";
	  <c:set var="myVal" value="${searchDate.formatedCheck_in2}"/> 

		    <c:set var="myVa2" value="${searchDate.formatedCheck_out2}"/> 

			    var val1="${rrList[0].formatedCheck_in2 }";
			    var val2="${rrList[0].formatedCheck_out2 }";
      $drp('#demo').daterangepicker(
    		    
    		  
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
          $drp('#reportrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
$drp('#editFrom').val(start.format('YYYY-MM-DD'));
$drp('#editTo').val(end.format('YYYY-MM-DD'));
    	}
    	
      
      );
	
	
	</script>
		
</body>

</html>
