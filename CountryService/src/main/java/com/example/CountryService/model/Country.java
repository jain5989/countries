package com.example.CountryService.model;

import java.util.Objects;

public class Country {

    String name;
    String countryCode;
    String capital;
    String population;
    String flag;


    public Country(String name, String countryCode, String capital, String population, String flag) {
        this.name = name;
        this.countryCode = countryCode;
        this.capital = capital;
        this.population = population;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }


    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }


    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(name, country.name) &&
                Objects.equals(countryCode, country.countryCode) &&
                Objects.equals(capital, country.capital) &&
                Objects.equals(population, country.population) &&
                Objects.equals(flag, country.flag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, countryCode, capital, population, flag);
    }


}
