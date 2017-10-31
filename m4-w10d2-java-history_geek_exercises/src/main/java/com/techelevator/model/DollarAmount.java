package com.techelevator.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DollarAmount {

	public static final DollarAmount ZERO_DOLLARS = new DollarAmount(0);

	private long totalAmountInCents;

	public DollarAmount(int totalAmountInCents) {
		this.totalAmountInCents = totalAmountInCents;
	}

	public DollarAmount(long totalAmountInCents) {
		this.totalAmountInCents = totalAmountInCents;
	}
	
	public DollarAmount(BigDecimal amount) {
		BigDecimal oneHundred = new BigDecimal("100");
		this.totalAmountInCents = amount.multiply(oneHundred).intValue();
	}

	public boolean isGreaterThan(DollarAmount amountToCompare) {
		return this.totalAmountInCents > amountToCompare.totalAmountInCents;
	}

	public boolean isGreaterThanOrEqualTo(DollarAmount amountToCompare) {
		return this.totalAmountInCents >= amountToCompare.totalAmountInCents;
	}

	public boolean isLessThan(DollarAmount amountToCompare) {
		return this.totalAmountInCents < amountToCompare.totalAmountInCents;
	}

	public boolean isLessThanOrEqualTo(DollarAmount amountToCompare) {
		return this.totalAmountInCents <= amountToCompare.totalAmountInCents;
	}

	public boolean isNegative() {
		return totalAmountInCents < 0;
	}

	public DollarAmount minus(DollarAmount amountToSubtract) {
		return new DollarAmount(this.totalAmountInCents - amountToSubtract.totalAmountInCents);
	}

	public DollarAmount plus(DollarAmount amountToAdd) {
		return new DollarAmount(this.totalAmountInCents + amountToAdd.totalAmountInCents);
	}

	public DollarAmount multipliedBy(long multiplier) {
		return new DollarAmount(totalAmountInCents * multiplier);
	}

	public DollarAmount multipliedBy(double multiplier) {
		return new DollarAmount(getBigDecimalValue().multiply(new BigDecimal(multiplier)));
	}
	
	/**
	 * Will truncate fractional cents.
	 * 
	 * @param divisor
	 * @return
	 */
	public DollarAmount dividedBy(long divisor) {
		return new DollarAmount(totalAmountInCents / divisor);
	}
	
	public BigDecimal getBigDecimalValue() {
		return new BigDecimal(toDecimalString()).setScale(2, RoundingMode.DOWN);
	}

	private String toDecimalString() {
		long dollars = totalAmountInCents / 100;
		int cents = (int)(totalAmountInCents % 100);
		String centsString = cents >= 10 ? String.valueOf(cents) : "0"+String.valueOf(cents);
		String decimalString = String.valueOf(dollars) + "." + centsString;
		return decimalString;
	}

	public int compareTo(DollarAmount amountToCompare) {
		if (this.isGreaterThan(amountToCompare)) {
			return 1;
		} else if (this.isLessThan(amountToCompare)) {
			return -1;
		} else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof DollarAmount) {
			return this.totalAmountInCents == ((DollarAmount) obj).totalAmountInCents;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return new Long(totalAmountInCents).hashCode();
	}

	@Override
	public String toString() {
		return "$"+toDecimalString();
	}
}
