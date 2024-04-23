package com.enviro.assessment.grad001.nothandotlou.WasteSortingApplication.api.repository;

import com.enviro.assessment.grad001.nothandotlou.WasteSortingApplication.api.model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long> {
}
