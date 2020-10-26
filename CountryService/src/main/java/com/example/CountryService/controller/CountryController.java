package com.example.CountryService.controller;

import com.example.CountryService.model.Country;
import com.example.CountryService.service.CountryConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController("/")
public class CountryController {

    @Autowired
    CountryConsumerService countryConsumerService;

    @GetMapping
    public String smokeTestService() {
        return "Service is working";
    }

    @GetMapping("countries/")
    public List<Country> getCountries() {
        return countryConsumerService.getEuropeanCountries();
    }


    @GetMapping("countries/{name}")
    public Country getCountriesWithName(@PathVariable("name")  String name) {
        return countryConsumerService.getEuropeanCountryWithName(name);
    }

}
