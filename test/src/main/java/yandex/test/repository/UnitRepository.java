package yandex.test.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import yandex.test.models.Unit;

import java.time.LocalDateTime;
import java.util.UUID;

public interface UnitRepository extends CrudRepository<Unit, UUID> {

    public Iterable<Unit> findByUpdateDate(LocalDateTime updateDate);

    public Iterable<Unit> findByParentId(UUID id);

    public boolean existsByParentId(UUID id);

/*    @Query("SELECT type FROM Item AS i WHERE i.id= :id") просто будем иметь в виду, что есть такая возможность
    List<Unit> getChildren( @Param("id") UUID id);*/

}
