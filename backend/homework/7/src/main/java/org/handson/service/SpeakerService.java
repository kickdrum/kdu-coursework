package org.handson.service;

import org.handson.components.Speaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Random;

@Configuration
public class SpeakerService {
    private final Random random = new Random();

    /**
     * Retrieves a random speaker from a predefined list.
     *
     * @return         	the randomly selected speaker
     */
    @Bean
    @Scope("prototype")
    public Speaker getRandomSpeaker()
    {
     
        Speaker[] speakerValues = {Speaker.BOSE,Speaker.SONY};
        int randomSpeakerIndex = random.nextInt(speakerValues.length);
        return  speakerValues[randomSpeakerIndex];

       
    }

}
