package com.ibmap.dental.application.services.impl;

import com.ibmap.dental.application.services.ContributionService;
import com.ibmap.dental.domaine.entities.Contribution;
import com.ibmap.dental.repositories.CommonsRepository;
import com.ibmap.dental.repositories.ContributionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ContributionServiceImpl  implements ContributionService {

    ContributionRepository contributionRepository;

    public ContributionServiceImpl(ContributionRepository contributionRepository) {
        this.contributionRepository = contributionRepository;
    }



    @Override
    public Contribution update(Contribution entity) {
        Contribution contribution = findByBusinessKey(entity.getBusinessKey());
        contribution.update(entity);

        return save(contribution);
    }

    @Override
    public CommonsRepository getRepo() {
        return contributionRepository;
    }
}
