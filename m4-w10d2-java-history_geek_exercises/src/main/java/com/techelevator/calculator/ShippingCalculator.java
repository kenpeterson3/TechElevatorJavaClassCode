package com.techelevator.calculator;

import java.util.HashMap;
import java.util.Map;

import com.techelevator.model.DollarAmount;

public class ShippingCalculator {

	private static final DollarAmount STANDARD_PRICE_PER_LB = new DollarAmount(150);
	private static final DollarAmount EXPRESS_PRICE_PER_LB = new DollarAmount(225);
	private static final DollarAmount TWO_DAY_PRICE_PER_LB = new DollarAmount(550);
	private static final DollarAmount OVERNIGHT_PRICE_PER_LB = new DollarAmount(825);
	private static final int OUNCES_PER_LB = 16;
	
	/**
	 * This "hypothetical shipping calculator" gives the best rates (if you live very far that is).
	 * It doesn't use distance to calculate the shipping rate. For the sake of simplicity, it uses a
	 * multiplier (1.5 for standard, 2.25 for Express, etc.) and the weight of the shipment.
	 * 
	 * Ideally in the real-world something much better and profitable would be used such as a
	 * postage calculator service (e.g. https://www.easypost.com/)
	 */
    public static Map<String, DollarAmount> getShippingRates(double weightInOunces) 
    {
        Map<String, DollarAmount> rateMap = new HashMap<>();
        rateMap.put("Standard", STANDARD_PRICE_PER_LB.multipliedBy(weightInOunces).dividedBy(OUNCES_PER_LB));
        rateMap.put("Express", EXPRESS_PRICE_PER_LB.multipliedBy(weightInOunces).dividedBy(OUNCES_PER_LB));
        rateMap.put("Two-Day", TWO_DAY_PRICE_PER_LB.multipliedBy(weightInOunces).dividedBy(OUNCES_PER_LB));
        rateMap.put("Overnight", OVERNIGHT_PRICE_PER_LB.multipliedBy(weightInOunces).dividedBy(OUNCES_PER_LB));
        return rateMap;
    }

}
