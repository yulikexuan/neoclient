//: com.amdocs.neoclient.domain.services.NeoServiceIT.java


package com.amdocs.neoclient.domain.services;


import com.amdocs.neoclient.domain.model.Neo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class NeoServiceIT {

	@Autowired
	private INeoService neoService;

	private Neo unknownNeo = new Neo();

	@Before
	public void setUp() throws Exception {
		this.unknownNeo = new Neo();
	}

	@Test
	public void able_To_Get_Neos_For_Today() throws Exception {

		// Given

		// When & Then
		this.neoService.getNeosForToday()
				.ifPresent(list -> assertThat(list.size(),
						greaterThan(0)));
	}

	@Test
	public void able_To_Know_How_Many_Neos_We_Have_Today() throws Exception {

		// When & Then
		this.neoService.getNeosNumber().ifPresent(number ->
				assertThat(number, greaterThan(0)));
	}

	@Test
	public void able_To_Know_The_Largest_Neo_Today() throws Exception {

		// Give

		// When & Then
		this.neoService.getLargestNeo()
				.ifPresent(neo -> assertThat(neo.getName(), notNullValue()));
	}

	@Test
	public void able_To_Known_Which_Neo_Is_The_Closest_To_Us_Today() throws Exception {

		// Given

		// When & Then
		this.neoService.getClosestNeo()
				.ifPresent(neo -> assertThat(neo, notNullValue()));
	}

}///:~