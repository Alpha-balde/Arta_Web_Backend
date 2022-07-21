package com.ibmap.dental.application.services.impl;

import com.ibmap.dental.application.services.FamilyService;
import com.ibmap.dental.domaine.entities.Family;
import com.ibmap.dental.repositories.CommonsRepository;
import com.ibmap.dental.repositories.FamilyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FamilyServiceImpl implements FamilyService {
    FamilyRepository familyRepository;

    public FamilyServiceImpl(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }

    @Override
    public Family update(Family entity) {
        Family family = findByBusinessKey(entity.getBusinessKey());
        family.update(entity);
        return family;
    }

    @Override
    public CommonsRepository getRepo() {
        return familyRepository;
    }
}
