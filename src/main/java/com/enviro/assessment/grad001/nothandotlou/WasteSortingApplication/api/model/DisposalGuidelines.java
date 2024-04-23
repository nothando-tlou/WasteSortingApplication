package com.enviro.assessment.grad001.nothandotlou.WasteSortingApplication.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;



@Entity
public class DisposalGuidelines {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;
    private String guidelines;

    public DisposalGuidelines() {
    }

    public DisposalGuidelines(Long id, String category, String guidelines) {
        this.id = id;
        this.category = category;
        this.guidelines = guidelines;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGuidelines() {
        return guidelines;
    }

    public void setGuidelines(String guidelines) {
        this.guidelines = guidelines;
    }
}
