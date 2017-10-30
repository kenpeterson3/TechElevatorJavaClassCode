QUnit.test("IQ Test", function (assert) {

    assert.equal(iqTest("2 4 7 8 10"), 3);
    assert.equal(iqTest("1 2 1 1"), 2);
    assert.equal(iqTest(""), 0);
    assert.equal(iqTest("2 2 4 6"), 0);

});

QUnit.test("Title Case", function (assert) {

    assert.equal(titleCase("a clash of KINGS", "a an the of"), "A Clash of Kings");
    assert.equal(titleCase("THE WIND IN THE WILLOWS", "The In"), "The Wind in the Willows");
    assert.equal(titleCase("the quick brown fox"), "The Quick Brown Fox");

});

QUnit.test("Perfect Square", function (assert) {

    assert.equal(perfectSquare(121), 144);
    assert.equal(perfectSquare(625), 676);
    assert.equal(perfectSquare(114), -1);

});