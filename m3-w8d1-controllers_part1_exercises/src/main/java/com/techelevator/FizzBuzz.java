package com.techelevator;

public class FizzBuzz {
	private int divisor1;
	private int divisor2;
	private String alternateFizz;
	private String alternateBuzz;
	private int[] nums;

	
	public String[] runFizzBuzz() {
		
		String[] result = new String[nums.length];
		
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] % (divisor1 * divisor2) == 0) {
				result[i] = Integer.toString(nums[i]) + alternateFizz + alternateBuzz;
			}
			else if(nums[i] % divisor1 == 0) {
				result[i] = Integer.toString(nums[i]) + alternateFizz;
			}
			else if(nums[i] % divisor2 == 0) {
				result[i] = Integer.toString(nums[i]) + alternateBuzz;
			} else {
				result[i] = Integer.toString(nums[i]);
			}
		}
		return result;
	}

	public int getDivisor1() {
		return divisor1;
	}
	public void setDivisor1(int divisor1) {
		this.divisor1 = divisor1;
	}
	public int getDivisor2() {
		return divisor2;
	}
	public void setDivisor2(int divisor2) {
		this.divisor2 = divisor2;
	}
	public String getAlternateFizz() {
		return alternateFizz;
	}
	public void setAlternateFizz(String alternateFizz) {
		this.alternateFizz = alternateFizz;
	}
	public String getAlternateBuzz() {
		return alternateBuzz;
	}
	public void setAlternateBuzz(String alternateBuzz) {
		this.alternateBuzz = alternateBuzz;
	}
	public int[] getNums() {
		return nums;
	}
	public void setNums(int[] nums) {
		this.nums = nums;
	}
	
}	
	

