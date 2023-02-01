package yandex.test.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "units")
public class Unit {

    @Id
    UUID id;
    String name;
    UUID parentId;
    @Enumerated(EnumType.STRING)
    Type type;
    Integer price;
    LocalDateTime updateDate;

}
