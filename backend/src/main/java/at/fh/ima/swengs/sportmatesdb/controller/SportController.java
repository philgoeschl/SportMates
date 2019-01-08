package at.fh.ima.swengs.sportmatesdb.controller;

import at.fh.ima.swengs.sportmatesdb.dto.SportDTO;
import at.fh.ima.swengs.sportmatesdb.facade.SportFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SportController {

    @Autowired
    private SportFacade sportFacade;

    @GetMapping("/sports/")
    List<SportDTO> getAllSports() {
        return sportFacade.getAllSports();
    }

    @GetMapping("/sports/{sportname}")
    SportDTO getById(@PathVariable String sportName) {
        return sportFacade.getByUsername(sportName);
    }

    @PostMapping("/sports")
    SportDTO create(@RequestBody @Valid SportDTO dto) {
        return sportFacade.create(dto);
    }

    @PutMapping("/sports/{sportname}")
    SportDTO update(@RequestBody @Valid SportDTO dto, @PathVariable String sportName) {
        return sportFacade.update(sportName, dto);
    }

}
