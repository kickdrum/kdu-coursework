package asish.kdu.Spring_Exercise_3.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * Vehicle class with all its attributes, getters and setters
 */

@Data
@AllArgsConstructor
@Accessors(fluent = true)
public class Vehicle {

    public final Tyre tyre;
    public final Speaker speaker;
    public double price;
    public String name;

    /**
     * THe default toString() is overridden to have a nice output in logger
     * @return Nicely formatted String
     */
    @Override
    public String toString() {
        return "Vehicle(tyre - " + tyre.brand() + "\n" +
                "vehicleTotalPrice - " + price + "\n" +
                "tyrePrice - " + tyre.price() + "\n" +
                "speaker - " + speaker.brand() + "\n" +
                "speakerPrice - " + speaker.price() + ")\n";
    }
}