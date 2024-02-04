package com.kdu.smarthome.repositories;

import com.kdu.smarthome.models.Devices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Devices, Long> {
    public Devices findDeviceByKickstonId(String kickstonId);
}
