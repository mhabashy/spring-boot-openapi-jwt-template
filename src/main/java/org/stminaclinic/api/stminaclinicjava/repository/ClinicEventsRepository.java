package org.stminaclinic.api.stminaclinicjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.stminaclinic.api.stminaclinicjava.models.ClinicEvents;

public interface ClinicEventsRepository extends JpaRepository<ClinicEvents, Integer> {
    ClinicEvents findByUuid(String uuid);
}
