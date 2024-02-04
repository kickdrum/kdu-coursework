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
@Table(name = "devices", indexes = {
        @Index(name = "kickston_id_index",  columnList="kickston_id", unique = true)}
)
@SQLDelete(sql = "UPDATE devices SET deleted = true WHERE id=?")
public class Devices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "kickston_id")
    private String kickstonId;


    @Column(name = "device_user_name")
    private String deviceUsername;

    @Column(name = "user_name")
    private String username;

    @Column(name = "room_name")
    private String roomName;


    @Column(name="date_created")
    @CreationTimestamp
    private LocalDateTime dateCreated;

    @Column(name="last_updated")
    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    @Column(name="deleted")
    private Boolean deleted = false;

    public Devices(String kickstonId, String username){
        this.kickstonId = kickstonId;
        this.username = username;
    }

    public Devices(String kickstonId, String username, String deviceUsername){
        this.kickstonId = kickstonId;
        this.username = username;
        this.deviceUsername = deviceUsername;
    }



}
