<!-- Start of Modal 1 -->
  <div class="modal fade" id="logoutModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title"><font color="red">Warning</font></h4>
        </div>
        <div class="modal-body">
          <font font="calibri" size="3"> You are about to logout from the system. Are you sure you really want to logout? </font>
        </div>
        <div class="modal-footer">
		  <a href="${pageContext.request.contextPath}/auth/logout" class="btn btn-default" role="button" >Logout</a>
          <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        </div>
      </div>
      
    </div>
  </div>
<!-- End of Modal 1 -->
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

				<li ><a href="${pageContext.request.contextPath}/auth/over/" >Log-in as   <sec:authentication property="name"/>  <i class="fa fa-user"></i></b></a>
					</li>

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
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav">
				<sec:authorize access="hasAnyRole('MANAGER','FRONT_DESK')">
					<li class="${pageContext.request.requestURI == '/ReservationAndBillingV2/WEB-INF/jsp/overview.jsp' ? 'active':''}"><a href="${pageContext.request.contextPath}/auth/over/"><i class="fa fa-fw fa-dashboard"></i>
							Account Overview </a></li>
					</sec:authorize>
							<sec:authorize access="hasRole('FRONT_DESK')">
					<li class="${pageContext.request.requestURI == '/ReservationAndBillingV2/WEB-INF/jsp/manage-guest.jsp' ? 'active':''}"><a href="${pageContext.request.contextPath}/auth/guest/">&nbsp;&nbsp;&nbsp;&nbsp;
						Manage Guest</a></li>
						</sec:authorize>
						<sec:authorize access="hasRole('MANAGER')">
					<li class="${pageContext.request.requestURI == '/ReservationAndBillingV2/WEB-INF/jsp/manage-room.jsp' ? 'active':''}"><a href="${pageContext.request.contextPath}/auth/room/">&nbsp;&nbsp;&nbsp;&nbsp;
							Manage Room</a></li>
							</sec:authorize>
							<sec:authorize access="hasRole('FRONT_DESK')">
					<li class="${pageContext.request.requestURI == '/ReservationAndBillingV2/WEB-INF/jsp/manage-reservation.jsp' 
					|| pageContext.request.requestURI == '/ReservationAndBillingV2/WEB-INF/jsp/manage-reservation2.jsp' 
					|| pageContext.request.requestURI == '/ReservationAndBillingV2/WEB-INF/jsp/add-reservation.jsp'
					|| pageContext.request.requestURI == '/ReservationAndBillingV2/WEB-INF/jsp/preLoadForm4.jsp'
					?
					 'active':''}"><a href="${pageContext.request.contextPath}/auth/reserve/">&nbsp;&nbsp;&nbsp;&nbsp;
							Manage Reservation</a></li>
					<li class="${pageContext.request.requestURI == '/ReservationAndBillingV2/WEB-INF/jsp/manage-check-in.jsp'
					|| pageContext.request.requestURI == '/ReservationAndBillingV2/WEB-INF/jsp/manage-check-in2.jsp'
					 || pageContext.request.requestURI == '/ReservationAndBillingV2/WEB-INF/jsp/preLoadFormCheckIn.jsp'
					  || pageContext.request.requestURI == '/ReservationAndBillingV2/WEB-INF/jsp/searchRoomFrontCheckIn.jsp'
					 ?
					  'active':''}"><a href="${pageContext.request.contextPath}/auth/check_in/">&nbsp;&nbsp;&nbsp;&nbsp;
							Manage Check-In</a></li>
					<li class="${pageContext.request.requestURI == '/ReservationAndBillingV2/WEB-INF/jsp/manage-check-out.jsp' ? 'active':''}"><a href="${pageContext.request.contextPath}/auth/check_out/">&nbsp;&nbsp;&nbsp;&nbsp;
							Manage Check-Out</a></li>
					<li class="${pageContext.request.requestURI == '/ReservationAndBillingV2/WEB-INF/jsp/manage-addon.jsp' ? 'active':''}"><a href="${pageContext.request.contextPath}/auth/addon/">&nbsp;&nbsp;&nbsp;&nbsp;
							Manage Add On</a></li>
					<li class="${pageContext.request.requestURI == '/ReservationAndBillingV2/WEB-INF/jsp/manage-billing.jsp' ? 'active':''}"><a href="${pageContext.request.contextPath}/auth/billing/">&nbsp;&nbsp;&nbsp;&nbsp;
							Manage Billing</a></li>
							</sec:authorize>
					<sec:authorize access="hasAnyRole('MANAGER','FRONT_DESK')">				
					<li class="${pageContext.request.requestURI == '/ReservationAndBillingV2/WEB-INF/jsp/generateReport.jsp' ? 'active':''}"><a href="${pageContext.request.contextPath}/auth/report/">&nbsp;&nbsp;&nbsp;&nbsp;
							Generate Reports</a></li>
					<li>
					 <div class="clearfix"></div>
                        <a href="#" data-toggle="modal" data-target="#logoutModal">&nbsp;&nbsp;&nbsp;&nbsp; Logout</a>
                    </li>
                    </sec:authorize>

				</ul>
			</div>
			</nav>