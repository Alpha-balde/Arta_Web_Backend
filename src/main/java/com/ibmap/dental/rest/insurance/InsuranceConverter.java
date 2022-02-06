package com.ibmap.dental.rest.insurance;

import com.ibmap.dental.domaine.entities.Insurance;
import com.ibmap.dental.rest.frontdto.Converter;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class InsuranceConverter implements Converter<Insurance,InsuranceFrontDto> {

    @Override
    public Insurance toEntity(@NonNull InsuranceFrontDto frontDto) {
        return null;
    }

    @Override
    public InsuranceFrontDto toFrontDto(@NonNull Insurance entity) {
        return null;
    }
}
