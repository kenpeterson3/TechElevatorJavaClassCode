<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<h2>Complete your checkout</h2>
<div id="errorSummary">
	<h3>You have the following errors: </h3>
	<ul id="errors"></ul>
</div>
 
 <c:url var="formAction" value="/store/checkout" />
<form action="${formAction}" id="checkout" method="post"> 
	<fieldset id="billing-info">
		<h3>Billing Address</h3>
		<input id="BillingAddress1" name="BillingAddress1" placeholder="address" type="text" value="" />
		<input id="BillingAddress2" name="BillingAddress2" placeholder="apt., suite, company" type="text" value="" />
		<input id="BillingCity" name="BillingCity" placeholder="city" type="text" value="" />
		<input id="BillingState" name="BillingState" placeholder="state" type="text" value="" />
		<input id="BillingPostalCode" name="BillingPostalCode" placeholder="zip code" type="text" value="" />
		<input id="SameShipping" name="SameShipping" type="checkbox" value="true" />
		<input name="SameShipping" type="hidden" value="false" /><label>My shipping address is the same</label>
		<h3>Shipping Address</h3>
		<input id="ShippingAddress1" name="ShippingAddress1" placeholder="address" type="text" value="" />
		<input id="ShippingAddress2" name="ShippingAddress2" placeholder="apt., suite, company" type="text" value="" />
		<input id="ShippingCity" name="ShippingCity" placeholder="city" type="text" value="" />
		<input id="ShippingState" name="ShippingState" placeholder="state" type="text" value="" />
		<input id="ShippingPostalCode" name="ShippingPostalCode" placeholder="zip code" type="text" value="" />
	</fieldset>
	<fieldset id="shipping-info">
		<h3>Shipping Method</h3>
		<p><input data-cost="${order.shippingRates['Standard'].bigDecimalValue}" id="ShippingType" name="ShippingType" type="radio" value="Standard" /> <label>Standard Shipping: ${order.shippingRates['Standard']}</label></p>
		<p><input data-cost="${order.shippingRates['Express'].bigDecimalValue}" id="ShippingType" name="ShippingType" type="radio" value="Express" /> <label>Express Shipping: ${order.shippingRates['Express']}</label></p>
		<p><input data-cost="${order.shippingRates['Two-Day'].bigDecimalValue}" id="ShippingType" name="ShippingType" type="radio" value="Two-Day" /> <label>Two-Day Shipping: ${order.shippingRates['Two-Day']}</label></p>
		<p><input data-cost="${order.shippingRates['Overnight'].bigDecimalValue}" id="ShippingType" name="ShippingType" type="radio" value="Overnight" /> <label>Overnight Shipping: ${order.shippingRates['Overnight']}</label></p>
	</fieldset>
	<fieldset id="payment-info">
		<h3>Payment</h3>
		<input id="NameOnCard" name="NameOnCard" placeholder="name on card" type="text" value="" />
		<input id="CreditCardNumber" name="CreditCardNumber" placeholder="credit card" type="text" value="" />
		<input id="ExpirationDate" name="ExpirationDate" placeholder="mm/yy" type="text" value="" />
	</fieldset>
	<fieldset id="order-summary">
		<h3>Summary</h3>
		<p id="subtotal" class="attribute">Subtotal: <span class="price">${order.subTotal}</span></p>
		<p id="tax" class="attribute">Tax: <span class="price">${order.tax}</span></p>
		<p id="shipping" class="attribute">Shipping: <span class="price">${order.shipping}</span></p>
		<p id="grandtotal" class="attribute">Grand Total: <span class="price">${order.total}</span></p>
		<button>Complete Order</button>
	</fieldset>
	</form>
</form>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
