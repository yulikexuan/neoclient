//: com.amdocs.neoclient.domain.model.Neo.java


package com.amdocs.neoclient.domain.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class Neo {

	public static final String UNKNOWN_NEO_NAME = "Unknown_By_YLI";

	private String neoReferenceId;

	private String name = UNKNOWN_NEO_NAME;

	private double absoluteMagnitudeH;

	private boolean isPotentiallyHazardousAsteroid;

	private EstimatedDiameter estimatedDiameter;

	private List<CloseApproachData> closeApproachData = new ArrayList<>();

	public Double getEstimatedDiameterMaxKilo() {
		return Optional.ofNullable(this.estimatedDiameter)
				.map(EstimatedDiameter::getEstimatedDiameterMaxKilo)
				.orElseGet(() -> new Double(0));
	}

	public Long getMissDistanceInKilo() {
		return Optional.ofNullable(this.closeApproachData.get(0))
				.map(CloseApproachData::getMissDistanceInKilo)
				.orElseGet(() -> Long.MAX_VALUE);
	}

}///:~