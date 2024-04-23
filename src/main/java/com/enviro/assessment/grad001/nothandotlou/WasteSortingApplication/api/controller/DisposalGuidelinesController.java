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

    @GetMapping // Reading
    public ResponseEntity<List<DisposalGuidelines>> getAllDisposalGuidelines() {
        // Retrieving all disposal guidelines from the repository
        List<DisposalGuidelines> disposalGuidelines = disposalGuidelinesRepository.findAll();
        //Responding with the retrieved dataa
        return ResponseEntity.ok(disposalGuidelines);
    }

    @PostMapping // Creating
    public ResponseEntity<DisposalGuidelines> createDisposalGuideline(@Valid @RequestBody DisposalGuidelines disposalGuideline) {
        //this will save the newly created disposal guideline
        DisposalGuidelines createdDisposalGuideline = disposalGuidelinesRepository.save(disposalGuideline);
        //This will also retrieve and respond with data , bring back status of the guideline .
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDisposalGuideline);
    }

    @PutMapping("/{id}") // Updating
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

    @DeleteMapping("/{id}") // deleting
    public ResponseEntity<Void> deleteDisposalGuideline(@PathVariable Long id) {
        if (!disposalGuidelinesRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        disposalGuidelinesRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
