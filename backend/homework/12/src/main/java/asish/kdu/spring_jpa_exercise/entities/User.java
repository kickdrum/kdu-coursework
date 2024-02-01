package asish.kdu.spring_jpa_exercise.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "CHAR(36) DEFAULT (UUID())")
    @JsonProperty("id")
    private String id;

    @Column(unique = true, length = 32)
    @JsonProperty("username")
    private String username;

    @Column
    @JsonProperty("loggedin")
    private short loggedin;

    @Column(name = "time_zone", length = 32)
    @JsonProperty("timezone")
    private String timeZone;

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

    @OneToOne
    @JoinColumn(name = "tenant_id", columnDefinition = "CHAR(36)", referencedColumnName = "id")
    @JsonProperty("tenant")
    private Tenant tenant;
}
