package yandex.test.controllers;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yandex.test.dto.UnitRequestDto;
import yandex.test.exceptions.GetResponse;
import yandex.test.exceptions.PostDelResponse;
import yandex.test.services.UnitService;

import java.util.UUID;

@RestController
public class UnitController {

    private final UnitService unitService;

    public UnitController(UnitService unitService){
        this.unitService = unitService;
    }

    @PostMapping("/imports")
    public ResponseEntity<PostDelResponse> importUnit(@RequestBody @Valid UnitRequestDto unitRequestDto ){
        unitService.save(unitRequestDto);
        return new ResponseEntity<>(new PostDelResponse(HttpStatus.OK.value(), "All done correctly"), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id:[a-zA-Z0-9-]+}")
    public ResponseEntity<PostDelResponse> deleteUnit(@PathVariable UUID id){
        unitService.delete(id);
        return new ResponseEntity<>(new PostDelResponse(HttpStatus.OK.value(), "All done correctly"), HttpStatus.OK);
    }

    @GetMapping(value = "/nodes/{id:[a-zA-Z0-9-]+}")
    public ResponseEntity<GetResponse> getUnit(@PathVariable UUID id){
        return unitService.get(id);
    }



}
























