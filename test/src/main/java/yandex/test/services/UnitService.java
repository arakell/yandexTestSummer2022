package yandex.test.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import yandex.test.dto.UnitDto;
import yandex.test.dto.UnitRequestDto;
import yandex.test.exceptions.GetResponse;
import yandex.test.exceptions.PostDelResponse;
import yandex.test.models.Type;
import yandex.test.models.Unit;
import yandex.test.repository.UnitRepository;

import java.util.*;

@Service
public class UnitService {

    private final UnitRepository unitRepository;

    public UnitService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    ;

    public void save(UnitRequestDto unitRequestDto) {
        Unit unit = new Unit();
/*        решили, что транзации не нужны, то что вставилось - пусть будет, и просто выдаём исключение,
                если дошли до проблемного места */
        for (UnitDto UD : unitRequestDto.getItems()) {

            if(unitRepository.existsById(UD.getId()) &&
                    unitRepository.findById(UD.getId()).get().getType() != UD.getType())
                throw new IllegalStateException("Type is changed");

            if(UD.getParentId() != null && unitRepository.existsById(UD.getParentId()) &&
                    unitRepository.findById(UD.getParentId()).get().getType() != Type.CATEGORY)
                throw new IllegalStateException("ParentId not CATEGORY");

            if(UD.getType() == Type.CATEGORY && UD.getPrice() != null)
                throw new IllegalStateException("Price of CATEGORY not null");

            if(UD.getType() == Type.OFFER && UD.getPrice() == null)
                throw new IllegalStateException("Price of OFFER is null");

            if(unitRepository.existsById(UD.getId())
                    && unitRepository.findById(UD.getId()).get().getUpdateDate() == unitRequestDto.getUpdateDate())
                throw new IllegalStateException("Dublicate of id in request");

            org.springframework.beans.BeanUtils.copyProperties(UD, unit);
            unit.setUpdateDate(unitRequestDto.getUpdateDate());
            unitRepository.save(unit);
        }
    }

    public void delete(UUID id){

        if(!unitRepository.existsById(id)) throw new NoSuchElementException("Item not found");
        unitRepository.deleteById(id);
    }





    private List<GetResponse> getChildren(UUID id){
        List<GetResponse> childrens = new ArrayList<>();
        if(unitRepository.findById(id).get().getType() == Type.OFFER) return null;
        Iterable<Unit> units = unitRepository.findByParentId(id);
        for(Unit unit: units){
            GetResponse getResponse = new GetResponse();
            org.springframework.beans.BeanUtils.copyProperties(unit, getResponse);
            if(getResponse.getType() == Type.OFFER) getResponse.setPrice(unit.getPrice().doubleValue());
            getResponse.setChildren(getChildren(getResponse.getId()));
            childrens.add(getResponse);
        }
        return childrens;
    }

    private Double getAveragePrice(GetResponse unit){
        System.out.println();
        if(unit.getChildren().stream().filter(u->u.getType() == Type.OFFER).count() > 0){
            Double averagePrice = unit.getChildren().stream().filter(u->u.getType() == Type.OFFER).mapToDouble(u->u.getPrice()).average().getAsDouble();
            return averagePrice;
        }

        return null;



    }

    public ResponseEntity<GetResponse> get(UUID id){

        if(!unitRepository.existsById(id)) throw new NoSuchElementException("Item not found");

        ResponseEntity<GetResponse> responseEntity;
        GetResponse getResponse = new GetResponse();
        org.springframework.beans.BeanUtils.copyProperties(unitRepository.findById(id).get(), getResponse);

        List<GetResponse> childrens = getChildren(id);
        getResponse.setChildren(childrens);


        for(GetResponse child: childrens){
            if(child.getType() == Type.OFFER) continue;
            if(child.getChildren() != null) child.setPrice(getAveragePrice(child));

        }
        if(childrens != null && !childrens.isEmpty() && childrens.stream().filter(child->child.getPrice()!=null).count()>0) getResponse.setPrice(childrens.stream().filter(u->u.getPrice()!=null).mapToDouble(u->u.getPrice()).average().getAsDouble());
        else getResponse.setPrice(null);
        responseEntity = new ResponseEntity<>(getResponse, HttpStatus.OK);
        return responseEntity;

    }

}



