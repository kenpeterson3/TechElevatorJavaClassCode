/// <reference path="../jquery-3.1.1.js" />
//Locate all <div> elements and add the 'president' class.
function presentialDivs() {
    $('div#presidents > div').addClass('president');
}

//Locate George Washington and add the 'founding-father' class
function georgeWashington() {
	$('#george-washington').addClass('founding-father');
}

//Locate all Republican presidents and add the 'red' class.
function republicanPresidents() {
	 $('.Republican').addClass('red');
}

//Locate all Democrat presidents and add the 'blue' class.
function democratPresidents() {
 $('.Democratic').addClass('blue');
}

//Locate all Federalist presidents and add the 'gold' class.
function otherPresidents() {
	$('div#presidents > div').not('.Republican').not('.Democratic').addClass('gold');
}

//Locate all presidents named 'James' and add the 'james' class.
function presidentsNamedJames() {
	$('[id^="james"]').addClass('james');
}

//Locate each president serving at the beginning of each century and add the 'beginningOfCentury' class.
function turnOfTheCenturyPresidents() {
	$('h2').next('div').addClass('beginningOfCentury');
}

//Locate each president serving at the end of the century and add the 'endOfCentury' class.
function endOfTheCenturyPresidents() {
	$('div').prev('h2').addClass('endOfCentury');
}

//Locate all presidents serving in the 1900s who appear on currency and add the 'appearOnCurrency' class.
function currencyPresidents() {
	$("h2:contains('1900s')").nextAll('.currency').addClass('appearOnCurrency');
}