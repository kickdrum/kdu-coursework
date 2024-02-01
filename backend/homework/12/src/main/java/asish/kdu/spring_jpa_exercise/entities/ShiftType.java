package asish.kdu.spring_jpa_exercise.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "shift_types")
public class ShiftType {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "CHAR(36) DEFAULT (UUID())")
    @JsonProperty("id")
    private String id;

    @Column(name = "uq_name", unique = true)
    @JsonProperty("uniqueName")
    private String uniqueName;

    @Column
    @JsonProperty("description")
    private String description;

    @Column
    @JsonProperty("active")
    private Boolean active;

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

    @Column(name = "time_zone", length = 32)
    @JsonProperty("timezone")
    private String timeZone;

    @OneToOne
    @JoinColumn(name = "tenant_id", columnDefinition = "CHAR(36)", referencedColumnName = "id")
    @JsonProperty("tenant")
    private Tenant tenant;
}
