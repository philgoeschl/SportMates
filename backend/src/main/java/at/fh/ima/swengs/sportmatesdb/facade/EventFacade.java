package at.fh.ima.swengs.sportmatesdb.facade;

import at.fh.ima.swengs.sportmatesdb.dto.EventDTO;
import at.fh.ima.swengs.sportmatesdb.model.Event;
import at.fh.ima.swengs.sportmatesdb.model.User;
import at.fh.ima.swengs.sportmatesdb.service.EventService;
import at.fh.ima.swengs.sportmatesdb.service.SportService;
import at.fh.ima.swengs.sportmatesdb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@SuppressWarnings("Duplicates")

@Service()
@Transactional
public class EventFacade {

    @Autowired
    private UserService userService;

    @Autowired
    private SportService sportService;

    @Autowired
    private EventService eventService;

    private void mapDtoToEntity(EventDTO dto, Event entity) {
        entity.setEventDateTime(dto.getEventDateTime());
        entity.setEventDescription(dto.getEventDescription());
        entity.setEventImage(dto.getEventImage());
        entity.setEventTitle(dto.getEventTitle());
        entity.setEventOrganizer(dto.getEventOrganizer());
        entity.setEventImage(dto.getEventImage());
        entity.setEventStreet(dto.getEventStreet());
        entity.setEventType(dto.getEventType());
        entity.setEventTown(dto.getEventTown());
        entity.setEventZIP(dto.getEventZIP());

        /*Optional<User> eventManagerOptional = userService.findByUserName(dto.getEventManager());
        if(((Optional) eventManagerOptional).isPresent()) {
            entity.setEventManager(eventManagerOptional.get());
        }*/

        //entity.setSport(sportService.findBySportName(dto.getSport()).get());
        //entity.setUsers(userService.getUsersByUsername(dto.getUsers()));

    }

    private void mapEntityToDto(Event entity, EventDTO dto) {

        dto.setEventDateTime(entity.getEventDateTime());
        dto.setEventDescription(entity.getEventDescription());
        dto.setEventImage(entity.getEventImage());
        dto.setEventTitle(entity.getEventTitle());
        dto.setEventOrganizer(entity.getEventOrganizer());
        dto.setEventImage(entity.getEventImage());
        dto.setEventStreet(entity.getEventStreet());
        dto.setEventType(entity.getEventType());
        dto.setEventTown(entity.getEventTown());
        dto.setEventZIP(entity.getEventZIP());


        //dto.setEventManager(entity.getEventManager().getUsername());
        //dto.setSport(entity.getSport().getSportName());
        //dto.setUsers(entity.getUsers().stream().map(u -> u.getUsername()).collect(Collectors.toSet()));
    }

    public EventDTO create(EventDTO dto) {
        Event entity = new Event();
        mapDtoToEntity(dto, entity);
        mapEntityToDto(eventService.save(entity), dto);
        return dto;
    }



    public EventDTO getEventByID(Long eventID) {
        Event entity = eventService.findById(eventID).get();
        EventDTO dto = new EventDTO();
        mapEntityToDto(entity, dto);
        return dto;
    }

    public EventDTO update(Long eventID, EventDTO dto) {
        Event entity  = eventService.findById(eventID).get();
        mapDtoToEntity(dto, entity);
        mapEntityToDto(eventService.save(entity), dto);
        return dto;

    }
}
