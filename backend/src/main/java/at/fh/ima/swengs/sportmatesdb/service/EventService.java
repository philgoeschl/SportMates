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

@Service()
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event save(Event entity) {
        return eventRepository.save(entity);
    }

<<<<<<< HEAD
    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    public List<Event> getAll() {
=======
    /*public List<Event> getAll() {
>>>>>>> master
        return eventRepository.findAll();
    }*/

    /*public List<Event> getAllEventsFromUser(String username) {
<<<<<<< HEAD
        return eventRepository.findByUsername(username);
    }
=======
        return eventRepository.findEventByUsersUsername(username);
    }*/
>>>>>>> master

    public Set<Event> getEvents(Set<Long> dtos) {
        Set<Event> entities = new HashSet<>();
        if (dtos != null) {
            dtos.forEach((dto) -> entities.add(eventRepository.findById(dto).get()));
        }
        return entities;
    }

<<<<<<< HEAD
    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }*/
=======
    public Optional<Event> findById(Long eventID) {
        return eventRepository.findById(eventID);
    }
>>>>>>> master


}
