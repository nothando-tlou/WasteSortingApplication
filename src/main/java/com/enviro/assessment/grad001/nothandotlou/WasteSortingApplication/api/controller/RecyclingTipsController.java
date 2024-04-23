package com.enviro.assessment.grad001.nothandotlou.WasteSortingApplication.api.controller;

import com.enviro.assessment.grad001.nothandotlou.WasteSortingApplication.api.model.RecyclingTips;
import com.enviro.assessment.grad001.nothandotlou.WasteSortingApplication.api.repository.RecyclingTipsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recycling-tips")
public class RecyclingTipsController {

    @Autowired
    private RecyclingTipsRepository recyclingTipsRepository;

    @GetMapping
    public ResponseEntity<List<RecyclingTips>> getAllRecyclingTips() {
        List<RecyclingTips> recyclingTips = recyclingTipsRepository.findAll();
        return ResponseEntity.ok(recyclingTips);
    }

    @PostMapping
    public ResponseEntity<RecyclingTips> createRecyclingTip(@Valid @RequestBody RecyclingTips recyclingTip) {
        RecyclingTips createdRecyclingTip = recyclingTipsRepository.save(recyclingTip);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRecyclingTip);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTips> updateRecyclingTip(@PathVariable Long id, @Valid @RequestBody RecyclingTips updatedRecyclingTip) {
        Optional<RecyclingTips> existingRecyclingTipOptional = recyclingTipsRepository.findById(id);
        if (existingRecyclingTipOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        RecyclingTips existingRecyclingTip = existingRecyclingTipOptional.get();
        existingRecyclingTip.setTip(updatedRecyclingTip.getTip());
        existingRecyclingTip.setTip(updatedRecyclingTip.getTip());
        RecyclingTips savedRecyclingTip = recyclingTipsRepository.save(existingRecyclingTip);
        return ResponseEntity.ok(savedRecyclingTip);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecyclingTip(@PathVariable Long id) {
        if (!recyclingTipsRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        recyclingTipsRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
