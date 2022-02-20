package com.ibmap.dental.repositories;

import com.ibmap.dental.domaine.entities.MemberHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberHistoryRepository extends CommonsRepository<MemberHistory,Long> {
}
