//: com.amdocs.neoclient.domain.services.NeoServiceIT.java


package com.amdocs.neoclient.domain.services;


import com.amdocs.neoclient.domain.model.Neo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class NeoServiceIT {

	@Autowired
	private INeoService neoService;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void able_To_Get_Neos_For_Today() throws Exception {

		// Given

		// When
		List<Neo> neos = this.neoService.getNeosForToday();

        // Then
		assertThat(neos.size(), greaterThan(0));
	}

}///:~