package org.stminaclinic.api.stminaclinicjava.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    @CreationTimestamp
    private Timestamp createdDate;

    @UuidGenerator
    private String uuid;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clinic_events_id")
    private ClinicEvents clinicEvents;
}
