function addGuest() {
	$('#guestDialog').dialog("option", "title", 'Add Guest');
	$('#guestDialog').dialog('open');
}

function editGuest(id) {

    $.get("get/" + id, function(result) {

        $("#guestDialog").html(result);
        $('#guestDialog').dialog("option", "title", 'Edit Guest');
        $("#guestDialog").dialog('open');
        formValidator();

 });
}

function initializeDatePicker() {
	$(".datepicker").datepicker({
		dateFormat : "yy-mm-dd",
		changeMonth : true,
		changeYear : true,
		showButtonPanel : true
	});
}

function resetDialog(form) {

	form.find("input").val("");
}

$(document).ready(function() {

	$('#guestDialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 440,
		
		close : function() {

			resetDialog($('#guestForm'));

			$(this).dialog('close');
		}
	});

	initializeDatePicker();
});
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
	          
	        	"occ.guest.firstname": {
	                validators: {
	                    stringLength: {
	                        min: 2,
	                        max: 30,
	                        message: 'The firstname must be more than 2 and less than 30 characters long'
	                    },
	                    notEmpty: {
	                        message: 'The room number is required'
	                    },
	                    regexp: {
	                        regexp: /^[A-Za-z ]+$/,
	                        message: 'The first name must consist of a-z, A-Z characters only'
	                    }
	                }
	            },
	            "occ.guest.lastname": {
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
	        "occ.guest.address": {
	        	validators: {
	                stringLength: {
	                    min: 2,
	                    max: 30,
	                    message: 'The address must be more than 4 and less than 30 characters long'
	                },
	                notEmpty: {
	                    message: 'The last name is required'
	                }
	            }
	        },
	        "occ.guest.contactNumber": {
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
	        "occ.guest.email": {
	            validators: {
	            	  emailAddress: {
	                      message: 'The input is not a valid email address'
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