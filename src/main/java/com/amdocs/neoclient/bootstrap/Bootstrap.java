//: com.amdocs.neoclient.bootstrap.Bootstrap.java


package com.amdocs.neoclient.bootstrap;


import com.amdocs.neoclient.domain.services.INeoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {

	private final INeoService neoService;

	@Autowired
	public Bootstrap(INeoService neoService) {
		this.neoService = neoService;
	}

	@Override
	public void run(String... args) {
		this.neoService.getNeosNumber()
				.ifPresent(num -> log.debug(">>>>>>> We have " + num +
						" neos today. Yahoo!!!!!!!"));
		this.neoService.getLargestNeo()
				.ifPresent(neo -> log.debug(">>>>>>> The largest one is " + neo));
		this.neoService.getClosestNeo()
				.ifPresent(neo -> log.debug(">>>>>>> The closest one is " + neo));
	}

}///:~