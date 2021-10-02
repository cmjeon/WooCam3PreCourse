package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class StringClass {
	
	/*
	 * String 을 Array 로 분리하는 메소드
	 */
	public List<String> separateStringToArray(String str) {
		List<String> result = new ArrayList<String>();
		result = Arrays.asList(str.split(","));
		return result;
	}
	
	/*
	 * String 에서 괄호를 제거하는 메소드 
	 */
	public String removeParenthesesFromString(String str) throws StringIndexOutOfBoundsException{
		String result = str.substring(str.indexOf("(")+1, str.indexOf(")"));
		return result;
	}

	public char getCharFromString(String str, int i) {
		char result = '\0';
		try {
			result = str.charAt(i);
			
		} catch(StringIndexOutOfBoundsException e) {
			throw new StringIndexOutOfBoundsException("Index: "+ i +", Size: " + str.length());
		}
		return result;
	}
}
