package com.wisdomleaf.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.format.DateTimeParseException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpeakingClockServiceTests {

	@Autowired
	private SpeakingClockService speakingClockService;
	
	@Test
	void convertTimeToWords_validTime() {
		assertEquals("It's Midnight", speakingClockService.convertTimeToWords("00:00").getBody());
		assertEquals("It's Midday", speakingClockService.convertTimeToWords("12:00").getBody());
		assertEquals("It's twenty three hour fifty nine minutes.", speakingClockService.convertTimeToWords("23:59").getBody());
		assertEquals("It's zero hour one minutes.", speakingClockService.convertTimeToWords("00:01").getBody());
	}
	
	@Test
	void convertTimeToWords_inValidTime() {
		assertThrows(DateTimeParseException.class, () -> speakingClockService.convertTimeToWords("abcd"));
		assertThrows(DateTimeParseException.class, () -> speakingClockService.convertTimeToWords("24:60"));
	}

}
