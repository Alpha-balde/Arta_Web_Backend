package com.ibmap.dental.repositories;

import com.ibmap.dental.domaine.entities.Insurance;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends CommonsRepository<Insurance, Long>{
}
