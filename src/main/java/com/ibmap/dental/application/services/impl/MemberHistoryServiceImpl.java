package com.ibmap.dental.application.services.impl;

import com.ibmap.dental.application.services.MemberHistoryService;
import com.ibmap.dental.domaine.entities.MemberHistory;
import com.ibmap.dental.repositories.CommonsRepository;
import com.ibmap.dental.repositories.MemberHistoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MemberHistoryServiceImpl  implements MemberHistoryService {
    private MemberHistoryRepository memberHistoryRepository;

    public MemberHistoryServiceImpl(MemberHistoryRepository memberHistoryRepository) {
        this.memberHistoryRepository = memberHistoryRepository;
    }

    @Override
    public MemberHistory update(MemberHistory entity) {
        MemberHistory memberHistory = findByBusinessKey(entity.getBusinessKey());
        memberHistory.update(entity);
        return memberHistory;
    }

    @Override
    public CommonsRepository getRepo() {
        return memberHistoryRepository;
    }
}
