

/// <reference path="../jquery-3.1.1.js" />
$(document).ready(function () {

    const CSS_CLASS_CORRECT = "correct";    
    const NUMBER_OF_PRESIDENTS = 45;
    const NUMBER_OF_REPUBLICANS = 19;
    const NUMBER_OF_DEMOCRATS = 15;
    const NUMBER_OF_OTHERS = 11;
    const NUMBER_OF_JAMES = 5;
    const NUMBER_OF_CENTURY_BEGINNERS = 4;
    const NUMBER_OF_CENTURY_ENDERS = 4;
    const NUMBER_OF_20THCENTURY_CURRENCY = 4;

    $("#btnPresident").on("click", function (e)
    {
        presentialDivs();
        
        if($(".president").length == NUMBER_OF_PRESIDENTS) {
            $("#exercise1").addClass(CSS_CLASS_CORRECT);
        }
        
    });

    $("#btnFoundingFather").on("click", function (e) {

        georgeWashington();

        if ($(".founding-father").length == 1) {
            $("#exercise2").addClass(CSS_CLASS_CORRECT);
        }
        
    });

    $("#btnRepublicans").on("click", function () {
        republicanPresidents();

        if ($(".red").length == NUMBER_OF_REPUBLICANS)
        {
            $("#exercise3").addClass(CSS_CLASS_CORRECT);
        }
    });

    $("#btnDemocrats").on("click", function () {
        democratPresidents();

        if ($(".blue").length == NUMBER_OF_DEMOCRATS) {
            $("#exercise4").addClass(CSS_CLASS_CORRECT);
        }
    });

    $("#btnOther").on("click", function () {
        otherPresidents();

        if ($(".gold").length == NUMBER_OF_OTHERS) {
            $("#exercise5").addClass(CSS_CLASS_CORRECT);
        }
    });

    $("#btnJames").on("click", function () {
        presidentsNamedJames();

        if ($(".james").length == NUMBER_OF_JAMES) {
            $("#exercise6").addClass(CSS_CLASS_CORRECT);
        }
    });

    $("#btnBeginningOfCentury").on("click", function () {
        turnOfTheCenturyPresidents();

        if ($(".beginningOfCentury").length == NUMBER_OF_CENTURY_BEGINNERS) {
            $("#exercise7").addClass(CSS_CLASS_CORRECT);
        }
    });

    $("#btnEndOfCentury").on("click", function() { 
        endOfTheCenturyPresidents();

        if ($(".endOfCentury").length == NUMBER_OF_CENTURY_ENDERS) {
            $("#exercise8").addClass(CSS_CLASS_CORRECT);
        }
    });

    $("#btnAppearOnCurrency").on("click", function () {
        currencyPresidents();

        if ($(".appearOnCurrency").length == NUMBER_OF_20THCENTURY_CURRENCY) {
            $("#exercise9").addClass(CSS_CLASS_CORRECT);
        }
    });
});