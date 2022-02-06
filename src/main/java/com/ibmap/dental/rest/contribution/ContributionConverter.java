package com.ibmap.dental.rest.contribution;

import com.ibmap.dental.domaine.entities.Contribution;
import com.ibmap.dental.rest.frontdto.Converter;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class ContributionConverter implements Converter<Contribution, ContributionFrontDto> {
    @Override
    public Contribution toEntity(@NonNull ContributionFrontDto frontDto) {
        return null;
    }

    @Override
    public ContributionFrontDto toFrontDto(@NonNull Contribution entity) {
        return null;
    }
}
