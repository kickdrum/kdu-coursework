package com.kdu.smarthome.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "deviceInventory", indexes = {
        @Index(name = "kickston_id_index",  columnList="kickston_id", unique = true)}
)
@SQLDelete(sql = "UPDATE deviceInventory SET deleted = true WHERE id=?")
public class DeviceInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "kickston_id")
    String kickStoneId;

    @Column(name = "device_username")
    String deviceUserName;

    @Column(name = "device_password")
    String devicePassword;

    @Column(name = "manufacture_date_time")
    String manufactureDateTime;

    @Column(name = "manufacture_factory_place")
    String manufactureFactoryPlace;


    @Column(name="date_created")
    @CreationTimestamp
    private LocalDateTime dateCreated;

    @Column(name="last_updated")
    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    @Column(name="deleted")
    private Boolean deleted = false;


    public DeviceInventory(String kickStoneId, String deviceUserName, String devicePassword, String manufactureDateTime, String manufactureFactoryPlace){
        this.kickStoneId = kickStoneId;
        this.deviceUserName = deviceUserName;
        this.devicePassword = devicePassword;
        this.manufactureDateTime = manufactureDateTime;
        this.manufactureFactoryPlace = manufactureFactoryPlace;
    }
}
