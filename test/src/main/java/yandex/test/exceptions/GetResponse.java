package yandex.test.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yandex.test.dto.UnitDto;
import yandex.test.models.Type;
import yandex.test.models.Unit;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class GetResponse {

    UUID id;
    String name;
    Type type;
    UUID parentId;
    @JsonProperty("date")
    Date updateDate;
    Double price;
    List<GetResponse> children;

}
