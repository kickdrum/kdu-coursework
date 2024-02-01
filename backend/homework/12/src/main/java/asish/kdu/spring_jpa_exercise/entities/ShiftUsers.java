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
@Table(name = "shift_user")
public class ShiftUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "CHAR(36) DEFAULT (UUID())")
    private String id;

    @OneToOne
    @JoinColumn(name = "shift_id", columnDefinition = "CHAR(36)", referencedColumnName = "id")
    @JsonProperty("shift")
    private Shift shift;

    @OneToOne
    @JoinColumn(name = "user_id", columnDefinition = "CHAR(36)", referencedColumnName = "id")
    @JsonProperty("user")
    private User user;

    @OneToOne
    @JoinColumn(name = "tenant_id", columnDefinition = "CHAR(36)", referencedColumnName = "id")
    @JsonProperty("tenant")
    private Tenant tenant;

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

}
