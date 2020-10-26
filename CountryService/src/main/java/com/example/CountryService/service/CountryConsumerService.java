package com.example.CountryService.service;

import com.example.CountryService.model.Country;

import java.util.List;

public interface CountryConsumerService {

    List<Country> getEuropeanCountries();

    Country getEuropeanCountryWithName(String name);
}
