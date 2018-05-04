//: com.amdocs.neoclient.domain.services.NeoService.java


package com.amdocs.neoclient.domain.services;


import com.amdocs.neoclient.domain.model.Neo;
import com.amdocs.neoclient.domain.model.NeoFeedData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@Slf4j
@Service
public class NeoService implements INeoService {

	private final String api_uri_neofeed;
	private final String api_key_name;
	private final String api_key_value;
	private final RestTemplate restTemplate;

	@Autowired
	public NeoService(RestTemplate restTemplate,
	                  @Value("${api.uri.neofeed}") String api_uri_neofeed,
	                  @Value("${api.key.name}") String api_key_name,
	                  @Value("${api.key.value}") String api_key_value) {

		this.restTemplate = restTemplate;

		this.api_uri_neofeed = api_uri_neofeed;
		this.api_key_name = api_key_name;
		this.api_key_value = api_key_value;
	}

	@Override
	public List<Neo> getNeosForToday() {

		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
				.fromUriString(this.api_uri_neofeed)
				.queryParam(this.api_key_name, this.api_key_value);

		String uriStr = uriComponentsBuilder.toUriString();
		log.debug(">>>>>>> The uri to get today's neos: " + uriStr);

		NeoFeedData neoFeedData = this.restTemplate.getForObject(uriStr,
				NeoFeedData.class);

		List<Neo> neosToday = neoFeedData.getNeosForToday();

		return neosToday;
	}

}///:~