package yandex.test.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Units")
public class Unit {
    @Id
    UUID id;
    String name;
    UUID parentId;
    @Enumerated(EnumType.STRING)
    Type type;
    Integer price;
    LocalDateTime updateTime; //но может лучше Date или что-то ещё

}
