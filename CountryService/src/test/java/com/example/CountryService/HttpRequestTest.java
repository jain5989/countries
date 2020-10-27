package com.example.CountryService;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void greetingShouldReturnDefaultMessage() {
        webTestClient.get().uri(getUrl())
                .accept(MediaType.APPLICATION_JSON)
                .header("Authorization", AuthenticatedHeaderProvider.getAuthenticationHeader())
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(String.class);
    }


    @Test
    public void checkAccessDeniedException() {
        webTestClient.get().uri(getUrl())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isUnauthorized()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(String.class);
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


    @Test
    public void checkNameSearch() {
        webTestClient.get().uri(getUrl() + "Finland")
                .accept(MediaType.APPLICATION_JSON)
                .header("Authorization", AuthenticatedHeaderProvider.getAuthenticationHeader())
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(String.class);
    }

    private String getUrl() {
        return "http://localhost:" + port + "countries/";
    }
}