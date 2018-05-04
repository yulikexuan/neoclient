//: com.amdocs.neoclient.domain.model.CloseApproachData.java


package com.amdocs.neoclient.domain.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.Optional;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class CloseApproachData {

	private Date closeApproachDate;
	private long epochDateCloseApproach;
	private String orbitingBody;

	private RelativeVelocity relativeVelocity;
	private MissDistance missDistance;

	public Long getMissDistanceInKilo() {
		return Optional.ofNullable(this.missDistance)
				.map(MissDistance::getKilometers)
				.orElseGet(() -> Long.MAX_VALUE);
	}

}///:~