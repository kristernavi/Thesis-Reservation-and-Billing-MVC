<%@ include file="/WEB-INF/jsp/includes.jsp"%>



<c:url var="actionUrl" value="saveCheckIn" />

<form:form id="guestForm" commandName="rrAndocc" method="post"
	action="${actionUrl }" class="form-horizontal">

	<fieldset>
		<legend></legend>
		<div class="form-group">
			<label class="col-sm-4 control-label">Room Number</label>
			<label class="col-sm-2 control-label">${rr.room.room_no }</label>

		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Check-in Date </label>
			<label class="col-sm-5 control-label">
			
			<fmt:formatDate type="date" 
            dateStyle="long"
            value="${rr.from}" />
			</label>
			

		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Check-out Date </label>
			<label class="col-sm-5 control-label">
			
			<fmt:formatDate type="date" 
            dateStyle="long"
            value="${rr.to}" />
			</label>
			

		</div>
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
					placeholder="Ex.0912345678" cssClass="form-control" />
			</div>

		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Email</label>
			<div class="col-sm-8">
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
		<form:input path="occ.room.id" type="hidden" value = "${rr.room.id }" />
		<form:input path="occ.to" type="hidden" value = "${rr.to }" />
		<form:input path="rr.id" type="hidden" value = "${rr.id }" />
		<form:input path="occ.from" type="hidden" value = "${rr.from }" />
		<form:input path="occ.status" type="hidden" value = "CHECK_IN" />
		<form:input path="occ.payable" type="hidden" value="0"/>
		<div class="form-group">
			<div class="col-lg-9 col-lg-offset-3">
				<button type="submit" class="btn btn-primary" name="signup"
					value="Sumbit">Save</button>
				<button type="button" class="btn btn-danger" id="cancelBtn">Cancel</button>
			</div>
		</div>
	</fieldset>
</form:form>


