package com.techelevator;

public class Exercises {

	/*
	 Given a string name, e.g. "Bob", return a greeting of the form "Hello Bob!".
	 helloName("Bob") → "Hello Bob!"
	 helloName("Alice") → "Hello Alice!"
	 helloName("X") → "Hello X!"
	 */
	public String helloName(String name) {
		String hello = new String("Hello " + name + "!");
		
		return hello;
	}

	/*
	 Given two strings, a and b, return the result of putting them together in the order abba, 
	 e.g. "Hi" and "Bye" returns "HiByeByeHi".
	 makeAbba("Hi", "Bye") → "HiByeByeHi"
	 makeAbba("Yo", "Alice") → "YoAliceAliceYo"
	 makeAbba("What", "Up") → "WhatUpUpWhat"
	 */
	public String makeAbba(String a, String b) {
		String abba = new String(a + b + b + a);
		return abba;
	}

	/*
	 The web is built with HTML strings like "<i>Yay</i>" which draws Yay as italic text. In this example,
	 the "i" tag makes <i> and </i> which surround the word "Yay". Given tag and word strings, create the 
	 HTML string with tags around the word, e.g. "<i>Yay</i>".
	 makeTags("i", "Yay") → "<i>Yay</i>"
	 makeTags("i", "Hello") → "<i>Hello</i>"
	 makeTags("cite", "Yay") → "<cite>Yay</cite>"
	 */
	public String makeTags(String tag, String word) {
		String htmlFakeTags = new String ("<" + tag + ">" + word + "</" + tag + ">" );
		
		return htmlFakeTags;
	}

	/*
	 Given an "out" string length 4, such as "<<>>", and a word, return a new string where the word is in the 
	 middle of the out string, e.g. "<<word>>". Note: use str.substring(i, j) to extract the String starting 
	 at index i and going up to but not including index j.
	 makeOutWord("<<>>", "Yay") → "<<Yay>>"
	 makeOutWord("<<>>", "WooHoo") → "<<WooHoo>>"
	 makeOutWord("[[]]", "word") → "[[word]]"
	 */
	public String makeOutWord(String out, String word) {
		String outStringMiddle = (out.substring(0, 2) + word + out.substring(2, 4));
		return outStringMiddle;
	}

	/*
	 Given a string, return a new string made of 3 copies of the last 2 chars of the original string. The string 
	 length will be at least 2.
	 extraEnd("Hello") → "lololo"
	 extraEnd("ab") → "ababab"
	 extraEnd("Hi") → "HiHiHi"
	 */
	public String extraEnd(String str) {
		String copyOfLast2Chars = str.substring(str.length() - 2) + str.substring(str.length() - 2) + str.substring(str.length() - 2);
		return copyOfLast2Chars;
	}

	/*
	 Given a string, return the string made of its first two chars, so the String "Hello" yields "He". If the 
	 string is shorter than length 2, return whatever there is, so "X" yields "X", and the empty string "" 
	 yields the empty string "". Note that str.length() returns the length of a string.
	 firstTwo("Hello") → "He"
	 firstTwo("abcdefg") → "ab"
	 firstTwo("ab") → "ab"
	 */
	public String firstTwo(String str) {
		if (str.length() < 1){
			return "";
		} else if (str.length() < 2) {
			String copyOfFirstChar = str.substring(0, 1);
			return copyOfFirstChar;
		} else {
		String copyOfFirst2Chars = str.substring(0, 2);
		return copyOfFirst2Chars;
		}
		
	}

	/*
	 Given a string of even length, return the first half. So the string "WooHoo" yields "Woo".
	 firstHalf("WooHoo") → "Woo"
	 firstHalf("HelloThere") → "Hello"
	 firstHalf("abcdef") → "abc"
	 */
	public String firstHalf(String str) {
		String firstHalf = str.substring(0, (str.length() / 2));
		return firstHalf;
	}

	/*
	 Given a string, return a version without the first and last char, so "Hello" yields "ell". 
	 The string length will be at least 2.
	 withoutEnd("Hello") → "ell"
	 withoutEnd("java") → "av"
	 withoutEnd("coding") → "odin"
	 */
	public String withoutEnd(String str) {
		String withoutEnd = str.substring( 1, (str.length() -1));
		return withoutEnd;
	}
	
	/*
	 Given 2 strings, a and b, return a string of the form short+long+short, with the shorter string 
	 on the outside and the longer string on the inside. The strings will not be the same length, but 
	 they may be empty (length 0).
	 comboString("Hello", "hi") → "hiHellohi"
	 comboString("hi", "Hello") → "hiHellohi"
	 comboString("aaa", "b") → "baaab"
	 */
	public String comboString(String a, String b) {
		if (a.length() > b.length()){
			return b + a + b;
		}else 
		
		return a + b + a;
	}
	
	/*
	 Given 2 strings, return their concatenation, except omit the first char of each. The strings will 
	 be at least length 1.
	 nonStart("Hello", "There") → "ellohere"
	 nonStart("java", "code") → "avaode"
	 nonStart("shotl", "java") → "hotlava"
	 */
	public String nonStart(String a, String b) {
		String nonStart = a.substring(1) + b.substring(1);
		return nonStart;
	}

	/*
	 Given a string, return a "rotated left 2" version where the first 2 chars are moved to the end. 
	 The string length will be at least 2.
	 left2("Hello") → "lloHe"
	 left2("java") → "vaja"
	 left2("Hi") → "Hi"
	 */
	public String left2(String str) {
		String left2 = str.substring(2) + str.substring(0, 2);
		
		return left2;
	}

	/*
	 Given a string, return a "rotated right 2" version where the last 2 chars are moved to the start. 
	 The string length will be at least 2.
	 right2("Hello") → "loHel"
	 right2("java") → "vaja"
	 right2("Hi") → "Hi"
	 */
	public String right2(String str) {
		String right2 = str.substring( (str.length() -2), str.length()) + str.substring(0, (str.length() -2));
		return right2;
	}

	/*
	 Given a string, return a string length 1 from its front, unless front is false, in which case 
	 return a string length 1 from its back. The string will be non-empty.
	 theEnd("Hello", true) → "H"
	 theEnd("Hello", false) → "o"
	 theEnd("oh", true) → "o"
	 */
	public String theEnd(String str, boolean front) {
		if (front){
			String theFront = str.substring(0,1);
			return theFront;
		}else{
			String theEnd = str.substring((str.length() - 1), str.length() );
		return theEnd;
		}
	}

	/*
	 Given a string, return a version without both the first and last char of the string. The string 
	 may be any length, including 0.
	 withouEnd2("Hello") → "ell"
	 withouEnd2("abc") → "b"
	 withouEnd2("ab") → ""
	 */
	public String withouEnd2(String str) {
		if (str.length() < 3){
			return "";
		} else {
			String withoutEnd2 = str.substring(1, (str.length() -1));
		
		return withoutEnd2;
		}
	}

	/*
	 Given a string of even length, return a string made of the middle two chars, so the string "string" 
	 yields "ri". The string length will be at least 2.
	 middleTwo("string") → "ri"
	 middleTwo("code") → "od"
	 middleTwo("Practice") → "ct"
	 */
	public String middleTwo(String str) {
		String middleTwo = str.substring(((str.length() /2) -1), ((str.length() /2) +1));
		return middleTwo;
	}

	/*
	 Given a string, return true if it ends in "ly".
	 endsLy("oddly") → true
	 endsLy("y") → false
	 endsLy("oddy") → false
	 */
	public boolean endsLy(String str) {
	
		if (str.length() < 2){
			return false;
		} else if(str.substring(str.length() - 2 ).equals("ly")){
		return true;
	} 
		else{
			return false;
		}
	}

	/*
	 Given a string and an int n, return a string made of the first and last n chars from the string. The 
	 string length will be at least n.
	 nTwice("Hello", 2) → "Helo"
	 nTwice("Chocolate", 3) → "Choate"
	 nTwice("Chocolate", 1) → "Ce"
	 */
	public String nTwice(String str, int n) {
		String nTwiceFront = str.substring(0, 0 + n);
		String nTwiceBack = str.substring(str.length() - n);
		return nTwiceFront + nTwiceBack;
	}

	/*
	 Given a string and an index, return a string length 2 starting at the given index. If the index is 
	 too big or too small to define a string length 2, use the first 2 chars. The string length will be 
	 at least 2.
	 twoChar("java", 0) → "ja"
	 twoChar("java", 2) → "va"
	 twoChar("java", 3) → "ja"
	 */
	public String twoChar(String str, int index) {
		
	int strLength = str.length();
	
	if (index >= 0 && (index + 2 <= strLength)){
		return str.substring(index, index + 2);
		
	} else {
		return str.substring(0, 2);
	
	}
	}
	/*
	 Given a string of odd length, return the string length 3 from its middle, so "Candy" yields "and". 
	 The string length will be at least 3.
	 middleThree("Candy") → "and"
	 middleThree("and") → "and"
	 middleThree("solving") → "lvi"
	 */
	public String middleThree(String str) {
		String middleThree = str.substring(((str.length() /2) -1), ((str.length() /2) +2));
		
		return middleThree;
		
	}

	/*
	 Given a string, return true if "bad" appears starting at index 0 or 1 in the string, such as with 
	 "badxxx" or "xbadxx" but not "xxbadxx". The string may be any length, including 0. Note: use .equals()
	 to compare 2 strings.
	 hasBad("badxx") → true
	 hasBad("xbadxx") → true
	 hasBad("xxbadxx") → false
	 */
	public boolean hasBad(String str) {
		if (str.length() >= 4){
			return ((str.substring(0, 3).equals("bad")) || (str.substring(1, 4).equals("bad")));
		} else if(str.length() == 3){
			return (str.substring(0, 3).equals("bad"));
		}else {
			return false;
		}
		}
	

	/*
	 Given a string and a non-negative int n, return a larger string that is n copies of the original string.
	 stringTimes("Hi", 2) → "HiHi"
	 stringTimes("Hi", 3) → "HiHiHi"
	 stringTimes("Hi", 1) → "Hi"
	 */
	public String stringTimes(String str, int n) {
		String stringTimes = "";
		for (;n > 0; n--){
			stringTimes = stringTimes + str;
		}
		
		return stringTimes;
	}

	/*
	 Given a string and a non-negative int n, we'll say that the front of the string is the first 3 chars, or 
	 whatever is there if the string is less than length 3. Return n copies of the front;
	 frontTimes("Chocolate", 2) → "ChoCho"
	 frontTimes("Chocolate", 3) → "ChoChoCho"
	 frontTimes("Abc", 3) → "AbcAbcAbc"
	 */
	public String frontTimes(String str, int n) {
		String frontTimes = "";
		//for (; n > 0; n--){
		if (str.length() == 0){
			return "";
			
		} else if (str.length() == 1){
			for (int i = 0; i < n; i++){
			frontTimes = frontTimes + str.substring(0, 1);
			}
		} else if (str.length() == 2){
			for (int i = 0; i < n; i++){
			frontTimes = frontTimes + str.substring(0, 2);
			}
		} else {//(str.length() >= 3){
			for (int i = 0; i < n; i++){
			frontTimes = frontTimes + str.substring(0, 3);
			}
		}	
		//}
		return frontTimes;
	}

	/*
	 Count the number of "xx" in the given string. We'll say that overlapping is allowed, so "xxx" contains 2 "xx".
	 countXX("abcxx") → 1
	 countXX("xxx") → 2
	 countXX("xxxx") → 
	 */
	public int countXX(String str) {
		int count = 0;
		for (int i = 0; i < (str.length() -1); i++){
			if (str.substring(i, (i + 2)).equals("xx")){
				count = count + 1;
			}
			
		}
		return count;
	}

	/*
	 Given a string, return true if the first instance of "x" in the string is immediately followed by another "x".
	 doubleX("axxbb") → true
	 doubleX("axaxax") → false
	 doubleX("xxxxx") → true
	 */
	public boolean doubleX(String str) {
		
		for (int i = 0; i < (str.length() -1); i++){
			if (str.substring(i, i + 1).equals("x") && (str.substring(i, (i + 2)).equals("xx"))){
				if (!(str.substring(0, i)).contains("x")){
		
			return true;
				}
			}		
		}
		return false;
		
	}
	
	/*
	 Given a string, return a new string made of every other char starting with the first, so "Hello" yields "Hlo".
	 stringBits("Hello") → "Hlo"
	 stringBits("Hi") → "H"
	 stringBits("Heeololeo") → "Hello"
	 */
	public String stringBits(String str) {
		String stringBits = "";
		for (int i = 0; i < str.length(); i = i + 2){
			stringBits = stringBits + str.substring(i, i + 1);
		}
		return stringBits;
	}

	/*
	 Given a non-empty string like "Code" return a string like "CCoCodCode".
	 stringSplosion("Code") → "CCoCodCode"
	 stringSplosion("abc") → "aababc"
	 stringSplosion("ab") → "aab"
	 */
	public String stringSplosion(String str) {
		String stringSplosion = "";
		for (int i = 0; i < str.length(); i++) {
			
			stringSplosion = stringSplosion + str.substring(0, i + 1);
		}
		return stringSplosion;
	}

	/*
	 Given a string, return the count of the number of times that a substring length 2 appears in the string and 
	 also as the last 2 chars of the string, so "hixxxhi" yields 1 (we won't count the end substring).
	 last2("hixxhi") → 1
	 last2("xaxxaxaxx") → 1
	 last2("axxxaaxx") → 2
	 */
	public int last2(String str) {
		int count = 0;
		
		if (str.length() < 3){
			return count;
		}else{
		String last2 = str.substring(str.length() - 2, str.length());
		
		for (int i = 0; i < str.length() -2; i++ ){
			if (str.substring(i, i + 2).equals(last2)){
				count = count + 1;
			}
		}
		}
		return count;
	}

	/*
	 Given a string, return a version where all the "x" have been removed. Except an "x" at the very start or end 
	 should not be removed.
	 stringX("xxHxix") → "xHix"
	 stringX("abxxxcd") → "abcd"
	 stringX("xabxxxcdx") → "xabcdx"
	 */
	public String stringX(String str) {
		String stringX = "";
		
		
		
		if (str.length() <= 1) {
			return str;
		} else {
			stringX += str.charAt(0);
			for (int i = 1; i < str.length() -1; i++){
				if (str.charAt(i) != 'x'){
					stringX = stringX + str.charAt(i);				
				}
			}	
			
		}
		stringX += str.charAt(str.length()-1);
			
			return stringX;
	}

	/*
	 Given a string, return a string made of the chars at indexes 0,1, 4,5, 8,9 ... so "kittens" yields "kien".
	 altPairs("kitten") → "kien"
	 altPairs("Chocolate") → "Chole"
	 altPairs("CodingHorror") → "Congrr"
	 */
	public String altPairs(String str) {
		String altPairs = "";
		
		//altPairs += str.charAt(0);
		//altPairs += str.charAt(1);
		
        for (int i = 0; i < str.length(); i += 4)	{
        	
        	altPairs += str.charAt(i );
        	
        		if (i + 1 >= str.length()){
        			return altPairs;
        		}
        	
    		altPairs += str.charAt(i + 1);
    			
        }
	
		return altPairs;
	}

	/*
	 Suppose the string "yak" is unlucky. Given a string, return a version where all the "yak" are removed, but 
	 the "a" can be any char. The "yak" strings will not overlap.
	 stringYak("yakpak") → "pak"
	 stringYak("pakyak") → "pak"
	 stringYak("yak123ya") → "123ya"
	 */
	public String stringYak(String str) {
		
		
		
		return str.replace("yak", "");
	}
	
}
