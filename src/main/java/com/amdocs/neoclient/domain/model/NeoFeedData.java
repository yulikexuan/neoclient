//: com.amdocs.neoclient.domain.model.NeoFeedData.java


package com.amdocs.neoclient.domain.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Getter
@Setter
@NoArgsConstructor
public class NeoFeedData {

	private int elementCount;
	private Map<String, List<Neo>> nearEarthObjects;

	public List<Neo> getNeosForToday() {
		return this.nearEarthObjects.values()
				.stream()
				.findAny()
				.orElseGet(ArrayList::new);
	}

}///:~