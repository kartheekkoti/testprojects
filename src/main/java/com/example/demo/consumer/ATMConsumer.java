package com.example.demo.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.ATM;
import com.google.gson.Gson;

/*
 * Class for Communicating with other Services.
 */

@Component
public class ATMConsumer {

	@Autowired
	RestTemplate template;

	@Value("${rest.consumer.url}")
	private String url;

	public List<ATM> findAllATMs() {
		Gson gson = new Gson();
		String result = null;
		result = template.getForObject(url, String.class);
		ATM[] atms = gson.fromJson(result.substring(6), ATM[].class);
		return Arrays.asList(atms);
	}

	public List<ATM> findATMsByCity(String city) {
		List<ATM> filteredATMs = null;
		filteredATMs = findAllATMs().stream().filter(atm -> atm.getAddress().getCity().equalsIgnoreCase(city))
				.collect(Collectors.toList());
		return filteredATMs;
	}

}
