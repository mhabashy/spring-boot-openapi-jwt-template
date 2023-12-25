package org.stminaclinic.api.stminaclinicjava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.stminaclinic.api.stminaclinicjava.models.Patients;

public interface PatientRepository extends JpaRepository<Patients, Integer> {
    Patients findByUuid(String uuid);
    List<Patients> findAllByClinicEventsId(int id);
}
