package com.enviro.assessment.grad001.nothandotlou.WasteSortingApplication;


import com.enviro.assessment.grad001.nothandotlou.WasteSortingApplication.api.model.RecyclingTips;
import com.enviro.assessment.grad001.nothandotlou.WasteSortingApplication.api.model.WasteCategory;
import com.enviro.assessment.grad001.nothandotlou.WasteSortingApplication.api.repository.RecyclingTipsRepository;
import com.enviro.assessment.grad001.nothandotlou.WasteSortingApplication.api.repository.WasteCategoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;



@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class RecyclingTipsRepositoryTests {
    private RecyclingTipsRepository recyclingRepository;

    @Autowired
    public RecyclingTipsRepositoryTests(RecyclingTipsRepository recyclingRepository){
        this.recyclingRepository = recyclingRepository;
    }
}
