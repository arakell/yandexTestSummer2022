package yandex.test.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yandex.test.models.Type;

import java.util.UUID;
@Setter
@Getter
@NoArgsConstructor

public class UnitDto {

    UUID id;
    String name;
    UUID parentId;
    Integer price;
    @Enumerated(EnumType.STRING)
    Type Type;


}
