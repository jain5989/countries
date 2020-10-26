package com.example.CountryService;

import com.example.CountryService.controller.CountryController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CountryServiceApplicationSmokeTests {


    @Autowired
    private CountryController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }


}
