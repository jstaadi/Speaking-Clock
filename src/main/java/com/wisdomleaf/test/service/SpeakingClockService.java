package com.wisdomleaf.test.service;

import org.springframework.http.ResponseEntity;

public interface SpeakingClockService {

	public ResponseEntity<String> convertTimeToWords(String time);

	

}
