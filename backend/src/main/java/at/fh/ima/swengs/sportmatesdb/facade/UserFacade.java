package at.fh.ima.swengs.sportmatesdb.facade;

import at.fh.ima.swengs.sportmatesdb.dto.UserDTO;
import at.fh.ima.swengs.sportmatesdb.model.User;
import at.fh.ima.swengs.sportmatesdb.service.EventService;
import at.fh.ima.swengs.sportmatesdb.service.SportService;
import at.fh.ima.swengs.sportmatesdb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service()
@Transactional
public class UserFacade {

    @Autowired @Lazy
    private BCryptPasswordEncoder encoder;

    @Autowired
    private UserService userService;

    @Autowired
    private SportService sportService;

    @Autowired
    private EventService eventService;


    void mapDtoToEntity(UserDTO dto, User entity) {

        entity.setEncodeNumber(dto.getEncodeNumber());
        int versionNumber = dto.getEncodeNumber();
        if ( versionNumber == 1) {
            String passwordEncoded = encoder.encode(dto.getPassword());
            entity.setPassword(passwordEncoded);
            entity.setEncodeNumber(0);
        }
        else{
            entity.setPassword(dto.getPassword());
        }

        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setAdmin(dto.isAdmin());
        entity.setDayOfBirth(dto.getDayOfBirth());
        entity.setUsername(dto.getUsername());
        entity.setHomeTown(dto.getHomeTown());
        entity.setUserLocation(dto.getUserLocation());
        entity.seteMail(dto.geteMail());
        entity.setSports(sportService.getSports(dto.getSports()));
        //entity.setEvents(eventService.getEvents(dto.getEvents()));
        //entity.setManagedEvents(eventService.getEvents(dto.getManagedEvents()));
    }

    private void mapEntityToDto(User entity, UserDTO dto) {

        dto.setEncodeNumber(entity.getEncodeNumber());
        dto.setPassword(entity.getPassword());
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setDayOfBirth(entity.getDayOfBirth());
        dto.setUserLocation(entity.getUserLocation());
        dto.setHomeTown(entity.getHomeTown());
        dto.setAdmin(entity.isAdmin());
        dto.seteMail(entity.geteMail());
        dto.setSports(entity.getSports().stream().map((s) -> s.getId()).collect(Collectors.toSet()));
        //dto.setEvents(entity.getEvents().stream().map((e) -> e.getEventTitle()).collect(Collectors.toSet()));
        //dto.setManagedEvents(entity.getManagedEvents().stream().map((e) -> e.getEventTitle()).collect(Collectors.toSet()));

    }



    public UserDTO getByUsername(String username) {
        User entity = userService.findByUserName(username).get();
        UserDTO dto = new UserDTO();
        mapEntityToDto(entity, dto);
        return dto;
    }

    public UserDTO update(Long id, UserDTO dto) {
        User entity = userService.findById(id).get();
        mapDtoToEntity(dto, entity);
        mapEntityToDto(userService.save(entity), dto);
        return dto;
    }

    public UserDTO create(UserDTO dto) {
        User entity = new User();
        mapDtoToEntity(dto, entity);
        mapEntityToDto(userService.save(entity), dto);
        return dto;
    }

    public UserDTO getById(Long id) {
        User entity = userService.findById(id).get();
        UserDTO dto = new UserDTO();
        mapEntityToDto(entity, dto);
        return dto;
    }

    public List<UserDTO> getAllUsers() {
        List<UserDTO> users = new ArrayList<>();

        userService.getUsers().forEach(entity -> {
            UserDTO dto = new UserDTO();
            mapEntityToDto(entity,dto);
            users.add(dto);
        });

        return users;
    }

}


