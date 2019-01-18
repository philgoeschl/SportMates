package at.fh.ima.swengs.sportmatesdb.facade;

import at.fh.ima.swengs.sportmatesdb.dto.EventDTO;
import at.fh.ima.swengs.sportmatesdb.model.Event;
import at.fh.ima.swengs.sportmatesdb.model.Sport;
import at.fh.ima.swengs.sportmatesdb.service.EventService;
import at.fh.ima.swengs.sportmatesdb.service.SportService;
import at.fh.ima.swengs.sportmatesdb.service.UserService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service()
@Transactional
public class EventFacade {

    @Autowired
    private EventService eventService;

    @Autowired
    @JsonIgnore
    private UserService userService;

    @Autowired
    private SportService sportService;


    void mapDtoToEntity(EventDTO dto, Event entity) {
        entity.setEventDateTime(dto.getEventDateTime());
        entity.setEventDescription(dto.getEventDescription());
        entity.setEventTitle(dto.getEventTitle());
        entity.setEventOrganizer(dto.getEventOrganizer());
        entity.setEventStreet(dto.getEventStreet());
        entity.setEventType(dto.getEventType());
        entity.setEventTown(dto.getEventTown());
        entity.setEventZIP(dto.getEventZIP());
        entity.setImage(dto.getImage());

        Optional<Sport> optionalSport = sportService.findBySportName(dto.getSport());
        if(((Optional) optionalSport).isPresent()) {
            entity.setSport(optionalSport.get());
        }

        //entity.setSport(sportService.getSports(dto.getSport()));

        /*Optional<User> eventManagerOptional = userService.findByUserName(dto.getEventManager());
        if (((Optional) eventManagerOptional).isPresent()) {
            entity.setEventManager(eventManagerOptional.get());
        }*/




        //entity.setUsers(userService.getUsersByUsername(dto.getUsers()));

    }

    private void mapEntityToDto(Event entity, EventDTO dto) {

        dto.setId(entity.getId());
        dto.setEventDateTime(entity.getEventDateTime());
        dto.setEventDescription(entity.getEventDescription());
        dto.setEventTitle(entity.getEventTitle());
        dto.setEventOrganizer(entity.getEventOrganizer());
        dto.setEventStreet(entity.getEventStreet());
        dto.setEventType(entity.getEventType());
        dto.setEventTown(entity.getEventTown());
        dto.setEventZIP(entity.getEventZIP());
        dto.setImage(entity.getImage());

        if(entity.getSport() != null) {
            dto.setSport(entity.getSport().getSportName());
        }


        //dto.setEventManager(entity.getEventManager().getUsername());

        if(entity.getUsers() != null) {
            dto.setUsers(entity.getUsers().stream().map(u -> u.getUsername()).collect(Collectors.toSet()));
        }

    }

    public EventDTO update(Long id, EventDTO dto) {
        Event entity = eventService.findById(id).get();
        mapDtoToEntity(dto, entity);
        mapEntityToDto(eventService.save(entity), dto);
        return dto;

    }

    public EventDTO create(EventDTO dto) {
        Event entity = new Event();
        mapDtoToEntity(dto, entity);
        mapEntityToDto(eventService.save(entity), dto);
        return dto;
    }

    public EventDTO getById(Long id) {
        Event entity = eventService.findById(id).get();
        EventDTO dto = new EventDTO();
        mapEntityToDto(entity, dto);
        return dto;
    }

/*
    public List<EventDTO> getAllEventsFromUser(String eventManagerName) {
        List<EventDTO> events = new ArrayList<EventDTO>();

        eventService.getAllEventsFromUser(eventManagerName).forEach(entity -> {
            EventDTO dto = new EventDTO();
            mapEntityToDto(entity, dto);
            events.add(dto);
        });

        return events;
    }

    public List<EventDTO> getAllEvents() {
        List<EventDTO> events = new ArrayList<EventDTO>();

        eventService.getAll().forEach(entity -> {
            EventDTO dto = new EventDTO();
            mapEntityToDto(entity, dto);
            events.add(dto);
        });

        return events;
    }*/


}
