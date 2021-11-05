package com.ibmap.dental.rest.frontdto;

import com.ibmap.dental.domaine.BasicEntity;

import java.util.List;
import java.util.stream.Collectors;

public interface Converter <E extends BasicEntity, D extends FrontDto> {

    E toEntity(D frontDto);

    default List<E> toEntities(List<D> frontDtos) {
        return frontDtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    D toFrontDto(E entity);

    default List<D> toFrontDtos(List<E> entities) {
        return entities.stream()
                .map(this::toFrontDto)
                .collect(Collectors.toList());
    }
}
