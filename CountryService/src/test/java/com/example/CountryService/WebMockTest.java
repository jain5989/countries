package com.example.CountryService;

import com.example.CountryService.controller.CountryController;
import com.example.CountryService.model.Country;
import com.example.CountryService.service.CountryConsumerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CountryController.class)
public class WebMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CountryConsumerService service;


    @Test
    public void shouldReturnMessageFromService() throws Exception {
        this.mockMvc.perform(get("/").header("Authorization", AuthenticatedHeaderProvider.getAuthenticationHeader()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Service is working")));
    }

    @Test
    public void shouldReturnCountryFromService() throws Exception {
        when(service.getEuropeanCountryWithName("Finland"))
                .thenReturn(new Country("Finland",
                        "FI", "Helsinki", "5491817", "https://restcountries.eu/data/fin.svg"));

        this.mockMvc.perform(get("/countries/Finland").header("Authorization", AuthenticatedHeaderProvider.getAuthenticationHeader()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("")));
    }
}