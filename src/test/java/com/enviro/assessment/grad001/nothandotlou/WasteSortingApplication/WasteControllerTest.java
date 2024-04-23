//package com.enviro.assessment.grad001.nothandotlou.WasteSortingApplication;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class WasteControllerTest {
//
//    @Mock
//    private WasteCategoryRepository wasteCategoryRepository;
//
//    @InjectMocks
//    private WasteCategoryController wasteCategoryController;
//
//    @Test
//    public void testGetAllWasteCategories() {
//        List<WasteCategory> wasteCategories = new ArrayList<>();
//        wasteCategories.add(new WasteCategory(1L, "Plastic"));
//        when(wasteCategoryRepository.findAll()).thenReturn(wasteCategories);
//
//        ResponseEntity<List<WasteCategory>> response = wasteCategoryController.getAllWasteCategories();
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(wasteCategories, response.getBody());
//    }
//
//}
