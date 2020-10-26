package com.example.CountryService.service.serviceImplementation;

import com.example.CountryService.model.Country;
import com.example.CountryService.model.CountryResponse;
import com.example.CountryService.model.convertor.ResponseConverter;
import com.example.CountryService.service.CountryConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CountryConsumerServiceImpl implements CountryConsumerService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${countries.endpoint}")
    private String resource;

    private static String ENDPOINT_SUB_STRING_ALL_COUNTRIES = "all";
    private static String ENDPOINT_SUB_STRING_SEARCH_BY_NAME = "name/";


    @Override
    public List<Country> getEuropeanCountries() {
        List<CountryResponse> countries = Arrays.stream(Objects.requireNonNull(
                restTemplate.getForObject(resource.concat(ENDPOINT_SUB_STRING_ALL_COUNTRIES),
                        CountryResponse[].class))).collect(Collectors.toList());
        return ResponseConverter.convertResponse(countries);
    }

    @Override
    public Country getEuropeanCountryWithName(String name) {
        CountryResponse countryResponse = Arrays.stream(Objects.requireNonNull(
                restTemplate.getForObject(resource.concat(ENDPOINT_SUB_STRING_SEARCH_BY_NAME).concat(name),
                        CountryResponse[].class))).collect(Collectors.toList()).get(0);
        return ResponseConverter.convertResponse(countryResponse);
    }


}
