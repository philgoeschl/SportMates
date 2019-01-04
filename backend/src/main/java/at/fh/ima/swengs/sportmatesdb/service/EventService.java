package at.fh.ima.swengs.sportmatesdb.service;

import at.fh.ima.swengs.sportmatesdb.model.Event;
import at.fh.ima.swengs.sportmatesdb.model.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event save(Event entity) {
        return eventRepository.save(entity);
    }

    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    public List<Event> getAllEventsFromUser(String username) {
        return eventRepository.findEventByUsersUsername(username);
    }
}
