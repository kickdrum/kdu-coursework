package asish.kdu.spring_jpa_exercise.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "tenants")
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "CHAR(36) DEFAULT (UUID())")
    @JsonProperty("id")
    private String id;

    @Column
    @JsonProperty("name")
    private String name;

    @Column
    @JsonProperty("email")
    private String email;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @UpdateTimestamp
    private Timestamp updatedAt;

    @Column
    @JsonProperty("createdBy")
    private String createdBy;

    @Column
    @JsonProperty("updatedBy")
    private String updatedBy;

    @Override
    public String toString() {
        return "Tenant(id = " + id + " " +
                "name = " + name + " " +
                "email = " + email + " " +
                "createdBy = " + createdBy + " " +
                "updatedBy = " + updatedBy + ")";
    }
}