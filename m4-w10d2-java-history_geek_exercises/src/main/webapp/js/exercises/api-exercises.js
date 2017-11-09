
var root = "http://localhost:8080/m4-java-historygeek-exercises";
/// <reference path="../jquery-3.1.1.js" />
$(document).ready(function () {
	$('#BillingPostalCode').on('change', function(event){
		var billingZipCode = $('#BillingPostalCode').val();
		var subtotal = $('#subtotal span').text();
		subtotal = subtotal.substring(1, subtotal.length);
		$.ajax({
			url: root + '/api/getTax',
			type: 'GET',
			data: {
				'billingZipCode' : billingZipCode,
				'subtotal' : subtotal,
			},
			dataType: 'json'
		}).then(function(data) {
			var tax = parseFloat(data).toFixed('2');
			$('#tax span').text('$' + tax);
			grandTotal();
		});
	});

	

});