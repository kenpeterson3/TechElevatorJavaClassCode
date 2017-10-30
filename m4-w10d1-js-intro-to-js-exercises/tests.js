QUnit.test("Sum Double", function (assert) {
    
    assert.equal(sumDouble(1, 2), 3);
    assert.equal(sumDouble(3, 2), 5);
    assert.equal(sumDouble(2, 2), 8);

});

QUnit.test("Has Teen", function (assert) { 
    
    assert.equal(hasTeen(13, 20, 10), true);
    assert.equal(hasTeen(20, 19, 10), true);
    assert.equal(hasTeen(20, 10, 13), true);
    assert.equal(hasTeen(9, 21, 5), false);

});

QUnit.test("Last Digit", function (assert) {
    
    assert.equal(lastDigit(7, 17), true);
    assert.equal(lastDigit(6, 17), false);
    assert.equal(lastDigit(3, 113), true);

});

QUnit.test("See Color", function (assert) {

    assert.equal(seeColor("redxx"), "red");
    assert.equal(seeColor("xxred"), "");
    assert.equal(seeColor("blueTimes"), "blue");
    assert.equal(seeColor("blue"), "blue");
    assert.equal(seeColor(""), "");

});

QUnit.test("Middle Three", function (assert) {    
    assert.equal(middleThree("Candy"), "and");
    assert.equal(middleThree("CANDY"), "AND");
    assert.equal(middleThree("and"), "and");
    assert.equal(middleThree("solving"), "lvi");
});

QUnit.test("Front Again", function (assert) {    
    assert.equal(frontAgain("edited"), true);
    assert.equal(frontAgain("edit"), false);
    assert.equal(frontAgain("ed"), true);
    assert.equal(frontAgain("Edited"), false);
});

QUnit.test("Alarm Clock", function (assert) {
    
    assert.equal(alarmClock(1, false), "7:00");
    assert.equal(alarmClock(5, false), "7:00");
    assert.equal(alarmClock(5, true), "10:00");
    assert.equal(alarmClock(0, true), "off");

});

QUnit.test("Make Middle", function (assert) {    
    assert.deepEqual(makeMiddle([1, 2, 3, 4]), [2, 3]);
    assert.deepEqual(makeMiddle([7, 1, 2, 3, 4, 9]), [2, 3]);
    assert.deepEqual(makeMiddle([]), []);
    assert.deepEqual(makeMiddle([1]), []);
    assert.deepEqual(makeMiddle([1, 3, 5]), []);
    assert.deepEqual(makeMiddle([1, 2]), [1,2]);
});

QUnit.test("Odd Only", function (assert) {    
    assert.deepEqual(oddOnly([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]), [1, 3, 5, 7, 9, 11]);
    assert.deepEqual(oddOnly([2, 4, 8, 32, 256]), []);
});

QUnit.test("Weave", function (assert) {
    
    assert.deepEqual(weave([1, 3, 5], [2, 4]), [1, 2, 3, 4, 5]);
    assert.deepEqual(weave([1, 3, 5], [2, 4, 6, 8]), [1, 2, 3, 4, 5, 6, 8]);
    assert.deepEqual(weave([], []), []);

});

QUnit.test("Cigar Party", function (assert) {
    
    assert.equal(cigarParty(30, false), false);
    assert.equal(cigarParty(50, false), true);
    assert.equal(cigarParty(70, true), true);
    
});

QUnit.test("String Splosion", function (assert) {

    assert.equal(stringSplosion("Code"), "CCoCodCode");
    assert.equal(stringSplosion("supercalifragilisticexpialidocious"), "ssusupsupesupersupercsupercasupercalsupercalisupercalifsupercalifrsupercalifrasupercalifragsupercalifragisupercalifragilsupercalifragilisupercalifragilissupercalifragilistsupercalifragilistisupercalifragilisticsupercalifragilisticesupercalifragilisticexsupercalifragilisticexpsupercalifragilisticexpisupercalifragilisticexpiasupercalifragilisticexpialsupercalifragilisticexpialisupercalifragilisticexpialidsupercalifragilisticexpialidosupercalifragilisticexpialidocsupercalifragilisticexpialidocisupercalifragilisticexpialidociosupercalifragilisticexpialidociousupercalifragilisticexpialidocious");

});

QUnit.test("Fizz Buzz", function (assert) {

    assert.equal(fizzBuzz(1), 1);
    assert.equal(fizzBuzz(2), 2);
    assert.equal(fizzBuzz(3),"Fizz");
    assert.equal(fizzBuzz(5),"Buzz");
    assert.equal(fizzBuzz(9),"Fizz");
    assert.equal(fizzBuzz(10),"Buzz");
    assert.equal(fizzBuzz(15), "FizzBuzz");

});

QUnit.test("Count Values", function (assert) {

    assert.deepEqual(
        { 1: 1, 99: 3, 43: 1, 2: 2, 55: 1, 78: 1, 2345: 1, 438: 1, 107: 1 },
        countValues([1, 99, 43, 2, 55, 78, 99, 2345, 438, 2, 99, 107]));

    assert.deepEqual(countValues([]), {});
    assert.deepEqual(countValues([0]), { 0: 1 });
    assert.deepEqual(countValues([0, 20]), { 0: 1, 20: 1 });
});

QUnit.test("Reverse Array", function (assert) {

    assert.deepEqual(reverseArray([1, 9, 3, 1]), [1, 3, 9, 1]);
    assert.deepEqual(reverseArray([]), []);
    assert.deepEqual(reverseArray([1, 1, 1]), [1, 1, 1]);
    assert.deepEqual(reverseArray([9]), [9]);

});






