package asish.kdu.Spring_Exercise_3.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Tyre class with all its attributes, getters and setters
 */

@Data
@AllArgsConstructor
@Accessors(fluent = true)
public class Tyre {
    public final String brand;
    public final double price;
}
