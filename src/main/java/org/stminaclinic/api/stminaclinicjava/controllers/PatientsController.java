package org.stminaclinic.api.stminaclinicjava.controllers;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.stminaclinic.api.stminaclinicjava.dto.PatientDto;
import org.stminaclinic.api.stminaclinicjava.models.CreateObj;
import org.stminaclinic.api.stminaclinicjava.services.PatientService;

import jakarta.websocket.server.PathParam;

@RestController()
public class PatientsController {

    PatientService patientService;

    @Autowired
    PatientsController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/api/v1/patients/{clinicEventUUID}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "get clinic event patient list", security = @SecurityRequirement(name = "bearerAuth"))
    private ResponseEntity<List<PatientDto>> getPatients(@PathVariable("clinicEventUUID") String clinicEventUUID) {
        return new ResponseEntity<List< PatientDto >>(patientService.getPatientsByEventUUID(clinicEventUUID), HttpStatus.OK);
    }

    @PostMapping("/api/v1/patient/create/{clinicEventUUID}")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "create clinic event")
    private ResponseEntity<CreateObj> createPatient(@PathVariable("clinicEventUUID") String clinicEventUUID, PatientDto patient) {
        return new ResponseEntity<CreateObj>(new CreateObj(patientService.createPatient(clinicEventUUID, patient)), HttpStatus.CREATED);
    }

    @GetMapping("/api/v1/patient/{patientUUID}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "get patient information", security = @SecurityRequirement(name = "bearerAuth"))
    private ResponseEntity<PatientDto> getPatient(@PathParam("patientUUID") String uuid) {
        return new ResponseEntity<PatientDto>(patientService.getPatientsDtoByEventUUID(uuid), HttpStatus.OK);
    }

    @PatchMapping("/api/v1/patient/{patientUUID}")
    @Operation(summary = "update patient", security = @SecurityRequirement(name = "bearerAuth"))
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private ResponseEntity<Void> updatePatient(@PathParam("patientUUID") String uuid, PatientDto patient) {
        patientService.updatePatient(uuid, patient);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/api/v1/patient/{patientUUID}")
    @Operation(summary = "delete patient", security = @SecurityRequirement(name = "bearerAuth"))
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private ResponseEntity<Void> deletePatient(@PathParam("patientUUID") String uuid) {
        patientService.deletePatientById(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
