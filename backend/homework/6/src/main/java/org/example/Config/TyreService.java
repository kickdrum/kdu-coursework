package org.example.Config;

import org.example.Bean.Tyre;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TyreService {
    @Bean(name ="Ceat")
    public Tyre generateTyre1(){
        Tyre tyre= new Tyre();
        tyre.setPrice(900);
        tyre.setBrand("Ceat");
        return tyre;
    }
    @Bean(name= "Bridgestone")
    public Tyre generateTyre2(){
        Tyre tyre= new Tyre();
        tyre.setBrand("BridgeStore");
        tyre.setPrice(1200);
        return tyre;
    }
}
