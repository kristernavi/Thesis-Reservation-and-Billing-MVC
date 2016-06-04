function addRoom() {
	
	
	 $.get("get/roomform", function(result) {
	    	
	        $("#roomDialog").html(result);
	        $('#roomDialog').dialog("option", "title", "Add Room");
	        $("#roomDialog").dialog('open');
	        
	        validationForm();
	        $j('#roomForm').data('bootstrapValidator').resetForm(true);


	        


	 });
	
}

/**
 * @param id
 */
function editRoom(id) {

    $.get("get/" + id, function(result) {
    	
        $("#roomDialog").html(result);
        $('#roomDialog').dialog("option", "title", "Edit Room");
        $("#roomDialog").dialog('open');
        
        validationForm2();


        


 });
}

function validationForm(){
	
	$j(document).ready(function() {
    	$j('#roomForm').bootstrapValidator({
            container: 'tooltip',
//            trigger: 'blur',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
              
                room_no: {
                    validators: {
                        stringLength: {
                            min: 1,
                            message: 'The room number must atleast 1 character'
                        },
                        notEmpty: {
                            message: 'The room number is required'
                        },
                        remote: {
                        url: 
                        	location.href.substring(0,location.href.lastIndexOf('/'))+"/roomNo",
                        message: 'This room number is already use'
                    },
                        regexp: {
                            regexp: /^\d+$/,
                            message: 'The room number must consist of a number only'
                        }
                    }
                },
            rate: {
                validators: {
                    stringLength: {
                        min: 1,
                        message: 'The rate must atleast 1 character'
                    },
                    notEmpty: {
                        message: 'The rate is required'
                    },
                    regexp: {
                        regexp: /^\d+\.?\d*$/,
                        message: 'The rate must consist of integer or decimal'
                    }
                }
            },
            capacity: {
                validators: {
                    stringLength: {
                        min: 1,
                        max: 2,
                        message: 'The capacity must minimum of 1 and maximum of 2 character'
                    },
                    notEmpty: {
                        message: 'The capacity is required'
                    },
                    
                    regexp: {
                        regexp: /^\d+$/,
                        message: 'The capacity must consist of a number only'
                    }
                }
            }
            }
        });
    	
    });
    $j('#cancelBtn').click(function() {
        $j('#roomForm').data('bootstrapValidator').resetForm(true);
        //$j(this).dialog('close');
        $('#roomDialog').dialog('close');
        	
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

	$('#roomDialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 440,
		
		close : function() {

			resetDialog($('#roomForm'));

			$(this).dialog('close');
		}
	});

	initializeDatePicker();
});


function validationForm2(){
	
	$j(document).ready(function() {
    	$j('#roomForm').bootstrapValidator({
            container: 'tooltip',
//            trigger: 'blur',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
              
                room_no: {
                    validators: {
                        stringLength: {
                            min: 1,
                            message: 'The room number must atleast 1 character'
                        },
                        notEmpty: {
                            message: 'The room number is required'
                        },
                        
                        regexp: {
                            regexp: /^\d+$/,
                            message: 'The room number must consist of a number only'
                        }
                    }
                },
            rate: {
                validators: {
                    stringLength: {
                        min: 1,
                        message: 'The rate must atleast 1 character'
                    },
                    notEmpty: {
                        message: 'The rate is required'
                    },
                    regexp: {
                        regexp: /^-?\d+\.?\d*$/,
                        message: 'The rate must consist of integer or decimal'
                    }
                }
            },
            capacity: {
                validators: {
                    stringLength: {
                        min: 1,
                        max: 2,
                        message: 'The capacity must minimum of 1 and maximum of 2 character'
                    },
                    notEmpty: {
                        message: 'The capacity is required'
                    },
                    
                    regexp: {
                        regexp: /^\d+$/,
                        message: 'The capacity must consist of a number only'
                    }
                }
            }
            }
        });
    	
    });
    $j('#cancelBtn').click(function() {
        $j('#roomForm').data('bootstrapValidator').resetForm(true);
        //$j(this).dialog('close');
        $('#roomDialog').dialog('close');
        	
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

	$('#roomDialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 440,
		
		close : function() {

			resetDialog($('#roomForm'));

			$(this).dialog('close');
		}
	});

	initializeDatePicker();
});

