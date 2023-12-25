package org.stminaclinic.api.stminaclinicjava.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stminaclinic.api.stminaclinicjava.dto.PatientDto;
import org.stminaclinic.api.stminaclinicjava.exceptions.PatientNotFoundException;
import org.stminaclinic.api.stminaclinicjava.models.ClinicEvents;
import org.stminaclinic.api.stminaclinicjava.models.Patients;
import org.stminaclinic.api.stminaclinicjava.repository.PatientRepository;
import org.stminaclinic.api.stminaclinicjava.services.ClinicEventService;
import org.stminaclinic.api.stminaclinicjava.services.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;
    private ClinicEventService clinicEventService;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository, ClinicEventService clinicEventService) {
        this.patientRepository = patientRepository;
        this.clinicEventService = clinicEventService;
    }

    @Override
    public Patients getPatientByUUID(String uuid) {
        Patients patient = this.patientRepository.findByUuid(uuid);
        if (patient == null) {
            throw new PatientNotFoundException("Patient Not Found!");
        }
        return patient;
    }

    @Override
    public PatientDto getPatientsDtoByEventUUID(String uuid) {
        Patients patient = this.getPatientByUUID(uuid);
        if (patient == null) {
            throw new PatientNotFoundException("Patient Not Found!");
        }
        return mapToDto(patient);
    }

    @Override
    public List<PatientDto> getPatientsByEventUUID(String uuid) {
        ClinicEvents clinicEvents = this.clinicEventService.getClinicEvent(uuid);
        List<Patients> patients = this.patientRepository.findAllByClinicEventsId(clinicEvents.getId());
        return patients.stream().map(p -> mapToDto(p)).collect(Collectors.toList()) ;
    }

    @Override
    public void deletePatientById(String uuid) {
        Patients patient = this.getPatientByUUID(uuid);
        this.patientRepository.delete(patient);
    }

    @Override
    public String createPatient(String clinicEventUUID, PatientDto patient) {
        Patients newPatient = new Patients();
        newPatient.setFirstName(patient.getFirstName());
        newPatient.setLastName(patient.getLastName());
        newPatient.setPhone(patient.getPhone());
        newPatient.setEmail(patient.getEmail());
        newPatient.setUuid(patient.getUuid());
        newPatient.setCreatedDate(patient.getCreatedDate());
        ClinicEvents clinicEvents = this.clinicEventService.getClinicEvent(clinicEventUUID);
        newPatient.setClinicEvents(clinicEvents);
        this.patientRepository.save(newPatient);
        return newPatient.getUuid();
    }

    @Override
    public void updatePatient(String uuid,  PatientDto patientDto) {
        Patients patient = this.getPatientByUUID(uuid);
        patient.setFirstName(patientDto.getFirstName());
        patient.setLastName(patientDto.getLastName());
        patient.setPhone(patientDto.getPhone());
        patient.setEmail(patientDto.getEmail());
        patient.setUuid(patientDto.getUuid());
        patient.setCreatedDate(patientDto.getCreatedDate());
        this.patientRepository.save(patient);
    }

    PatientDto mapToDto(Patients patient) {
        PatientDto patientDto = new PatientDto();
        patientDto.setFirstName(patient.getFirstName());
        patientDto.setLastName(patient.getLastName());
        patientDto.setPhone(patient.getPhone());
        patientDto.setEmail(patient.getEmail());
        patientDto.setUuid(patient.getUuid());
        patientDto.setCreatedDate(patient.getCreatedDate());
        return patientDto;
    }
    
}
