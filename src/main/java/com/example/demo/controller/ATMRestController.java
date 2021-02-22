package com.example.demo.controller;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.NOATMFoundException;
import com.example.demo.model.ATM;
import com.example.demo.service.IATMServices;

@Validated
@RestController
@RequestMapping("/atm-api")
public class ATMRestController {

	@Autowired
	private IATMServices atmServices;
	
	/*
	 * A resource for returning all the ATMS.
	 * @param : No parameters required
	 * @return : Returns all the ATMs as List
	 */

	@GetMapping("/all")
	public ResponseEntity<?> getAllATMs() {
		ResponseEntity<?> responce = null;
		List<ATM> obj = atmServices.getAllATMs();
			if (!obj.isEmpty()) {
				responce = new ResponseEntity<>(obj, HttpStatus.OK);
			} else {
				throw new NOATMFoundException();
			}
		return responce;
	}
	
	/*
	 * A resource for returning all the ATMS in a City.
	 * @param : requred city of type String as parameter
	 * @return : Returns all the ATMs present in the City
	 */

	@GetMapping("/filterByCity")
	public ResponseEntity<?> getAllAtmsInOneCity(
			@RequestParam("city") @NotBlank @Pattern(regexp = "^[a-zA-Z0-9.\\\\-\\\\/+=@_ ]*$") @Size(min=3) String city) {
		ResponseEntity<?> response = null;
		List<ATM> obj = atmServices.filterByCity(city);
		if (!obj.isEmpty()) {
			response = new ResponseEntity<>(obj, HttpStatus.OK);
		} else {
			throw new NOATMFoundException(new Throwable("EMPTY RESULT"));
		}
		return response;
	}
}
