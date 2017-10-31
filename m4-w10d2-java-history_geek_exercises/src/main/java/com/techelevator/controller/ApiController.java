package com.techelevator.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.calculator.TaxCalculator;

@RestController
public class ApiController {

	/**
	 * ApiController allows us to separate our
	 * controllers that handle view logic from controllers that provide output to clients making
	 * asynchronous HTTP requests.
	 */
	@RequestMapping(path="/api/getTax", method=RequestMethod.GET)
    public BigDecimal getTax(@RequestParam String billingZipCode, @RequestParam double subtotal) {
		double taxRate = TaxCalculator.getTaxRate(billingZipCode);
		BigDecimal taxTotal = new BigDecimal(subtotal * taxRate).setScale(2, BigDecimal.ROUND_HALF_DOWN);
        return taxTotal;
    }

}
