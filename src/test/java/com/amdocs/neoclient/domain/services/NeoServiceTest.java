//: com.amdocs.neoclient.domain.services.NeoServiceTest.java


package com.amdocs.neoclient.domain.services;


import com.amdocs.neoclient.domain.model.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;


public class NeoServiceTest {

	private static final String URL =
			"https://api.nasa.gov/neo/rest/v1/feed/today";
	private static final String API_KEY_NAME = "api_key";
	private static final String API_KEY_VALUE = "DEMO_KEY";

	private static final String EXPECTED_URL =
			"https://api.nasa.gov/neo/rest/v1/feed/today?api_key=DEMO_KEY";

	@Mock
	private RestTemplate restTemplate;
	private NeoFeedData neoFeedData;

	private Neo neo1 = new Neo();
	private Neo neo2 = new Neo();
	private Neo neo3 = new Neo();

	private EstimatedDiameter estimatedDiameter1 = new EstimatedDiameter();
	private EstimatedDiameter estimatedDiameter2 = new EstimatedDiameter();
	private EstimatedDiameter estimatedDiameter3 = new EstimatedDiameter();

	private Kilometers kilometers1 = new Kilometers();
	private Kilometers kilometers2 = new Kilometers();
	private Kilometers kilometers3 = new Kilometers();

	private CloseApproachData closeApproachData1 = new CloseApproachData();
	private CloseApproachData closeApproachData2 = new CloseApproachData();
	private CloseApproachData closeApproachData3 = new CloseApproachData();

	private MissDistance missDistance1 = new MissDistance();
	private MissDistance missDistance2 = new MissDistance();
	private MissDistance missDistance3 = new MissDistance();

	private NeoService neoService;

	@Before
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);

		this.kilometers1.setEstimatedDiameterMax(1.1);
		this.kilometers2.setEstimatedDiameterMax(2.2);
		this.kilometers3.setEstimatedDiameterMax(3.3);

		this.estimatedDiameter1.setKilometers(this.kilometers1);
		this.estimatedDiameter2.setKilometers(this.kilometers2);
		this.estimatedDiameter3.setKilometers(this.kilometers3);

		this.missDistance1.setKilometers(4.4);
		this.closeApproachData1.setMissDistance(this.missDistance1);

		this.missDistance2.setKilometers(5.5);
		this.closeApproachData2.setMissDistance(this.missDistance2);

		this.missDistance3.setKilometers(6.6);
		this.closeApproachData3.setMissDistance(this.missDistance3);

		this.neo1.setEstimatedDiameter(this.estimatedDiameter1);
		this.neo1.setCloseApproachData(Arrays.asList(this.closeApproachData1));

		this.neo2.setEstimatedDiameter(this.estimatedDiameter2);
		this.neo2.setCloseApproachData(Arrays.asList(this.closeApproachData2));

		this.neo3.setEstimatedDiameter(this.estimatedDiameter3);
		this.neo3.setCloseApproachData(Arrays.asList(this.closeApproachData3));

		String today = new Date().toString();
		Map<String, List<Neo>> nearEarthObjects = new HashMap<>();
		nearEarthObjects.put(today, Arrays.asList(this.neo1, this.neo2,
				this.neo3));
		this.neoFeedData = new NeoFeedData();
		this.neoFeedData.setNearEarthObjects(nearEarthObjects);

		this.neoService = new NeoService(this.restTemplate,
				URL, API_KEY_NAME, API_KEY_VALUE);

	}// End of setUp()

	@Test
	public void able_To_Get_Neos_For_Today() throws Exception {

		// Given
		given(this.restTemplate.getForObject(EXPECTED_URL, NeoFeedData.class))
				.willReturn(this.neoFeedData);

		// When
		Optional<Integer> optNumber = this.neoService.getNeosNumber();

		// Then
		assertThat(optNumber.get(), is(3));
	}

	@Test
	public void able_To_Know_The_Largest_Neo() throws Exception {

		// Given
		given(this.restTemplate.getForObject(EXPECTED_URL, NeoFeedData.class))
				.willReturn(this.neoFeedData);

		// When
		Optional<Neo> optLargest = this.neoService.getLargestNeo();

		// Then
		assertThat(optLargest.get().getEstimatedDiameterMaxKilo(),
				is(3.3));
	}

	@Test
	public void able_To_Know_The_Closest_Neo() throws Exception {

		// Given
		given(this.restTemplate.getForObject(EXPECTED_URL, NeoFeedData.class))
				.willReturn(this.neoFeedData);

		// When
		Optional<Neo> optCloest = this.neoService.getClosestNeo();

		// Then
		assertThat(optCloest.get().getMissDistanceInKilo(),
				is(4.4));
	}

}///:~