package org.handson.components;
import org.springframework.stereotype.Component;

@Component
public class Vehicle {
   // @Autowired
    Speaker speaker;

  //  @Autowired
    Tyre tyre;

    public Vehicle(Speaker speaker,Tyre tyre,int generatedPrice )
    {
        this.speaker= speaker;
        this.tyre=tyre;
        this.price = speaker.getPrice()+tyre.getPrice()+ generatedPrice;

    }
    int price;
    /**
     * Retrieve the price of this object.
     *
     * @return the price of this object
     */
    public int getPrice()
    {
        return this.price;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return         	a string representation of the object
     */
    @Override
    public String toString()
    {
        return this.price+" "+speaker.getName()+" "+tyre.getName();
    }


}
