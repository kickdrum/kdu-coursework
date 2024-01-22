package org.handson.service;

import org.handson.components.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

import java.util.Random;

@Configuration
@Import({SpeakerService.class, TyreService.class})
public class VehicleConfig {
    private final SpeakerService speakerService;
    private final TyreService tyreService;

    public VehicleConfig(SpeakerService speakerService,TyreService tyreService) {
        this.speakerService = speakerService;
        this.tyreService = tyreService;
    }
    Random random = new Random();
    /**
     * Generates a new Vehicle with a random speaker, random tyre, and a randomly generated price.
     *
     * @return         	the newly generated Vehicle
     */
    @Bean
    @Scope("prototype")
    public Vehicle vehicleGenerator()
    {

        int generatedPrice = random.nextInt(1000);

        return new Vehicle(speakerService.getRandomSpeaker(),tyreService.getRandomTyre(),generatedPrice);
    }
}
