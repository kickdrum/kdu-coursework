package asish.kdu.Spring_Exercise_3.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@Accessors(fluent = true)
public class VehicleDto {
    public String name;
    public double price;
    public String tyreBrand;
    public double tyrePrice;
    public String speakerBrand;
    public double speakerPrice;
}
