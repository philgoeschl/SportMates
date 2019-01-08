package at.fh.ima.swengs.sportmatesdb.controller;

import at.fh.ima.swengs.sportmatesdb.dto.EventDTO;
import at.fh.ima.swengs.sportmatesdb.facade.EventFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EventController {

    @Autowired
    private EventFacade eventFacade;


    @GetMapping("/events/{eventID}")
    EventDTO getByEventTitle(@PathVariable String eventID) {
        return eventFacade.getEventByID(eventID);
    }

    @GetMapping("/events/{eventManager}")
    List<EventDTO> getAllManagedEvents(@PathVariable String eventManager) {
        return eventFacade.getAllEventsFromUser(eventManager);
    }

    @GetMapping("/events/")
    List<EventDTO> getAllEvents() { return eventFacade.getAllEvents(); }

    @PostMapping("/events")
    EventDTO create(@RequestBody @Valid EventDTO dto) {
        return eventFacade.create(dto);
    }

    @PutMapping("/events/{eventID}")
    EventDTO update(@RequestBody @Valid EventDTO dto, @PathVariable String eventID) {
        return eventFacade.update(eventID, dto);
    }

}
