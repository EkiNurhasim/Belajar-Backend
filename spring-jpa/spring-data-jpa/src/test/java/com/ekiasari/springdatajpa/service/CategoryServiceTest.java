package com.ekiasari.springdatajpa.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    void testCreate() {
        assertThrows(RuntimeException.class, () -> {
            categoryService.create();
        });
    }

    @Test
    void testCrateCategories() {
        assertThrows(RuntimeException.class, () -> {
            categoryService.createCategories();
        });
    }

    @Test
    void testTestCrateCategories() {
        assertThrows(RuntimeException.class, () -> {
            categoryService.createCategoriesTest();
        });
    }

    @Test
    void testTest() {
        assertThrows(RuntimeException.class, () -> {
            categoryService.createTest();
        });
    }
}
