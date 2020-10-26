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

}
