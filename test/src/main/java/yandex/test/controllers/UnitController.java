package yandex.test.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnitController {

    @PostMapping("/imports")
    public HttpStatus importUnit(){
        return HttpStatus.OK;
    }


}
