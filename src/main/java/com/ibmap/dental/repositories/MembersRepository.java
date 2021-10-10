package com.ibmap.dental.repositories;

import com.ibmap.dental.domaine.entities.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembersRepository extends JpaRepository<Members, Long> {
}
