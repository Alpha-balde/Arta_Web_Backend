package com.ibmap.dental.repositories;

import com.ibmap.dental.domaine.entities.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CommonsRepository<Member,Long> {
}
