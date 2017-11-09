/// <reference path="../jquery-3.1.1.js" />

$(document).ready(function () {
	
	$("#SameShipping").on('click', function() {
		if(this.checked == true) {
		$("#ShippingAddress1").val($("#BillingAddress1").val());
		$("#ShippingAddress2").val($("#BillingAddress2").val());
		$("#ShippingCity").val($("#BillingCity").val());
		$("#ShippingState").val($("#BillingState").val());
		$("#ShippingPostalCode").val($("#BillingPostalCode").val());
		}
	});
	
	$("input[name='ShippingType']").on('click', function(event){
		var checkBox = $(this); //Grab this object
		var checkShipping = checkBox.attr('data-cost'); //get attributes('data-cost') of this object
		$('#shipping > .price').text('$' + checkShipping); //.text for content
		
		var subttl = $('#subtotal > .price').text().substring(1);
		$('#grandtotal > .price').text('$' + (parseFloat(checkShipping) + parseFloat(subttl)).toFixed(2));
		
	});
	

});

function grandTotal(){
    var subtotal = $('#subtotal span').text();
    subtotal = parseFloat(subtotal.substring(1, subtotal.length));
    
    var tax = $('#tax span').text();
    tax = parseFloat(tax.substring(1, tax.length));
    
    var shipping = $('#shipping span').text();
    shipping = parseFloat(shipping.substring(1, shipping.length));
    
    var grandTotal = subtotal + tax + shipping;
    $('#order-summary #grandtotal span').text('$' + grandTotal);
    
}

