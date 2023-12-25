package org.stminaclinic.api.stminaclinicjava.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clinic_events")
public class ClinicEvents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;

    @CreationTimestamp
    private Timestamp createdDate;

    @UuidGenerator
    private String uuid;

    @OneToMany(mappedBy = "clinicEvents", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Patients> patientsList = new ArrayList<Patients>();
}
