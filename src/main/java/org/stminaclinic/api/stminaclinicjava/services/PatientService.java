package org.stminaclinic.api.stminaclinicjava.services;

import org.stminaclinic.api.stminaclinicjava.dto.PatientDto;
import org.stminaclinic.api.stminaclinicjava.models.Patients;

import java.util.List;

public interface PatientService {
    Patients getPatientByUUID(String uuid);
    PatientDto getPatientsDtoByEventUUID(String uuid);
    List<PatientDto> getPatientsByEventUUID(String uuid);
    void deletePatientById(String uuid);
    String createPatient(String clinicEventUUID, PatientDto patient);
    void updatePatient(String uuid, PatientDto patient);
}
