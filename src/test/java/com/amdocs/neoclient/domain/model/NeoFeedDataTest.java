//: com.amdocs.neoclient.domain.model.NeoFeedDataTest.java


package com.amdocs.neoclient.domain.model;


import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;


public class NeoFeedDataTest {

	private NeoFeedData neoFeedData;

	@Before
	public void setUp() throws Exception {
		this.neoFeedData = new NeoFeedData();
	}

	@Test
	public void neo_List_Should_Not_Be_Null() throws Exception {

		// When
		List<Neo> neos = this.neoFeedData.getNeosForToday();

		// Then
		assertThat(neos, notNullValue());
	}

}///:~