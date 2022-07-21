package com.ibmap.dental.application.services.impl;

import com.ibmap.dental.application.services.MetadataService;
import com.ibmap.dental.domaine.entities.Metadata;
import com.ibmap.dental.repositories.CommonsRepository;
import com.ibmap.dental.repositories.MetadataRepository;

public class MetadataServiceImpl  implements MetadataService {

    private MetadataRepository metadataRepository;

    public MetadataServiceImpl(MetadataRepository metadataRepository) {
        this.metadataRepository = metadataRepository;
    }

    @Override
    public Metadata update(Metadata entity) {
        Metadata metadata = findByBusinessKey(entity.getBusinessKey());
        metadata.update(entity);
        return metadata;
    }

    @Override
    public CommonsRepository getRepo() {
        return metadataRepository;
    }

}
