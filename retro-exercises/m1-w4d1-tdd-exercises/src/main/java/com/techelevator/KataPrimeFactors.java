package com.techelevator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class KataPrimeFactors {
	public int[] primeFinder(int num) {
		List<Integer> primes = findPrimes(num);
		
		return turnIntegerListIntoIntArray(primes);
	}

	private List<Integer> findPrimes(int num) {
		List<Integer> factors = new ArrayList<>();
		for(int potentialPrime = num / 2; potentialPrime > 1; potentialPrime--) {
			if(num % potentialPrime == 0) {
				factors.addAll(findPrimes(potentialPrime));
				factors.addAll(findPrimes(num / potentialPrime));
				return factors;
			}
		}
		
		factors.add(num);
		return factors;
	}

	private int[] turnIntegerListIntoIntArray(List<Integer> primes) {
		int[] newArray = new int[primes.size()];
		for(int i = 0; i < primes.size(); i++) {
			newArray[i] = primes.get(i);
		}
		return newArray;
	}
}
