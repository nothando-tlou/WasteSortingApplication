package com.enviro.assessment.grad001.nothandotlou.WasteSortingApplication.api.repository;

import com.enviro.assessment.grad001.nothandotlou.WasteSortingApplication.api.model.DisposalGuidelines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisposalGuidelinesRepository extends JpaRepository<DisposalGuidelines, Long> {
}

