package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.consumer.ATMConsumer;
import com.example.demo.model.ATM;
import com.example.demo.service.IATMServices;

/*
 * Service methods for ATMs
 */

@Service
public class ATMServiceImpl implements IATMServices {

	@Autowired
	private ATMConsumer atmConsumer;

	// Returns all the ATMs across all the cities.
	public List<ATM> getAllATMs() {
		return atmConsumer.findAllATMs();
	}

	// Returns all the ATMs in a city.
	public List<ATM> filterByCity(String city) {
		return atmConsumer.findATMsByCity(city);
	}
}