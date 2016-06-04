
formValidator();
function formValidator(){
	
	$j(document).ready(function() {
		$j('#guestForm').bootstrapValidator({
	        container: 'tooltip',
//	        trigger: 'blur',
	        feedbackIcons: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	          
	        	"ccBilling.billing.reserve.guest.firstname": {
	                validators: {
	                    stringLength: {
	                        min: 2,
	                        max: 30,
	                        message: 'The firstname must be more than 2 and less than 30 characters long'
	                    },
	                    notEmpty: {
	                        message: 'The firstname is required'
	                    },
	                    regexp: {
	                        regexp: /^[A-Za-z ]+$/,
	                        message: 'The first name must consist of a-z, A-Z characters only'
	                    }
	                }
	            },
	            "ccBilling.billing.reserve.guest.lastname": {
	        	validators: {
	                stringLength: {
	                    min: 2,
	                    max: 30,
	                    message: 'The lastname must be more than 2 and less than 30 characters long'
	                },
	                notEmpty: {
	                    message: 'The lastname number is required'
	                },
	                regexp: {
	                    regexp: /^[A-Za-z ]+$/,
	                    message: 'The last name must consist of a-z, A-Z characters only'
	                }
	            }
	        },
	        "ccBilling.billing.reserve.guest.address": {
	        	validators: {
	                stringLength: {
	                    min: 2,
	                    max: 100,
	                    message: 'The address must be more than 4 and less than 30 characters long'
	                },
	                notEmpty: {
	                    message: 'The last name is required'
	                }
	            }
	        },
	        "ccBilling.billing.reserve.guest.contactNumber": {
	            validators: {
	                stringLength: {
	                    min: 4,
	                    max: 20,
	                    message: 'The capacity must minimum of 4 and maximum of 20 character'
	                },
	                notEmpty: {
	                    message: 'The contact number is required'
	                },
	                regexp: {
	                    regexp: /^\d+$/,
	                    message: 'The contact number must consist of a number only'
	                }
	            }
	        },
	        "ccBilling.billing.reserve.guest.email": {
	            validators: {
	            	  emailAddress: {
	                      message: 'The input is not a valid email address'
	                  }
	            }
	        },
	        "ccBilling.cc.number": {
                validators: {
                    stringLength: {
                        min: 16,
                        max: 25,
                        message: 'The credit card must minimum of 16 and maximum of 25 character'
                    },
                    notEmpty: {
                        message: 'The credit card is required'
                    },
                    
                    regexp: {
                        regexp: /^\d+$/,
                        message: 'The credit card must consist of a number only'
                    }
                }
            }
	        }
	    });
		
	});
	$j('#cancelBtn').click(function() {
	    $j('#guestForm').data('bootstrapValidator').resetForm(true);
	    $('#guestDialog').dialog('close');
	    	
	});
	
}