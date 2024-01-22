package org.example;
import org.example.Bean.Speaker;
import org.example.Bean.Tyre;
import org.example.Config.SpeakerService;
import org.example.Config.TyreService;
import org.example.Config.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static final Logger slf4jLogger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        AnnotationConfigApplicationContext newContext = new AnnotationConfigApplicationContext(
                SpeakerService.class,
                TyreService.class,
                VehicleService.class
        );
        Speaker speaker1=(Speaker) newContext.getBean("Bose");
        Tyre tyre1=(Tyre) newContext.getBean("Ceat");
        VehicleService vehicles=(VehicleService) newContext.getBean(VehicleService.class);
        vehicles.addToVehicleList(speaker1, tyre1);

        Speaker speaker2=(Speaker) newContext.getBean("Bose");
        Tyre tyre2=(Tyre) newContext.getBean("Bridgestone");
        vehicles.addToVehicleList(speaker2, tyre2);

        Speaker speaker3=(Speaker) newContext.getBean("Sony");
        Tyre tyre3=(Tyre) newContext.getBean("Ceat");
        vehicles.addToVehicleList(speaker3, tyre3);

        Speaker speaker4=(Speaker) newContext.getBean("Sony");
        Tyre tyre4=(Tyre) newContext.getBean("Bridgestone");
        vehicles.addToVehicleList(speaker4, tyre4);

        vehicles.printMostExpensiveVehicleDetails();

    }
}