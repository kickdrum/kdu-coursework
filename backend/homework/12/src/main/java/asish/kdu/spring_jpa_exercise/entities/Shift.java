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
@Table(name = "shifts")
public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "CHAR(36) DEFAULT (UUID())")
    @JsonProperty("id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "shift_type_id", columnDefinition = "CHAR(36)", referencedColumnName = "id")
    @JsonProperty("shiftType")
    private ShiftType shiftType;

    @Column
    @JsonProperty("name")
    private String name;

    @Column(name = "date_start")
    @JsonProperty("dateStart")
    private java.sql.Date dateStart;

    @Column(name = "date_end")
    @JsonProperty("dateEnd")
    private java.sql.Date dateEnd;

    @Column(name = "time_start")
    @JsonProperty("timeStart")
    private java.sql.Time timeStart;

    @Column(name = "time_end")
    @JsonProperty("timeEnd")
    private java.sql.Time timeEnd;

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
