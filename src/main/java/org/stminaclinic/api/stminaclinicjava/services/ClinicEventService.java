package org.stminaclinic.api.stminaclinicjava.services;

import org.stminaclinic.api.stminaclinicjava.dto.ClinicEventsDto;
import org.stminaclinic.api.stminaclinicjava.models.ClinicEvents;

import java.util.List;

public interface ClinicEventService {
    List<ClinicEventsDto> getClinicEvents();
    ClinicEvents getClinicEvent(String clinicEventUUID);
    ClinicEventsDto getClinicEventObj(String clinicEventUUID);
    void updateClinicEvent(int clinicEventId, ClinicEventsDto clinicEventsDto);
    String createClinicEvent(ClinicEventsDto clinicEventsDto);
    void deleteClinicEvent(int id);

}
