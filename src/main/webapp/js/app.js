$(document).ready(function(event) {
$("#stateId").change(function() {
		
		$("#cityId").find('option').remove();
		$('<option>').val('').text('-Select-').appendTo("#cityId");
		
		var stateId = $("#stateId").val();
		$.ajax({
			type : "GET",
			url : "getCities?sid=" + stateId,
			success : function(data) {
				$.each(data, function(cityId, cityName) {
					$('<option>').val(cityId).text(cityName).appendTo("#cityId");
				});
			}
		});
	});
});