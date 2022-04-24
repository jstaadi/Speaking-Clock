package com.wisdomleaf.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wisdomleaf.test.service.SpeakingClockService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class SpeakingClockController {

	@Autowired
	private SpeakingClockService speakingClockService;

	@Operation(summary = "Tells the time in words")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Conversion completed successsfully"),
            @ApiResponse(responseCode = "400", description = "Invalid time") }) 
    
	@PostMapping("/tellTime")
	public ResponseEntity<String> timeForm(@Parameter(description = "Time to be converted") @RequestBody String time) {
		return speakingClockService.convertTimeToWords(time);
	}


}
