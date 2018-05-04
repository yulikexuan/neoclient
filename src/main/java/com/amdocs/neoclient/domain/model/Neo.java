//: com.amdocs.neoclient.domain.model.Neo.java


package com.amdocs.neoclient.domain.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class Neo {

	private String neoReferenceId;

	private String name;

	private double absoluteMagnitudeH;

	private boolean isPotentiallyHazardousAsteroid;

	private EstimatedDiameter estimatedDiameter;

	private CloseApproachDatum closeApproachDatum;

}///:~