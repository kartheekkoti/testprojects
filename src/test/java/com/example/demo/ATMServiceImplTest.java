package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.consumer.ATMConsumer;
import com.example.demo.model.ATM;
import com.example.demo.model.Address;
import com.example.demo.model.GeoLocation;
import com.example.demo.model.Hours;
import com.example.demo.model.OpeningHours;
import com.example.demo.service.impl.ATMServiceImpl;

class ATMServiceImplTest {

	@InjectMocks
	ATMServiceImpl atmServices;

	@Mock
	ATMConsumer atmConsumer;

	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetAllATMs() {
		List<ATM> list = List.of(new ATM(
				new Address("Streek", "131", "8463 NG", "Rotsterhaule", new GeoLocation("52.929544", "5.853142")), 0,
				List.of(new OpeningHours(2, List.of(new Hours("08:00", "20:00"), new Hours("08:00", "20:00"))),
						new OpeningHours(3, List.of(new Hours("08:00", "20:00"), new Hours("08:00", "20:00"))),
						new OpeningHours(4, List.of(new Hours("08:00", "20:00"), new Hours("08:00", "20:00"))),
						new OpeningHours(5, List.of(new Hours("08:00", "20:00"), new Hours("08:00", "20:00"))),
						new OpeningHours(6, List.of(new Hours("08:00", "20:00"), new Hours("08:00", "20:00"))),
						new OpeningHours(7, List.of(new Hours("08:00", "20:00"), new Hours("08:00", "17:00"))),
						new OpeningHours(1, List.of(new Hours("08:00", "20:00"), new Hours("08:00", "11:00")))),
				"Geldautomaat", "GELDMAAT"),
				new ATM(new Address("Plein 1992", "52", "6221 JP", "Maastricht",
						new GeoLocation("50.846197", "5.69984")), 0,
						List.of(new OpeningHours(2, List.of(new Hours("08:00", "20:00"), new Hours("08:00", "20:00"))),
								new OpeningHours(3, List.of(new Hours("08:00", "20:00"), new Hours("08:00", "20:00"))),
								new OpeningHours(4, List.of(new Hours("08:00", "20:00"), new Hours("08:00", "20:00"))),
								new OpeningHours(5, List.of(new Hours("08:00", "20:00"), new Hours("08:00", "20:00"))),
								new OpeningHours(6, List.of(new Hours("08:00", "20:00"), new Hours("08:00", "20:00"))),
								new OpeningHours(7, List.of(new Hours("08:00", "20:00"), new Hours("08:00", "17:00"))),
								new OpeningHours(1, List.of(new Hours("08:00", "20:00"), new Hours("08:00", "11:00")))),
						"Geldautomaat", "GELDMAAT"),
				new ATM(new Address("Jonagoldstraat", "57", "8463 NG", "Nijmegen",
						new GeoLocation("52.929544", "5.853142")), 0,
						List.of(new OpeningHours(2, List.of(new Hours("08:00", "20:00"), new Hours("08:00", "20:00"))),
								new OpeningHours(3, List.of(new Hours("08:00", "20:00"), new Hours("08:00", "20:00"))),
								new OpeningHours(4, List.of(new Hours("08:00", "20:00"), new Hours("08:00", "20:00"))),
								new OpeningHours(5, List.of(new Hours("08:00", "20:00"), new Hours("08:00", "20:00"))),
								new OpeningHours(6, List.of(new Hours("08:00", "20:00"), new Hours("08:00", "20:00"))),
								new OpeningHours(7, List.of(new Hours("08:00", "20:00"), new Hours("08:00", "17:00"))),
								new OpeningHours(1, List.of(new Hours("08:00", "20:00"), new Hours("08:00", "11:00")))),
						"Geldautomaat", "GELDMAAT"));

		when(atmConsumer.findAllATMs()).thenReturn(list);
		List<ATM> atmList = atmServices.getAllATMs();
		assertEquals(3, atmList.size());
	}

	@Test
	void testFilterByCity() {
		List<ATM> list = List.of(
				new ATM(new Address("Streek", "131", "8463 NG", "Nijmegen", new GeoLocation("52.929544", "5.853142")),
						0,
						List.of(new OpeningHours(2, List.of(new Hours("08:00", "20:00"), new Hours("08:00", "20:00"))),
								new OpeningHours(3, List.of(new Hours("08:00", "20:00"), new Hours("08:00", "20:00"))),
								new OpeningHours(4, List.of(new Hours("08:00", "20:00"), new Hours("08:00", "20:00"))),
								new OpeningHours(5, List.of(new Hours("08:00", "20:00"), new Hours("08:00", "20:00"))),
								new OpeningHours(6, List.of(new Hours("08:00", "20:00"), new Hours("08:00", "20:00"))),
								new OpeningHours(7, List.of(new Hours("08:00", "20:00"), new Hours("08:00", "17:00"))),
								new OpeningHours(1, List.of(new Hours("08:00", "20:00"), new Hours("08:00", "11:00")))),
						"Geldautomaat", "GELDMAAT"),
				new ATM(new Address("Jonagoldstraat", "57", "8463 NG", "Nijmegen",
						new GeoLocation("52.929544", "5.853142")), 0,
						List.of(new OpeningHours(2, List.of(new Hours("08:00", "20:00"), new Hours("08:00", "20:00"))),
								new OpeningHours(3, List.of(new Hours("08:00", "20:00"), new Hours("08:00", "20:00"))),
								new OpeningHours(4, List.of(new Hours("08:00", "20:00"), new Hours("08:00", "20:00"))),
								new OpeningHours(5, List.of(new Hours("08:00", "20:00"), new Hours("08:00", "20:00"))),
								new OpeningHours(6, List.of(new Hours("08:00", "20:00"), new Hours("08:00", "20:00"))),
								new OpeningHours(7, List.of(new Hours("08:00", "20:00"), new Hours("08:00", "17:00"))),
								new OpeningHours(1, List.of(new Hours("08:00", "20:00"), new Hours("08:00", "11:00")))),
						"Geldautomaat", "GELDMAAT"));

		when(atmConsumer.findATMsByCity(anyString())).thenReturn(list);
		List<ATM> atmList = atmServices.filterByCity(anyString());
		assertEquals("Nijmegen", atmList.get(1).getAddress().getCity());
		
	}
}
