package yandex.test.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    String name;
    UUID parentId;
    @Min(0) //не исключает возможности назначить price - null
    Integer price;
    @Enumerated(EnumType.STRING)
    Type Type;

}
