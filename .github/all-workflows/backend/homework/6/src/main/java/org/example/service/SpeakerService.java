package org.example.service;

import org.example.Constants;
import org.example.entities.Speaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpeakerService {
    @Bean("sony")
    public Speaker speaker1() {
        return new Speaker("Sony", Constants.SONY_SPEAKERS_PRICE);
    }
    @Bean("bose")
    public Speaker speaker2(){
        return new Speaker("Bose",Constants.BOSE_SPEAKERS_PRICE);
    }
}
