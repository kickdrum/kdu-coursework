package com.example.assignment2.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

@Component
public class URIMaker {

    @Value("${positionStackAccess_key}")
    private String positionStackApiAccesskey;
    public  URI requestURLBuilder(String address) throws URISyntaxException {
        String encodedAddress = java.net.URLEncoder.encode(address, StandardCharsets.UTF_8);
        return new URI("http://api.positionstack.com/v1/forward?access_key="+positionStackApiAccesskey+"&query="+encodedAddress);
    }

    public URI requestURLBuilder(Double latitude,Double longitude) throws URISyntaxException {
        return new URI("http://api.positionstack.com/v1/reverse?access_key="+positionStackApiAccesskey+"&query="+latitude+","+longitude);
    }
}
