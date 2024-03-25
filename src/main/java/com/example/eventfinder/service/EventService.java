package com.example.eventfinder.service;
import com.example.eventfinder.dto.EventDTO;
import com.example.eventfinder.model.Event;
import com.example.eventfinder.model.Tag;
import com.example.eventfinder.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<EventDTO> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        List<EventDTO> eventDTOs = new ArrayList<>();
        for (Event event : events) {
            eventDTOs.add(mapToDTO(event));
        }
        return eventDTOs;
    }

    private EventDTO mapToDTO(Event event) {
        EventDTO dto = new EventDTO();
        dto.setEventId(event.getEvent_Id());
        dto.setUserId(event.getUser_Id());
        dto.setEventTitle(event.getEvent_Title());
        dto.setEventDateTime(event.getEvent_Date_Time());
        dto.setAddressName(event.getAddress().getAddress_Name());
        dto.setImage(event.getImage());
        dto.setDescription(event.getDescription());
        Set<String> tags = new HashSet<>();
        for (Tag tag : event.getTags()) {
            tags.add(tag.getTag_Name());
        }
        dto.setTags(tags);
        return dto;
    }
}
