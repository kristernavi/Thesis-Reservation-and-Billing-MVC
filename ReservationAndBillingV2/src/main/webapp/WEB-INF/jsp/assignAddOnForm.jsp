<%@ include file="/WEB-INF/jsp/includes.jsp"%>



<c:url var="actionUrl" value="assign" />

<form:form id="addOnForm" commandName="addOnDetail" method="post"
	action="${actionUrl }" class="form-horizontal">

	<fieldset>
		<legend></legend>

		
		

	
		<div class="form-group">
			<label class="col-sm-4 control-label">Description</label>
			<label  class="col-sm-5">${addOn.description}</label>
			
		</div>
				<div class="form-group">
			<label class="col-sm-4 control-label">Rate</label>
			<label  class="col-sm-5">${addOn.rate}</label>
			
			</div>
			
		</div>
	
		<div class="form-group">
                                <label class="col-sm-4 control-label">Rooms Check In</label>
                                <div class="col-sm-6">
                                <form:select path="occupancy.id" cssClass="form-control">
				  <form:options items="${check_inList}"   itemLabel="room.roomWithPrefix"  itemValue="id"/>
				</form:select>
				</div>
                            </div>
		
		<%-- <div class="pure-control-group">
			<label for="publishedOn">Published On</label>
			<form:input path="publishedOn"
				placeholder="YYYY-MM-DD" class="datepicker" />
		</div> --%>

		
	<form:input path="addOn.id" type="hidden" value="${addOn.id }" />
	 <div class="form-group">
                            <div class="col-lg-9 col-lg-offset-3">
                                <button type="submit" class="btn btn-primary" name="signup" value="Sumbit">Save</button>
                                <button type="button" class="btn btn-danger" id="cancelBtn">Cancel</button>
                            </div>
                        </div>
                         
                        
	</fieldset>
</form:form>






