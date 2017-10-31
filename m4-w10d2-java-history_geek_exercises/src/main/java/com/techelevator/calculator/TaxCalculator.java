package com.techelevator.calculator;

public class TaxCalculator {

    /**
     * This "hypothetical tax calculator" gives the best rates (if you live in the right zip code that is).
     * It doens't look at a real system to determine the right tax rate. It uses the first two digits
     * of your zip code to determine the tax rate %.
     * 
     * A much more realistic solution would rely on a tax rate web service to look at the zip code and determine
     * what the tax rate for that county is.
     */

    public static double getTaxRate(String billingZipcode) {
        String firstTwo = billingZipcode.substring(0, 2);
        double rate = Integer.parseInt(firstTwo) / 100.0;

        return rate;
    }

}
