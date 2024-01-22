package org.handson.service;

import org.handson.components.Tyre;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;
@Configuration
public class TyreService {
  Random random = new Random();

  @Bean
    public Tyre getRandomTyre()
  {

   

      Tyre[] tyreValues = {Tyre.BRIGESTONE,Tyre.MRF};

      int randomTyreIndex = random.nextInt(tyreValues.length);
      return  tyreValues[randomTyreIndex];

      
  }

}
