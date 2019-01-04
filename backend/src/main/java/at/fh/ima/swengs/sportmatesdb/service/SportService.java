package at.fh.ima.swengs.sportmatesdb.service;

import at.fh.ima.swengs.sportmatesdb.model.Event;
import at.fh.ima.swengs.sportmatesdb.model.Sport;
import at.fh.ima.swengs.sportmatesdb.model.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SportService {

    @Autowired
    public SportRepository sportRepository;

    public Sport save(Sport entity) {
        return sportRepository.save(entity);
    }

    public List<Sport> getAllSportsFromUser(String username) {
        return sportRepository.findSportsByUsersUsername(username);
    }

}
