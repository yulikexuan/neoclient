//: com.amdocs.neoclient.domain.services.INeoService.java


package com.amdocs.neoclient.domain.services;


import com.amdocs.neoclient.domain.model.Neo;

import java.util.List;
import java.util.Optional;


public interface INeoService {

	Optional<List<Neo>> getNeosForToday();
	Optional<Integer> getNeosNumber();
	Optional<Neo> getLargestNeo();
	Optional<Neo> getClosestNeo();

}///:~