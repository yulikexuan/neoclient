//: com.amdocs.neoclient.domain.services.INeoService.java


package com.amdocs.neoclient.domain.services;


import com.amdocs.neoclient.domain.model.Neo;

import java.util.List;


public interface INeoService {

	List<Neo> getNeosForToday();

}///:~