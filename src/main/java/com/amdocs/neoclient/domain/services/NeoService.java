//: com.amdocs.neoclient.domain.services.NeoService.java


package com.amdocs.neoclient.domain.services;


import com.amdocs.neoclient.domain.model.Neo;
import com.amdocs.neoclient.domain.model.NeoFeedData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class NeoService implements INeoService {

	private final String api_uri_neofeed_today;
	private final String api_key_name;
	private final String api_key_value;
	private final RestTemplate restTemplate;

	@Autowired
	public NeoService(RestTemplate restTemplate,
	                  @Value("${api.uri.neofeedtoday}") String api_uri_neofeed_today,
	                  @Value("${api.key.name}") String api_key_name,
	                  @Value("${api.key.value}") String api_key_value) {

		this.restTemplate = restTemplate;

		this.api_uri_neofeed_today = api_uri_neofeed_today;
		this.api_key_name = api_key_name;
		this.api_key_value = api_key_value;
	}

	@Override
	public Optional<List<Neo>> getNeosForToday() {

		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
				.fromUriString(this.api_uri_neofeed_today)
				.queryParam(this.api_key_name, this.api_key_value);

		String uriStr = uriComponentsBuilder.toUriString();
		log.debug(">>>>>>> The uri to get today's neos: " + uriStr);

		try {
			NeoFeedData neoFeedData = this.restTemplate.getForObject(uriStr,
					NeoFeedData.class);
			return Optional.of(neoFeedData.getNeosForToday());
		} catch (RestClientException e) {
			log.debug(e.getMessage());
			return Optional.empty();
		}
	}

	@Override
	public Optional<Integer> getNeosNumber() {
		return this.getNeosForToday().map(list -> list.size());
	}


	@Override
	public Optional<Neo> getLargestNeo() {
		return this.getNeosForToday()
				.orElseGet(ArrayList::new)
				.stream()
				.max(Comparator.comparing(Neo::getEstimatedDiameterMaxKilo));
	}

	@Override
	public Optional<Neo> getClosestNeo() {
		return this.getNeosForToday()
				.orElseGet(ArrayList::new)
				.stream()
				.max(Comparator.comparing(Neo::getMissDistanceInKilo));
	}

}///:~