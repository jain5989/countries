package com.example.CountryService.service.serviceImplementation;

import com.example.CountryService.model.Country;
import com.example.CountryService.model.CountryResponse;
import com.example.CountryService.model.convertor.ResponseConverter;
import com.example.CountryService.service.CountryConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class CountryConsumerServiceImpl implements CountryConsumerService {



    private final WebClient client;

    @Autowired
    public CountryConsumerServiceImpl(WebClient.Builder builder) {
        client = builder.baseUrl("https://restcountries.eu/rest/v2/").build();
    }


    private static String ENDPOINT_SUB_STRING_ALL_COUNTRIES = "all";
    private static String ENDPOINT_SUB_STRING_SEARCH_BY_NAME = "name/";


    @Override
    public Flux<Country> getAllCountries() {
        return client.get()
                .uri(uriBuilder -> uriBuilder.path(ENDPOINT_SUB_STRING_ALL_COUNTRIES)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(CountryResponse.class)
                .map(ResponseConverter::convertResponse
                );
    }


    @Override
    public Flux<Country> getCountryDetailsWithName(String name) {
        return client.get()
                .uri(uriBuilder -> uriBuilder.path(ENDPOINT_SUB_STRING_SEARCH_BY_NAME.concat(name))
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(CountryResponse.class)
                .map(ResponseConverter::convertResponse);
    }


}
