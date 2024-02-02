package spring.assignment.assignment2.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@AllArgsConstructor
@Entity
@Data
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    private String name;
    private String description;
    private double price;
    private long stockQuantity;
    private int threshold;
    @ManyToMany(mappedBy = "productSet")
    Set<Cart> carts;
}
