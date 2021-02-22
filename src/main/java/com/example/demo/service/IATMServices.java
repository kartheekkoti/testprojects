package com.example.demo.service;

import java.util.List;

import com.example.demo.model.ATM;

public interface IATMServices {

	public List<ATM> getAllATMs();

	public List<ATM> filterByCity(String city);
}
