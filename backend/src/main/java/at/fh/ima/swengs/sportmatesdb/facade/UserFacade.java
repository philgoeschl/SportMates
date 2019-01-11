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
        String passwordEncoded = encoder.encode(dto.getPassword());
        entity.setPassword(passwordEncoded);


        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setAdmin(dto.getAdmin());
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

        dto.setUsername(entity.getUsername());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setDayOfBirth(entity.getDayOfBirth());
        dto.setUserLocation(entity.getUserLocation());
        dto.setHomeTown(entity.getHomeTown());
        dto.setAdmin(entity.isAdmin());
        dto.seteMail(entity.geteMail());

        dto.setSports(entity.getSports().stream().map((s) -> s.getSportName()).collect(Collectors.toSet()));
        dto.setEvents(entity.getEvents().stream().map((e) -> e.getEventTitle()).collect(Collectors.toSet()));
        dto.setManagedEvents(entity.getManagedEvents().stream().map((e) -> e.getEventTitle()).collect(Collectors.toSet()));

    }

    public List<UserDTO> getAllUsers() {
        List<UserDTO> users = new ArrayList<>();

        userService.getAll().forEach(entity -> {
            UserDTO dto = new UserDTO();
            mapEntityToDto(entity,dto);
            users.add(dto);
        });

        return users;
    }

    public UserDTO getByUsername(String username) {
        User entity = userService.findByUserName(username).get();
        UserDTO dto = new UserDTO();
        mapEntityToDto(entity, dto);
        return dto;
    }

    public UserDTO update(String usernameId, UserDTO dto) {
        User entity = userService.findByUserName(usernameId).get();
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

}


