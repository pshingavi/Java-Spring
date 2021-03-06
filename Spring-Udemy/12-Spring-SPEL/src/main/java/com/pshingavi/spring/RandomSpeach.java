package com.pshingavi.spring;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component("randomSpeach")
public class RandomSpeach {

	private static String [] speachTextArray = {
			"speach 1",
			"speach 2",
			"speach 3",
			null
	};
	
	public String generateRandomSpeach() {
		Random random = new Random();
		return speachTextArray[random.nextInt(speachTextArray.length)];
	}
}
