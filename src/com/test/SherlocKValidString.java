package com.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SherlocKValidString {
	public static void main(String[] args) {
		System.out.println(isValid("aabbcd"));
	}

	public static String isValid(String s) {
		if(s.trim().isEmpty()) {
			return "YES";
		}
		char[] letters = s.toCharArray();
		Map<Character, Long> letterMap = new HashMap<>();
		Map<Long, Long> counterMaps =  new HashMap<>();
		long counter;
		for (char letter : letters) {
			counter = 0;
			if (letterMap.containsKey(letter)) {
				counter = letterMap.get(letter);
			}
			letterMap.put(letter, ++counter);

		}
		for (long c : letterMap.values()) {
			long counterMapVal =0;
			if(counterMaps.containsKey(c)) {
				counterMapVal = counterMaps.get(c);
			}
			counterMaps.put(c, ++counterMapVal);


		}
		if(counterMaps.size()==1) {
			return "YES";
		}if(counterMaps.size() > 2) {
			return "NO";
		}
		if(counterMaps.size() == 2) {
			List<Long> values = counterMaps.values().stream().collect(Collectors.toList());
			if(values.get(0)  == 1 || values.get(1) ==1 ) {
				return "YES";
			}
		}
		return "NO";
	}
}
