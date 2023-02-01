package yandex.test.controllers;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yandex.test.dto.UnitRequestDto;
import yandex.test.models.Unit;
import yandex.test.services.UnitService;

@RestController
public class UnitController {

    private final UnitService UnitService;

    public UnitController(UnitService UnitService){
        this.UnitService = UnitService;
    }

    @PostMapping("/imports")
    public HttpStatus importUnit(@RequestBody UnitRequestDto unitRequestDto ){
        System.out.println();
        UnitService.save(unitRequestDto);
        return HttpStatus.OK;
    }


}
