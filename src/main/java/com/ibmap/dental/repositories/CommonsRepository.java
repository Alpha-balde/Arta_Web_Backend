package com.ibmap.dental.repositories;


import com.ibmap.dental.domaine.BasicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;


@NoRepositoryBean
public interface CommonsRepository<T extends BasicEntity, ID extends Long> extends JpaRepository<T, ID> {
    Optional<T> findByBusinessKey(String businessKey);
    void deleteByBusinessKey(String businessKey);
}
