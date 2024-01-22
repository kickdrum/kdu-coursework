package org.example.service;

import org.example.Constants;
import org.example.entities.Tyre;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TyreService {
    @Bean("mrf")
    public Tyre tyre1(){
        return new Tyre("MRF", Constants.MRF_TYPE_PRICE);
    }
    @Bean("bridestone")
    public Tyre tyre2(){
        return new Tyre("Bridestone",Constants.BRIDGESTONE_TYPE_PRICE);
    }
}
