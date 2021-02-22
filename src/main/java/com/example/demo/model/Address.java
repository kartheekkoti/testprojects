package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	
    private String street;
    private String housenumber;
    private String postalcode;
    private String city;
    private GeoLocation geoLocation;
}
