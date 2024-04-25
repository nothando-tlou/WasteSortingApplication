package com.enviro.assessment.grad001.nothandotlou.WasteSortingApplication;


import com.enviro.assessment.grad001.nothandotlou.WasteSortingApplication.api.model.WasteCategory;
import com.enviro.assessment.grad001.nothandotlou.WasteSortingApplication.api.repository.WasteCategoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class WasteRepositoryTests {
    @Autowired
    private WasteCategoryRepository repository;

    @Test
    public void WasteCategoryRepository_SaveAll_ReturnSavedCategory(){
        //Arrange
        WasteCategory wastecategory = WasteCategory.builder()
                .name("plastic")
                .name("water bottles").build();


        //Act
        WasteCategory savedCategory = repository.save(wastecategory);


        //Assert
        Assertions.assertThat(savedCategory).isNotNull();
        Assertions.assertThat(savedCategory.getId()).isGreaterThan(0);
    }

    @Test
    public void WasteCategoryRepository_GetAll_ReturnMoreThanOneCategory(){
        //Arrange
        WasteCategory wasteCategory = WasteCategory.builder()
                .name("plastic")
                .name("water bottles").build();
        WasteCategory wasteCategory1 = WasteCategory.builder()
                .name("glass")
                .name("glass bottles").build();

        //Act
        repository.save(wasteCategory);
        repository.save(wasteCategory1);

        List<WasteCategory> wasteCategoryList = repository.findAll();

        //Assert
        Assertions.assertThat(wasteCategoryList).isNotNull();
        Assertions.assertThat(wasteCategoryList.size()).isEqualTo(2);

    }
}
