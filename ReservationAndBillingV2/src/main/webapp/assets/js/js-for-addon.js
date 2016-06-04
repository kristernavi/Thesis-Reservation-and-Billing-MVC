function addAddOn() {
	$('#addOnDialog').dialog("option", "title", 'Add Add On');
	$('#addOnDialog').dialog('open');
	$j('#addOnForm').data('bootstrapValidator').resetForm(true);
	
}

/**
 * @param id
 */
function assignAddOn(id) {

    $.get("gets/" + id, function(result) {
    	
        $("#addOnDialog2").html(result);
        $('#addOnDialog2').dialog("option", "title", 'Avail Add On');
        $("#addOnDialog2").dialog('open');
        
        validationForm();


        


 });
}
function editAddOn(id) {

    $.get("get/" + id, function(result) {
    	
        $("#addOnDialog").html(result);
        $('#addOnDialog').dialog("option", "title", 'Edit Add On');
        $("#addOnDialog").dialog('open');
        
        validationForm();


        


 });
}

function validationForm(){
	
	$j(document).ready(function() {
    	$j('#addOnForm').bootstrapValidator({
            container: 'tooltip',
//            trigger: 'blur',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
              
                addOn_no: {
                    validators: {
                        stringLength: {
                            min: 1,
                            message: 'The addOn number must atleast 1 character'
                        },
                        notEmpty: {
                            message: 'The addOn number is required'
                        },
                        regexp: {
                            regexp: /^\d+$/,
                            message: 'The addOn number must consist of a number only'
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
        $j('#addOnForm').data('bootstrapValidator').resetForm(true);
        //$j(this).dialog('close');
        $('#addOnDialog').dialog('close');
        	
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

	$('#addOnDialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 440,
		
		close : function() {

			resetDialog($('#addOnForm'));

			$(this).dialog('close');
		}
	});

	initializeDatePicker();
});
$(document).ready(function() {

	$('#addOnDialog2').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 440,
		
		close : function() {

			resetDialog($('#addOnForm'));

			$(this).dialog('close');
		}
	});

	initializeDatePicker();
});

validationForm();


