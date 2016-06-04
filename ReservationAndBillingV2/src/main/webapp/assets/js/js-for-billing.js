
/**
 * @param id
 */
function addBilling(index) {

    $.get("get/" + index, function(result) {
    	
        $("#BillingDialog").html(result);
        $('#BillingDialog').dialog("option", "title", 'Add Billing');
        $("#BillingDialog").dialog('open');
        
        validationForm();
        function myFunction() {
            document.getElementById("myBtn").disabled = true;
        }
        function myFunction2() {
           document.getElementById("myBtn").disabled = false;
        }

        $(document).ready(function () {
            $('#creditcard').hide();
         $("#multiOptions").change(function () {
             if ($(this).val() == "CASH" ) {
          	   $('#creditcard').hide();
             }
          else if ($(this).val() == "CREDIT_CARD") {
              $('#cash').hide();
              $('#creditcard').show();
             }
             
         });
         });


        


 });
}

function addAddon(index) {

    $.get("add/" + index, function(result) {
    	
        $("#BillingDialog").html(result);
        $('#BillingDialog').dialog("option", "title", 'Avail Add-On');
        $("#BillingDialog").dialog('open');
        
        validationForm();
        function myFunction() {
            document.getElementById("myBtn").disabled = true;
        }
        function myFunction2() {
           document.getElementById("myBtn").disabled = false;
        }

        $(document).ready(function () {
            $('#creditcard').hide();
         $("#multiOptions").change(function () {
             if ($(this).val() == "CASH" ) {
          	   $('#creditcard').hide();
             }
          else if ($(this).val() == "CREDIT_CARD") {
              $('#cash').hide();
              $('#creditcard').show();
             }
             
         });
         });


        


 });
}



function validationForm(){
	
	$j(document).ready(function() {
    	$j('#billingForm').bootstrapValidator({
            container: 'tooltip',
//            trigger: 'blur',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
              
                Billing_no: {
                    validators: {
                        stringLength: {
                            min: 1,
                            message: 'The Billing number must atleast 1 character'
                        },
                        notEmpty: {
                            message: 'The Billing number is required'
                        },
                        regexp: {
                            regexp: /^\d+$/,
                            message: 'The Billing number must consist of a number only'
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
        $j('#billingForm').data('bootstrapValidator').resetForm(true);
        //$j(this).dialog('close');
        $('#BillingDialog').dialog('close');
        	
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

	$('#BillingDialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 440,
		
		close : function() {

			resetDialog($('#BillingForm'));

			$(this).dialog('close');
		}
	});

	initializeDatePicker();
});


validationForm();


