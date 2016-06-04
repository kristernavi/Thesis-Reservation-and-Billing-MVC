
function addReservation(id) {

	$('#guestDialog').dialog("option", "title", 'Add Reservation');
	$('#guestDialog').dialog('open');
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

	
});
