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


    @GetMapping("/events/{id}")
    EventDTO getByEventTitle(@PathVariable Long eventID) {
        return eventFacade.getEventByID(eventID);
    }


    @PostMapping("/events")
    EventDTO create(@RequestBody @Valid EventDTO dto) {
        return eventFacade.create(dto);
    }

    @PutMapping("/events/{id}")
    EventDTO update(@RequestBody @Valid EventDTO dto, @PathVariable Long id) {
        return eventFacade.update(id, dto);
    }

}
