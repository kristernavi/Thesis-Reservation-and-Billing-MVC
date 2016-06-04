<%@ include file="/WEB-INF/jsp/includes.jsp"%>



<c:url var="actionUrl" value="save" />

<form:form id="guestForm" commandName="guest" method="post"
	action="${actionUrl }" class="form-horizontal">

	<fieldset>
		<legend></legend>
		<div class="form-group">
			<label class="col-sm-4 control-label">Firstname</label>
			<div class="col-sm-5">
				<form:input name="firstname" path="firstname"
					placeholder="Firstname" cssClass="form-control" />
			</div>

		</div>

		<div class="form-group">
			<label class="col-sm-4 control-label">Lastname</label>
			<div class="col-sm-5">
				<form:input name="lastname" path="lastname" placeholder="Lastname"
					cssClass="form-control" />
			</div>

		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Contact #</label>
			<div class="col-sm-5">
				<form:input name="contactNumber" path="contactNumber"
					placeholder="091234567" cssClass="form-control" />
			</div>

		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Email</label>
			<div class="col-sm-5">
				<form:input name="email" path="email"
					placeholder="example@bodare.com" cssClass="form-control" />
			</div>

		</div>

		<div class="form-group">
			<label class="col-sm-4	 control-label">Gender</label>
												<div class="col-sm-6">

			<select id="gender"
												name="gender"
												class="form-control">
												<option value="M">Male</option>
												<option value="F">Female</option>
												
											</select>
											</div>
		</div>
			<div class="form-group">
			<label class="col-sm-4	 control-label">Nationality</label>
			<div class="col-sm-6">
				<form:select path="nationality" cssClass="form-control">
					<form:options items="${countryList}" />
				</form:select>
			</div>

		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Address</label>
			<div class="col-sm-5">
				<form:input name="address" path="address" placeholder="Address"
					cssClass="form-control" />
			</div>

		</div>
		<form:input path="id" type="hidden" />
		<div class="form-group">
			<div class="col-lg-9 col-lg-offset-3">
				<button type="submit" class="btn btn-primary" name="signup"
					value="Sumbit">Save</button>
				<button type="button" class="btn btn-danger" id="cancelBtn">Cancel</button>
			</div>
		</div>
	</fieldset>
</form:form>


