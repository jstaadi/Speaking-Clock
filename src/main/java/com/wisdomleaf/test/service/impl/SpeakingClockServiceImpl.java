package com.wisdomleaf.test.service.impl;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wisdomleaf.test.service.SpeakingClockService;

@Service
public class SpeakingClockServiceImpl implements SpeakingClockService {

	public static final Map<Integer, String> TIME_WORDS = new HashMap<>();

	static {
		TIME_WORDS.put(0, "zero");
		TIME_WORDS.put(1, "one");
		TIME_WORDS.put(2, "two");
		TIME_WORDS.put(3, "three");
		TIME_WORDS.put(4, "four");
		TIME_WORDS.put(5, "five");
		TIME_WORDS.put(6, "six");
		TIME_WORDS.put(7, "seven");
		TIME_WORDS.put(8, "eight");
		TIME_WORDS.put(9, "nine");
		TIME_WORDS.put(10, "ten");
		TIME_WORDS.put(11, "eleven");
		TIME_WORDS.put(12, "twelve");
		TIME_WORDS.put(13, "thirteen");
		TIME_WORDS.put(14, "fourteen");
		TIME_WORDS.put(15, "fifteen");
		TIME_WORDS.put(16, "sixteen");
		TIME_WORDS.put(17, "seventeen");
		TIME_WORDS.put(18, "eighteen");
		TIME_WORDS.put(19, "nineteen");
		TIME_WORDS.put(20, "twenty");
		TIME_WORDS.put(21, "twenty one");
		TIME_WORDS.put(22, "twenty two");
		TIME_WORDS.put(23, "twenty three");
		TIME_WORDS.put(30, "thirty");
		TIME_WORDS.put(40, "forty");
		TIME_WORDS.put(50, "fifty");
	}

	@Override
	public ResponseEntity<String> convertTimeToWords(String time) {

		LocalTime localTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
		StringBuilder wordTime = null;

		int hour = localTime.getHour();
		int mins = localTime.getMinute();

		if (mins == 0) {
			if (hour == 0)
				wordTime = new StringBuilder("It's Midnight");
			else if (hour == 12)
				wordTime = new StringBuilder("It's Midday");
		} else {
			wordTime = new StringBuilder("It's ");
			wordTime.append(TIME_WORDS.get(hour) + " hour " + ((mins <= 20) ? (TIME_WORDS.get(mins) + " minutes.")
					: ((TIME_WORDS.get((mins / 10) * 10) + " " + TIME_WORDS.get(mins % 10)) + " minutes.")));
		}

		return ResponseEntity.ok().body(wordTime.toString());
	}

}
