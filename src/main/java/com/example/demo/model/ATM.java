package com.example.demo.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ATM {
	private Address address;
	private Integer distance;
	private List<OpeningHours> openingHours;
	private String functionality;
	private String type;
}
