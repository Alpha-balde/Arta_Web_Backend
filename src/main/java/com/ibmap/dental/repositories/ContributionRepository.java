package com.ibmap.dental.repositories;

import com.ibmap.dental.domaine.entities.Contribution;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContributionRepository extends CommonsRepository<Contribution,Long> {


}
