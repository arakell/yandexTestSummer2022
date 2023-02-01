package yandex.test.services;

import org.springframework.stereotype.Service;
import yandex.test.dto.UnitDto;
import yandex.test.dto.UnitRequestDto;
import yandex.test.models.Unit;
import yandex.test.repository.UnitRepository;

@Service
public class UnitService {

    private final UnitRepository unitRepository;

    public UnitService(UnitRepository unitRepository){ this.unitRepository = unitRepository;};

    public void save(UnitRequestDto unitRequestDto){
        Unit unit = new Unit();
        for(UnitDto UD: unitRequestDto.getUnits()){
            System.out.println();
            unit.setId(UD.getId());
            System.out.println();
            unit.setName(UD.getName());
            unit.setType(UD.getType());
            unit.setPrice(UD.getPrice());
            unit.setParentId(UD.getParentId());
            unit.setUpdateDate(unitRequestDto.getUpdateDate());
            System.out.println();
            unitRepository.save(unit);
        }
        //org.springframework.beans.BeanUtils.copyProperties(unitRequestDto, unit);

    }


}
