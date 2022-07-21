package com.ibmap.dental.application.services.impl;

import com.ibmap.dental.application.services.InsuranceService;
import com.ibmap.dental.domaine.entities.Insurance;
import com.ibmap.dental.repositories.CommonsRepository;
import com.ibmap.dental.repositories.InsuranceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InsuranceServiceImpl  implements InsuranceService {
    private InsuranceRepository insuranceRepository;

    @Autowired
    public InsuranceServiceImpl(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    @Override
    public Insurance update(Insurance entity) {
        Insurance insurance = findByBusinessKey(entity.getBusinessKey());
        insurance.update(entity);
        return insurance;
    }

    @Override
    public CommonsRepository getRepo() {
        return insuranceRepository;
    }
}
