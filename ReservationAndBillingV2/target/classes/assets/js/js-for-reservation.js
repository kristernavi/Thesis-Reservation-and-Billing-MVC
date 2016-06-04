function addReservation() {
	$('#reserveDialog').dialog("option", "title", 'Add Reservation');
	$('#reserveDialog').dialog('open');
}

function editReservation(id) {

    $.get("get/" + id, function(result) {

        $("#reserveDialog").html(result);
        $('#reserveDialog').dialog("option", "title", 'Edit Reservation');
        $("#reserveDialog").dialog('open');

        initializeDatePicker();
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

	$('#reserveDialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 1110,
		buttons : {
			"Save" : function() {
				$('#reserveForm').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#reserveForm'));

			$(this).dialog('close');
		}
	});

	initializeDatePicker();
});
