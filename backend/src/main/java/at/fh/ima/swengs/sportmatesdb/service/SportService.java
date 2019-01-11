package at.fh.ima.swengs.sportmatesdb.service;

import at.fh.ima.swengs.sportmatesdb.model.Event;
import at.fh.ima.swengs.sportmatesdb.model.Sport;
import at.fh.ima.swengs.sportmatesdb.model.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@SuppressWarnings("Duplicates")
@Service()
public class SportService {

    @Autowired
    public SportRepository sportRepository;

    public Sport save(Sport entity) {
        return sportRepository.save(entity);
    }

    /*public List<Sport> getAllSportsFromUser(String username) {
        return sportRepository.findSportsByUsersUsername(username);
    }*/

    public Set<Sport> getSports(Set<Long> dtos) {
        Set<Sport> entities = new HashSet<>();
        if (dtos != null) {
            dtos.forEach((dto) -> entities.add(sportRepository.findById(dto).get()));
        }
        return entities;
    }

    /*public Optional<Sport> findBySportName(String sportName) {
        return sportRepository.findBySportName(sportName);
    }

    public List<Sport> getAllSports() {
        return sportRepository.findAll();}*/

    public Optional<Sport> findById(Long id) {
        return sportRepository.findById(id);
    }

}
