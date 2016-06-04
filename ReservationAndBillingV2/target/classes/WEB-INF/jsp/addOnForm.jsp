<%@ include file="/WEB-INF/jsp/includes.jsp"%>



<c:url var="actionUrl" value="save" />

<form:form id="addOnForm" commandName="addOn" method="post"
	action="${actionUrl }" class="form-horizontal">

	<fieldset>
		<legend></legend>

		
		

	
		<div class="form-group">
			<label class="col-sm-4 control-label">Description</label>
			<div class="col-sm-7">
			<form:textarea name = "description" path="description" placeholder="Write Something" maxlength="100"
			cssClass="form-control"
			/>
			</div>
			
		</div>
				<div class="form-group">
			<label class="col-sm-4 control-label">Rate</label>
			<div class="col-sm-5">
			<form:input name="rate" id = "rate" path="rate" placeholder="Rate" maxlength="5"
			cssClass="form-control"
			/>
			</div>
			
		</div>
	
		
		
		<%-- <div class="pure-control-group">
			<label for="publishedOn">Published On</label>
			<form:input path="publishedOn"
				placeholder="YYYY-MM-DD" class="datepicker" />
		</div> --%>

		
	<form:input path="id" type="hidden" />
	 <div class="form-group">
                            <div class="col-lg-9 col-lg-offset-3">
                                <button type="submit" class="btn btn-primary" name="signup" value="Sumbit">Save</button>
                                <button type="button" class="btn btn-danger" id="cancelBtn">Cancel</button>
                            </div>
                        </div>
                         
                        
	</fieldset>
</form:form>






