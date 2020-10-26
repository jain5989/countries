package com.example.CountryService.model.convertor;

import com.example.CountryService.model.Country;
import com.example.CountryService.model.CountryResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ResponseConverter {

    public static Country convertResponse(CountryResponse countryResponse) {
        return new Country(countryResponse.getName(),
                countryResponse.getAlpha2Code(),
                countryResponse.getCapital(),
                countryResponse.getPopulation(),
                countryResponse.getFlag());
    }

    public static List<Country> convertResponse(List<CountryResponse> countryResponse) {
        return countryResponse.stream().map(countryResponse1 ->
                new Country(countryResponse1.getName(),
                        countryResponse1.getAlpha2Code(),
                        countryResponse1.getCapital(),
                        countryResponse1.getPopulation(),
                        countryResponse1.getFlag())
        ).collect(Collectors.toList());
    }
}
