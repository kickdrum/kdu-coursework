package asish.kdu.Spring_Exercise_3.dtos.mappers;

import asish.kdu.Spring_Exercise_3.dtos.VehicleDto;
import asish.kdu.Spring_Exercise_3.models.Speaker;
import asish.kdu.Spring_Exercise_3.models.Tyre;
import asish.kdu.Spring_Exercise_3.models.Vehicle;

public class VehicleMapper {
    public static VehicleDto entityToDto(Vehicle vehicle, Tyre tyre, Speaker speaker) {
        return new VehicleDto(vehicle.name(), vehicle.price(), tyre.brand(), tyre.price(), speaker.brand(), speaker.price());
    }

    public static Vehicle dtoToEntity(VehicleDto vDto) {
        Tyre t = new Tyre(vDto.tyreBrand(), vDto.tyrePrice());
        Speaker s = new Speaker(vDto.speakerBrand(), vDto.speakerPrice());
        return new Vehicle(t, s, vDto.price(), vDto.name());
    }
}
