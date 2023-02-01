package yandex.test.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@Setter
@Getter

public class UnitRequestDto {

    List<UnitDto> units;
    LocalDateTime updateDate;

}
