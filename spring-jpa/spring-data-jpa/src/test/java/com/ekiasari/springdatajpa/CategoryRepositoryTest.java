package com.ekiasari.springdatajpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import com.ekiasari.springdatajpa.entity.Category;
import com.ekiasari.springdatajpa.repository.CategoryRepository;

@SpringBootTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void testCreate() {
        Category category = new Category();
        category.setName("Orange");

        categoryRepository.save(category);
        assertNotNull(category.getId());
    }

    @Test
    void testUpdate() {
        Category category = categoryRepository.findById(1L).orElse(null);
        assertNotNull(category);

        category.setName("White");
        categoryRepository.save(category);

        category = categoryRepository.findById(1L).orElse(null);
        assertNotNull(category);
        assertEquals("White", category.getName());
    }

    @Test
    void testName() {
        Category category = categoryRepository.findFirstByNameEquals("Orange").orElse(null);
        assertNotNull(category);
        assertEquals("Orange", category.getName());

        List<Category> categories = categoryRepository.findAllByNameLike("%White%");
        assertEquals(1, categories.size());
        assertEquals("White", categories.get(0).getName());
    }

    @Test
    void testAudit() {
        Category category = new Category();
        category.setName("Sample Audit");
        categoryRepository.save(category);

        assertNotNull(category.getId());
        assertNotNull(category.getCreatedDate());
        assertNotNull(category.getLastModifiedDate());

    }

    @Test
    void testExample() {
        Category category = new Category();
        category.setName("Orange"); // where name = Orange

        Example<Category> example = Example.of(category);

        List<Category> categories = categoryRepository.findAll(example);
        assertEquals(1, categories.size());
    }

    @Test
    void testExampleMatcher() {
        Category category = new Category();
        category.setName("wHiTe");

        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withIgnoreNullValues();
        Example<Category> exmaple = Example.of(category, matcher);

        List<Category> categories = categoryRepository.findAll(exmaple);
        assertEquals(1, categories.size());
    }

}
