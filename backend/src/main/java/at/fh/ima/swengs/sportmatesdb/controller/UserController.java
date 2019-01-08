package at.fh.ima.swengs.sportmatesdb.controller;

import at.fh.ima.swengs.sportmatesdb.dto.UserDTO;
import at.fh.ima.swengs.sportmatesdb.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {



    @Autowired
    private UserFacade userFacade;

    @GetMapping("/users/")
    List<UserDTO> getAllUsers() {
        return userFacade.getAllUsers();
    }

    @GetMapping("/users/{username}")
    UserDTO getById(@PathVariable String username) {
        return userFacade.getByUsername(username);
    }

    @PostMapping("/users")
    UserDTO create(@RequestBody @Valid UserDTO dto) {
        return userFacade.create(dto);
    }

    @PutMapping("/users/{username}")
    UserDTO update(@RequestBody @Valid UserDTO dto, @PathVariable String username) {
        return userFacade.update(username, dto);
    }
}
