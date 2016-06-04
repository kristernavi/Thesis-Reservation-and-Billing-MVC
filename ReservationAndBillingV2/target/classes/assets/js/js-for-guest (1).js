function addGuest() {
	$('#guestDialog').dialog("option", "title", 'Add Guest');
	$('#guestDialog').dialog('open');
}

function editGuest(id) {

    $.get("get/" + id, function(result) {

        $("#guestDialog").html(result);
        $('#guestDialog').dialog("option", "title", 'Edit Guest');
        $("#guestDialog").dialog('open');

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

	$('#guestDialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 440,
		buttons : {
			"Save" : function() {
				$('#guestForm').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#guestForm'));

			$(this).dialog('close');
		}
	});

	initializeDatePicker();
});
