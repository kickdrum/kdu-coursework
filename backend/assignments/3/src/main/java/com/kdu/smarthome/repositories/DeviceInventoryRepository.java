package com.kdu.smarthome.repositories;

import com.kdu.smarthome.models.DeviceInventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceInventoryRepository extends JpaRepository<DeviceInventory, Long> {
    public DeviceInventory findDeviceInventoryByKickStoneId(String kickStoneId);
}
