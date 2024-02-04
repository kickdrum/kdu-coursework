package com.kdu.smarthome.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "house", indexes = {
        @Index(name = "house_name_index",  columnList="house_name", unique = true)}
)
@SQLDelete(sql = "UPDATE house SET deleted = true WHERE id=?")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "house_name", nullable = false)
    private String houseName;

    @OneToOne
    @JoinColumn(name = "admin_user")
    private Users users;

    @OneToMany
    @JoinColumn(name = "users_access_list")
    private List<Users> userAccessList = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "rooms_list")
    private List<Rooms> roomsList = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "devices_list")
    private List<Devices> devices = new ArrayList<>();


    @Column(name="date_created")
    @CreationTimestamp
    private LocalDateTime dateCreated;

    @Column(name="last_updated")
    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    @Column(name="deleted")
    private Boolean deleted = false;


    public House(String address, String houseName, Users users){
        this.address = address;
        this.houseName = houseName;
        this.users = users;
    }

}
