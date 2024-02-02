package spring.assignment.assignment2.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
public class Address {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nickName;
    private long id;
    private String city;
    private String state;
    private String postalCode;
}
