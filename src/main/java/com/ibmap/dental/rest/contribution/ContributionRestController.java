package com.ibmap.dental.rest.contribution;

import com.ibmap.dental.application.services.ContributionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/contibution")
public class ContributionRestController {
    private  ContributionConverter contributionConverter;
    private ContributionService contributionService;

    @Autowired
    public ContributionRestController(ContributionConverter contributionConverter, ContributionService contributionService) {
        this.contributionConverter = contributionConverter;
        this.contributionService = contributionService;
    }
}
