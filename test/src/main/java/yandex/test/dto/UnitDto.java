package yandex.test.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import yandex.test.models.Type;
import java.time.LocalDateTime;
import java.util.UUID;
@Setter
@Getter
@NoArgsConstructor

public class UnitDto {

    UUID id;
    String name;
    UUID parentId;
    @Enumerated(EnumType.STRING)
    Type type;
    Integer price;

}
