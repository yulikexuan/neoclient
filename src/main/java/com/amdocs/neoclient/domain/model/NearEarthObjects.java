//: com.amdocs.neoclient.domain.model.NearEarthObjects.java


package com.amdocs.neoclient.domain.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Getter
@Setter
@NoArgsConstructor
public class NearEarthObjects {

	private Map<Date, List<Neo>> neos = new HashMap<>();

}///:~