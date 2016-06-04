<%@ include file="/WEB-INF/jsp/includes.jsp"%>



<c:url var="actionUrl" value="save" />

<form:form id="billingForm" commandName="ccBilling" method="post"
	action="${actionUrl }" class="form-horizontal">

	<fieldset>
		<legend></legend>

		<div class="form-group">
			<label class="col-sm-4 control-label">Room #</label>
			<label class="col-sm-5 control-label">${occ2.room.room_no }</label>
			
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Fullname</label>
			<label class="col-sm-5 control-label">${occ2.guest.fullname }</label>
			
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Current Balanace</label>
			<label class="col-sm-5 control-label">${occ2.payable }</label>
			
		</div>
	<div class="form-group">
			<label class="col-sm-4	 control-label">Payment Option</label>
			<div class="col-sm-6">
				 <select id="multiOptions" name="billing.method" class="form-control">
				  <option value="CASH">CASH</option><option value="CREDIT_CARD">CREDIT CARD</option>
				</select>

			</div>

		</div>
		  <div class="form-group" id="creditcard">
        <label class="col-xs-4 control-label">Credit Card Number   </label>
<div class="col-xs-3" style="
    width: 240px;
">
<form:input path="cc.number" cssClass="form-control"/>
        </div>
    </div>
    	<form:input path="billing.id_recieve" type="hidden" value="${occ2.id }"/>
		<form:input path="billing.id_came" type="hidden" value="O"/>
		<form:input path="amount_pay" type="hidden" value="${occ2.payable }"/>
		<form:input path="billing.amount" type="hidden" value="${occ2.payable }"/>
	 <div class="form-group">
                            <div class="col-lg-9 col-lg-offset-3">
                                <button type="submit" class="btn btn-primary" id="myBtn" name="signup" value="Sumbit">Save</button>
                                <button type="button" class="btn btn-danger" id="cancelBtn">Cancel</button>
                            </div>
                        </div>
                         
                        
	</fieldset>
</form:form>






