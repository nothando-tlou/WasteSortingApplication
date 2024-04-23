package com.enviro.assessment.grad001.nothandotlou.WasteSortingApplication.api.controller;

import com.enviro.assessment.grad001.nothandotlou.WasteSortingApplication.api.model.WasteCategory;
import com.enviro.assessment.grad001.nothandotlou.WasteSortingApplication.api.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/waste-categories")
public class WasteCategoryController {

    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    @GetMapping
    public ResponseEntity<List<WasteCategory>> getAllWasteCategories() {
        List<WasteCategory> wasteCategories = wasteCategoryRepository.findAll();
        return ResponseEntity.ok(wasteCategories);
    }

    @PostMapping
    public ResponseEntity<WasteCategory> createWasteCategory(@Valid @RequestBody WasteCategory wasteCategory) {
        WasteCategory createdWasteCategory = wasteCategoryRepository.save(wasteCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdWasteCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> updateWasteCategory(@PathVariable Long id, @Valid @RequestBody WasteCategory updatedWasteCategory) {
        Optional<WasteCategory> existingWasteCategoryOptional = wasteCategoryRepository.findById(id);
        if (existingWasteCategoryOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        WasteCategory existingWasteCategory = existingWasteCategoryOptional.get();
        existingWasteCategory.setName(updatedWasteCategory.getName());
        existingWasteCategory.setId(updatedWasteCategory.getId());
        WasteCategory savedWasteCategory = wasteCategoryRepository.save(existingWasteCategory);
        return ResponseEntity.ok(savedWasteCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWasteCategory(@PathVariable Long id) {
        if (!wasteCategoryRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        wasteCategoryRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
