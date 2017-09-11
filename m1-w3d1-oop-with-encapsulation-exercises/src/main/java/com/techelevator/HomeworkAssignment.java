package com.techelevator;

public class HomeworkAssignment {
	//instance variables
	private int totalMarks;
	private int possibleMarks;
	private String submitterName;
	
	
	//letterGrade method
	//methods
	public String getLetterGrade () {
		//letterGrade = totalMarks / possibleMarks;
		if (((1.0 * totalMarks / possibleMarks) * 100) >= 90) {
			return "A";
		} else if ((((double)totalMarks/ possibleMarks) * 100) >= 80) {
			return "B";
		} else if (((1.0 * totalMarks / possibleMarks) * 100) >= 70) {
			return "C";
		} else if (((1.0 * totalMarks / possibleMarks) * 100) >= 60) {
			return "D";
		} else {
			return "F";
		}	
	}
	//constructor
	public HomeworkAssignment (int possibleMarks) {
		this.possibleMarks = possibleMarks;
	}


	public int getTotalMarks() {
		return totalMarks;
	}


	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}


	public String getSubmitterName() {
		return submitterName;
	}


	public void setSubmitterName(String submitterName) {
		this.submitterName = submitterName;
	}


	public int getPossibleMarks() {
		return possibleMarks;
	}

}
