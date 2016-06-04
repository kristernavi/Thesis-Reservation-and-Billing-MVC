<%@ include file="/WEB-INF/jsp/includes.jsp"%>




<form:form id="changeDate" commandName="er" method="post"
	action="${pageContext.request.contextPath}/saveChangeDate" class="form-horizontal">

	<fieldset>
		<legend></legend>

		<div class="form-group">
			<label class="col-sm-4 control-label">Current Check-in Date</label>
			<label class="col-sm-5 control-label">${rrList[0].from }</label>
			
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Current Check-out Date</label>
			<label class="col-sm-5 control-label">${rrList[0].to }</label>
			
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Select date to reserve</label>
		<div class="col-xs-3" style="
	    width: 240px;"
		>
			<input type="text" id="demo" class="form-control">			
		</div>
		</div>

		  <div class="form-group" id="creditcard">
        <label class="col-xs-4 control-label">Credit Card Number   </label>
<div class="col-xs-3" style="
    width: 240px;
">
<form:input path="cc_number" cssClass="form-control"/>
        </div>
    </div>
    <form:input path="key" type="hidden" value="${reserveList.reference }"/>
      	<form:input path="method" type="hidden" value="CREDIT_CARD"/>
    	<form:input path="editFrom" type="hidden" value="${rrList[0].from }"/>	
		<form:input path="editTo" type="hidden" value="${rrList[0].to }"/>	
		<form:input path="reserve_id" type="hidden" value="${rrList[0].reserve.id }"/>
		<form:input path="param_id" type="hidden" value="${param_id } "/>
	 <div class="form-group">
                            <div class="col-lg-9 col-lg-offset-3">
                                <button type="submit" class="btn btn-primary" id="myBtn" name="signup" value="Sumbit">Save</button>
                                <button type="button" class="btn btn-danger" id="cancelBtn">Cancel</button>
                            </div>
                        </div>
                         
                        
	</fieldset>
</form:form>






