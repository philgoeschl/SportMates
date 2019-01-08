package at.fh.ima.swengs.sportmatesdb.service;

import at.fh.ima.swengs.sportmatesdb.model.Event;
import at.fh.ima.swengs.sportmatesdb.model.EventRepository;
import at.fh.ima.swengs.sportmatesdb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@SuppressWarnings("Duplicates")
@Service()
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

    public Optional<Event> findById(String eventID) {
        return eventRepository.findById(eventID);
    }


}