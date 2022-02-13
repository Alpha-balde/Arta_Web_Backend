package com.ibmap.dental.rest.metada;

import com.ibmap.dental.domaine.entities.Metadata;
import com.ibmap.dental.rest.frontdto.Converter;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class MetadataConverter implements Converter<Metadata, MetadataFrontDto> {
    @Override
    public Metadata toEntity(@NonNull MetadataFrontDto frontDto) {
        return null;
    }

    @Override
    public MetadataFrontDto toFrontDto(@NonNull Metadata entity) {
        return null;
    }
}
