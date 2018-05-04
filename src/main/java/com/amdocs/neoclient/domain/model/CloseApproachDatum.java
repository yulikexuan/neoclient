//: com.amdocs.neoclient.domain.model.CloseApproachDatum.java


package com.amdocs.neoclient.domain.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
public class CloseApproachDatum {

	private Date closeApproachDate;
	private long epochDateCloseApproach;
	private String orbitingBody;

	private RelativeVelocity relativeVelocity;
	private MissDistance missDistance;

}///:~