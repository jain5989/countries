package com.example.CountryService.controller;

import com.example.CountryService.model.Country;
import com.example.CountryService.service.CountryConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController("/")
public class CountryController {

    @Autowired
    CountryConsumerService countryConsumerService;

    @GetMapping("countries/")
    public Flux<Country> getCountries() {
        return countryConsumerService.getAllCountries();
    }


    @GetMapping("countries/{name}")
    public Flux<Country> getCountriesWithName(@PathVariable("name")  String name) {
        return countryConsumerService.getCountryDetailsWithName(name);
    }

}
