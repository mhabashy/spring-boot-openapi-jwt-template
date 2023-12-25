package org.stminaclinic.api.stminaclinicjava.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.stminaclinic.api.stminaclinicjava.dto.ClinicEventsDto;
import org.stminaclinic.api.stminaclinicjava.models.ClinicEvents;
import org.stminaclinic.api.stminaclinicjava.models.CreateObj;
import org.stminaclinic.api.stminaclinicjava.services.ClinicEventService;

import java.util.List;

@RestController()
public class ClinicEventsController {

    private ClinicEventService clinicEventService;

    @Autowired
    public ClinicEventsController(ClinicEventService clinicEventService) {
        this.clinicEventService = clinicEventService;
    }

    @GetMapping("api/v1/clinic")
    @Operation(summary = "get clinic event list")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<List<ClinicEventsDto>> getClinicEvents() {
        return new ResponseEntity<List<ClinicEventsDto>>(clinicEventService.getClinicEvents(), HttpStatus.OK);
    }

    @PostMapping("api/v1/clinic/create")
    @Operation(summary = "create clinic event", security = @SecurityRequirement(name = "bearerAuth"))
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CreateObj> createClinicEvents(@RequestBody ClinicEventsDto clinicEventsDto) {
        String clinicEventUUID = this.clinicEventService.createClinicEvent(clinicEventsDto);
        return new ResponseEntity<CreateObj>(new CreateObj(clinicEventUUID), HttpStatus.CREATED);
    }

    @GetMapping("api/v1/clinic/{clinicEventUUID}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "get clinic information", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<ClinicEventsDto> getClinicByUUID(@PathVariable String clinicEventUUID) {
        ClinicEventsDto clinicEventsWithPatientsDto = this.clinicEventService.getClinicEventObj(clinicEventUUID);
        return new ResponseEntity<ClinicEventsDto>(clinicEventsWithPatientsDto, HttpStatus.OK);
    }

    @PatchMapping("api/v1/clinic/{clinicEventUUID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "update clinic event", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<Void> updateClinicEvents(@PathVariable String clinicEventUUID, @RequestBody ClinicEventsDto clinicEventsDto) {
        ClinicEvents clinicEvents = this.clinicEventService.getClinicEvent(clinicEventUUID);
        this.clinicEventService.updateClinicEvent(clinicEvents.getId(), clinicEventsDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("api/v1/clinic/{clinicEventUUID}")
    @Operation(summary = "delete clinic event", security = @SecurityRequirement(name = "bearerAuth"))
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteClinicEvents(@PathVariable String clinicEventUUID) {
        ClinicEvents clinicEvents = this.clinicEventService.getClinicEvent(clinicEventUUID);
        this.clinicEventService.deleteClinicEvent(clinicEvents.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
