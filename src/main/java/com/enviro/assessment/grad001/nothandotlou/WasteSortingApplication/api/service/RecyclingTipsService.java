package com.enviro.assessment.grad001.nothandotlou.WasteSortingApplication.api.service;

import com.enviro.assessment.grad001.nothandotlou.WasteSortingApplication.api.model.RecyclingTips;
import com.enviro.assessment.grad001.nothandotlou.WasteSortingApplication.api.repository.RecyclingTipsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecyclingTipsService {

    @Autowired
    private RecyclingTipsRepository recyclingTipsRepository;

    public List<RecyclingTips> getAllRecyclingTips() {
        return recyclingTipsRepository.findAll();
    }

    public RecyclingTips createRecyclingTip(RecyclingTips recyclingTip) {
        return recyclingTipsRepository.save(recyclingTip);
    }

    public void deleteRecyclingTip(Long id) {
        recyclingTipsRepository.deleteById(id);
    }

}
