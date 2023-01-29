package yandex.test.repository;

import org.springframework.data.repository.CrudRepository;
import yandex.test.models.Unit;

import java.util.UUID;

public interface UnitRepository extends CrudRepository<Unit, UUID> {



}
