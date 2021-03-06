package at.fh.ima.swengs.sportmatesdb.facade;

import at.fh.ima.swengs.sportmatesdb.dto.SportDTO;
import at.fh.ima.swengs.sportmatesdb.dto.UserDTO;
import at.fh.ima.swengs.sportmatesdb.model.Sport;
import at.fh.ima.swengs.sportmatesdb.model.User;
import at.fh.ima.swengs.sportmatesdb.service.EventService;
import at.fh.ima.swengs.sportmatesdb.service.SportService;
import at.fh.ima.swengs.sportmatesdb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@SuppressWarnings("Duplicates")

@Service()
@Transactional
public class SportFacade {

    @Autowired
    private UserService userService;

    @Autowired
    private SportService sportService;

    @Autowired
    private EventService eventService;


    void mapDtoToEntity(SportDTO dto, Sport entity) {
        entity.setSportName(dto.getSportName());
        entity.setSportDescription(dto.getSportDescription());
        entity.setTeam(dto.isTeam());
        entity.setTeamSize(dto.getTeamSize());
        entity.setSportPicture(dto.getSportPicture());
        entity.setUsers(userService.getUsersByName(dto.getUsers()));
        entity.setEvents(eventService.getEvents(dto.getEvents()));


    }

    private void mapEntityToDto(Sport entity, SportDTO dto) {

        dto.setId(entity.getId());
        dto.setSportName(entity.getSportName());
        dto.setSportDescription(entity.getSportDescription());
        dto.setTeam(entity.isTeam());
        dto.setTeamSize(entity.getTeamSize());
        dto.setSportPicture(entity.getSportPicture());
        dto.setUsers(entity.getUsers().stream().map(u -> u.getUsername()).collect(Collectors.toSet()));
        dto.setEvents(entity.getEvents().stream().map(e -> e.getId()).collect(Collectors.toSet()));
    }

    public SportDTO update(Long id, SportDTO dto) {
        Sport entity = sportService.findById(id).get();
        mapDtoToEntity(dto, entity);
        mapEntityToDto(sportService.save(entity), dto);
        return dto;
    }

    public SportDTO create(SportDTO dto) {
        Sport entity = new Sport();
        mapDtoToEntity(dto, entity);
        mapEntityToDto(sportService.save(entity), dto);
        return dto;
    }



    /*public SportDTO getByUsername(String username) {
        Sport entity = sportService.findBySportName(username).get();
        SportDTO dto = new SportDTO();
        mapEntityToDto(entity, dto);
        return dto;
    }*/


    public SportDTO getById(Long id) {
        Sport entity = sportService.findById(id).get();
        SportDTO dto = new SportDTO();
        mapEntityToDto(entity, dto);
        return dto;
    }

}
