package org.stminaclinic.api.stminaclinicjava.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stminaclinic.api.stminaclinicjava.dto.ClinicEventsDto;
import org.stminaclinic.api.stminaclinicjava.exceptions.ClinicEventsNotFoundException;
import org.stminaclinic.api.stminaclinicjava.models.ClinicEvents;
import org.stminaclinic.api.stminaclinicjava.repository.ClinicEventsRepository;
import org.stminaclinic.api.stminaclinicjava.repository.PatientRepository;
import org.stminaclinic.api.stminaclinicjava.services.ClinicEventService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClinicEventServiceImpl implements ClinicEventService {

    private ClinicEventsRepository clinicEventsRepository;

    @Autowired
    public ClinicEventServiceImpl(ClinicEventsRepository clinicEventsRepository) {
        this.clinicEventsRepository = clinicEventsRepository;
    }

    @Override
    public List<ClinicEventsDto> getClinicEvents() {
        List<ClinicEvents> clinicEvents = clinicEventsRepository.findAll();
        return clinicEvents.stream().map(c -> mapToDto(c)).collect(Collectors.toList());
    }

    @Override
    public ClinicEvents getClinicEvent(String clinicEventUUID) {
        ClinicEvents clinicEvents = clinicEventsRepository.findByUuid(clinicEventUUID);
        if (clinicEvents == null) {
            throw new ClinicEventsNotFoundException("Clinic Event Not Found!");
        }
        return clinicEvents;
    }

    @Override
    public ClinicEventsDto getClinicEventObj(String clinicEventUUID) {
        ClinicEvents clinicEvents = this.getClinicEvent(clinicEventUUID);
        ClinicEventsDto clinicEventsDto = new ClinicEventsDto();
        clinicEventsDto.setDate(clinicEvents.getDate());
        clinicEventsDto.setUuid(clinicEvents.getUuid());
        clinicEventsDto.setCreateDate(clinicEvents.getCreatedDate());
        return clinicEventsDto;
    }

    @Override
    public void updateClinicEvent(int clinicEventId, ClinicEventsDto clinicEventsDto) {
        ClinicEvents clinicEvents = clinicEventsRepository.findById(clinicEventId).orElseThrow(() -> new ClinicEventsNotFoundException("Clinic Event Not Found!"));
        clinicEvents.setDate(clinicEventsDto.getDate());
        clinicEventsRepository.save(clinicEvents);
    }

    @Override
    public String createClinicEvent(ClinicEventsDto clinicEventsDto) {
        ClinicEvents clinicEvents = new ClinicEvents();
        clinicEvents.setDate(clinicEventsDto.getDate());
        ClinicEvents newClinicEvents = clinicEventsRepository.save(clinicEvents);
        return newClinicEvents.getUuid();
    }

    @Override
    public void deleteClinicEvent(int clinicEventId) {
        ClinicEvents clinicEvents = clinicEventsRepository.findById(clinicEventId).orElseThrow(() -> new ClinicEventsNotFoundException("Clinic Event Not Found!"));
        clinicEventsRepository.delete(clinicEvents);
    }

    ClinicEventsDto mapToDto(ClinicEvents clinicEvents) {
        ClinicEventsDto clinicEventsDto = new ClinicEventsDto();
        clinicEventsDto.setDate(clinicEvents.getDate());
        clinicEventsDto.setUuid(clinicEvents.getUuid());
        clinicEventsDto.setCreateDate(clinicEvents.getCreatedDate());
        return clinicEventsDto;
    }
}
