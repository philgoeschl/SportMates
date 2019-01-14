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



    @GetMapping("/sports/{id}")
    SportDTO getById(@PathVariable Long id) {
        return sportFacade.getById(id);
    }

    @PostMapping("/sports")
    SportDTO create(@RequestBody @Valid SportDTO dto) {
        return sportFacade.create(dto);
    }

    @PutMapping("/sports/{id}")
    SportDTO update(@RequestBody @Valid SportDTO dto, @PathVariable Long id) {
        return sportFacade.update(id, dto);
    }

}
