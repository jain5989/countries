package com.example.CountryService;

import java.util.Base64;

public class AuthenticatedHeaderProvider {

    public static String getAuthenticationHeader() {
        // create auth credentials
        String authStr = "admin:admin";
        String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());
        return "Basic " + base64Creds;
    }
}
