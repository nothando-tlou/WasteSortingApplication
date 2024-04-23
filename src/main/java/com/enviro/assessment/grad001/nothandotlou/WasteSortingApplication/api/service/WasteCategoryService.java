package com.enviro.assessment.grad001.nothandotlou.WasteSortingApplication.api.service;

import com.enviro.assessment.grad001.nothandotlou.WasteSortingApplication.api.model.WasteCategory;
import com.enviro.assessment.grad001.nothandotlou.WasteSortingApplication.api.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WasteCategoryService {

    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    public List<WasteCategory> getAllWasteCategories() {
        return wasteCategoryRepository.findAll();
    }

    public WasteCategory createWasteCategory(WasteCategory wasteCategory) {
        return wasteCategoryRepository.save(wasteCategory);
    }

    public void deleteWasteCategory(Long id) {
        wasteCategoryRepository.deleteById(id);
    }

    public Optional<WasteCategory> getWasteCategoriesStartingWith(String prefix) {
        return wasteCategoryRepository.findById(Long.valueOf(prefix));
    }
}
