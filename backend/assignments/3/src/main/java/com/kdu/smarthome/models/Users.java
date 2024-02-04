package com.kdu.smarthome.models;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import org.hibernate.type.SqlTypes;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users", indexes = {
        @Index(name = "username_index",  columnList="username", unique = true)}
)
@SQLDelete(sql = "UPDATE users SET deleted = true WHERE id=?")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "emailId", nullable = false)
    private String emailId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ownHouseList")
    @JdbcTypeCode(SqlTypes.JSON)
    private List<House> ownHouseList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "othersHouseList")
    @JdbcTypeCode(SqlTypes.JSON)
    private List<House> othersHouseList = new ArrayList<>();

    @Column(name="date_created")
    @CreationTimestamp
    private LocalDateTime dateCreated;

    @Column(name="last_updated")
    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    @Column(name="deleted")
    private Boolean deleted = false;

    /**
     *
     * @param username
     * @param password
     *
     * Constructor used while user registration
     */
    public Users(String username, String password){
        this.username = username;
        this.password = password;
    }


    public Users(String username, String password, String name, String firstName, String lastName, String emailId){
        this.username = username;
        this.password = password;
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }
}
