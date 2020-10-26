package com.example.CountryService;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingShouldReturnDefaultMessage() {

        String url = getUrl();
        String oneOfExpectedCountry = "{\"name\":\"Afghanistan\",\"countryCode\":\"AF\",\"capital\":\"Kabul\",\"" +
                "population\":\"27657145\",\"flag\":\"https://restcountries.eu/data/afg.svg\"}";


        // create headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", AuthenticatedHeaderProvider.getAuthenticationHeader());

        // create request
        HttpEntity request = new HttpEntity(headers);

        // make a request
        ResponseEntity<String> response = new RestTemplate().exchange(url, HttpMethod.GET, request, String.class);

        String json = response.getBody();

        assertTrue(json.contains(oneOfExpectedCountry));

    }


    @Test
    public void checkAccessDeniedException() {
        String url = getUrl();
        HttpHeaders headers = new HttpHeaders();

        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<String> response;
        try {
            response = new RestTemplate().exchange(url, HttpMethod.GET, request, String.class);
        } catch (HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.UNAUTHORIZED);
        }

    }

    @Test
    public void checkWrongArgumentInAPI() {
        String url = getUrl() + "Test";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", AuthenticatedHeaderProvider.getAuthenticationHeader());

        HttpEntity request = new HttpEntity(headers);


        ResponseEntity<String> response;
        try {
            response = new RestTemplate().exchange(url, HttpMethod.GET, request, String.class);
        } catch (HttpServerErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    private String getUrl() {
        return "http://localhost:" + port + "countries/";
    }
}