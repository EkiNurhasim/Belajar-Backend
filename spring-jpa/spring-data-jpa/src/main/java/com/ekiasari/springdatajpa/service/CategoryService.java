package com.ekiasari.springdatajpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionOperations;

import com.ekiasari.springdatajpa.entity.Category;
import com.ekiasari.springdatajpa.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TransactionOperations transactionOperations;

    public void error() {
        throw new RuntimeException("Ups rollback please");
    }

    public void createCategories() {
        transactionOperations.executeWithoutResult(transactionOperations -> {
            for (int i = 0; i < 5; i++) {
                Category category = new Category();
                category.setName("Name : " + i);
                categoryRepository.save(category);
            }
            error();
        });
    }

    @Transactional
    public void create() {
        for (int i = 0; i < 5; i++) {
            Category category = new Category();
            category.setName("Name : " + i);
            categoryRepository.save(category);
        }
        throw new RuntimeException("Ups rollback please");
    }

    public void createTest() {
        create();
    }

    public void createCategoriesTest() {
        createCategories();
    }
}
