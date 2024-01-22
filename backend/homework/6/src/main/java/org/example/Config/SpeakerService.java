package org.example.Config;

import org.example.Bean.Speaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpeakerService {
    @Bean(name="Sony")
    public Speaker generateSpeaker1() {
        Speaker speaker = new Speaker();
        speaker.setBrand("Sony");
        speaker.setPrice(5000.0);
        return speaker;
    }
    @Bean(name="Bose")
    public Speaker generateSpeaker2(){
        Speaker speaker=new Speaker();
        speaker.setBrand("Bose");
        speaker.setPrice(7200.0);
        return speaker;
    }

}
