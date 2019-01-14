package at.fh.ima.swengs.sportmatesdb.controller;

import at.fh.ima.swengs.sportmatesdb.dto.EventDTO;
import at.fh.ima.swengs.sportmatesdb.facade.EventFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class EventController {

    @Autowired
    private EventFacade eventFacade;

    @GetMapping("/dto/events/{id}")
    EventDTO getById(@PathVariable Long id) {
        return eventFacade.getById(id);
    }

    @PostMapping("/dto/events")
    EventDTO create(@RequestBody @Valid EventDTO dto) {
        return eventFacade.create(dto);
    }

    @PutMapping("/dto/events/{id}")
    EventDTO update(@RequestBody @Valid EventDTO dto, @PathVariable Long id) {
        return eventFacade.update(id, dto);
    }
}
