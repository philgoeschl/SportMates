package at.fh.ima.swengs.sportmatesdb.service;

import at.fh.ima.swengs.sportmatesdb.model.Event;
import at.fh.ima.swengs.sportmatesdb.model.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@SuppressWarnings("Duplicates")
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

    public Set<Event> getEvents(Set<String> dtos) {
        Set<Event> entities = new HashSet<>();
        if (dtos != null) {
            dtos.forEach((dto) -> entities.add(eventRepository.findById(dto).get()));
        }
        return entities;
    }
}
