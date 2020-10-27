package com.example.CountryService.service;

import com.example.CountryService.model.Country;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CountryConsumerService {

    Flux<Country> getAllCountries();

    Flux<Country> getCountryDetailsWithName(String name);
}
