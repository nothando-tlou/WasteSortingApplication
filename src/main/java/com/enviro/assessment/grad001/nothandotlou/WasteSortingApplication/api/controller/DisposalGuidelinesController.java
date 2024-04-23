package com.enviro.assessment.grad001.nothandotlou.WasteSortingApplication.api.controller;

import com.enviro.assessment.grad001.nothandotlou.WasteSortingApplication.api.model.DisposalGuidelines;
import com.enviro.assessment.grad001.nothandotlou.WasteSortingApplication.api.repository.DisposalGuidelinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disposal-guidelines")
public class DisposalGuidelinesController {

    @Autowired
    private DisposalGuidelinesRepository disposalGuidelinesRepository;

    @GetMapping
    public ResponseEntity<List<DisposalGuidelines>> getAllDisposalGuidelines() {
        List<DisposalGuidelines> disposalGuidelines = disposalGuidelinesRepository.findAll();
        return ResponseEntity.ok(disposalGuidelines);
    }

    @PostMapping
    public ResponseEntity<DisposalGuidelines> createDisposalGuideline(@Valid @RequestBody DisposalGuidelines disposalGuideline) {
        DisposalGuidelines createdDisposalGuideline = disposalGuidelinesRepository.save(disposalGuideline);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDisposalGuideline);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuidelines> updateDisposalGuideline(@PathVariable Long id, @Valid @RequestBody DisposalGuidelines updatedDisposalGuideline) {
        Optional<DisposalGuidelines> existingDisposalGuidelineOptional = disposalGuidelinesRepository.findById(id);
        if (existingDisposalGuidelineOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        DisposalGuidelines existingDisposalGuideline = existingDisposalGuidelineOptional.get();
        existingDisposalGuideline.setId(updatedDisposalGuideline.getId());
        existingDisposalGuideline.setId(updatedDisposalGuideline.getId());
        DisposalGuidelines savedDisposalGuideline = disposalGuidelinesRepository.save(existingDisposalGuideline);
        return ResponseEntity.ok(savedDisposalGuideline);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisposalGuideline(@PathVariable Long id) {
        if (!disposalGuidelinesRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        disposalGuidelinesRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
