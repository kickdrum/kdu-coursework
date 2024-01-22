package org.example.Bean;

import org.example.Config.SpeakerService;
import org.example.Config.TyreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Vehicle {
    @Autowired
    private Tyre tyre;
    @Autowired
    private Speaker speaker;
    private Double price;

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    public void setPrice(Double price) {
        this.price=price;
    }

    public Double getPrice() {
        return price;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public Tyre getTyre() {
        return tyre;
    }

    public Vehicle(Speaker speaker, Tyre tyre){
        this.speaker=speaker;
        this.tyre=tyre;
    }



}
