package org.example.Config;

import org.example.Inventory.InventoryStore;
import org.example.Vehicle.Entity.Speaker;
import org.example.Vehicle.Entity.Tyre;
import org.example.Vehicle.Service.VehicleServiceFactory1;
import org.example.Vehicle.Service.VehicleServiceFactory2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class ProjectConfig {
    @PostConstruct
    @Bean(name="factory1")
    public InventoryStore inv1(){
        return new InventoryStore();
    }
    @PostConstruct
    @Bean(name="factory2")
    public InventoryStore inv2(){
        return new InventoryStore();
    }
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
    @Bean(name ="MRF")
    public Tyre generateTyre1(){
        Tyre tyre= new Tyre();
        tyre.setPrice(900.0);
        tyre.setBrand("MRF");
        return tyre;
    }
    @Bean(name= "Bridgestone")
    public Tyre generateTyre2(){
        Tyre tyre= new Tyre();
        tyre.setBrand("BridgeStore");
        tyre.setPrice(1200.0);
        return tyre;
    }
    @Bean
    public VehicleServiceFactory1 factory1service(){
        return new VehicleServiceFactory1(inv1());
    }
    @Bean
    public VehicleServiceFactory2 factory2service(){
        return new VehicleServiceFactory2(inv2());
    }

}
