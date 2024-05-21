package com.ekiasari.springdatajpa.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.support.TransactionOperations;

import com.ekiasari.springdatajpa.entity.Category;
import com.ekiasari.springdatajpa.entity.Product;
import com.ekiasari.springdatajpa.repository.CategoryRepository;
import com.ekiasari.springdatajpa.repository.ProductRepository;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TransactionOperations transactionOperations;

    @Test
    void testCreate() {
        Category category = categoryRepository.findById(1L).orElse(null);
        assertNotNull(category);

        {
            Product product = new Product();
            product.setName("Apple Iphone 14 Pro Max");
            product.setPrice(25_000_000L);
            product.setCategory(category);
            productRepository.save(product);
        }
        {
            Product product = new Product();
            product.setName("Apple Iphone 15 Pro Max");
            product.setPrice(30_000_000L);
            product.setCategory(category);
            productRepository.save(product);
        }
    }

    @Test
    void testFindAllByCategory_Name() {
        List<Product> products = productRepository.findAllByCategory_Name("White");
        assertEquals(2, products.size());
        assertEquals("Apple Iphone 14 Pro Max", products.get(0).getName());
        assertEquals("Apple Iphone 15 Pro Max", products.get(1).getName());
    }

    @Test
    void testSort() {
        Sort sort = Sort.by(Sort.Order.desc("id"));
        List<Product> products = productRepository.findAllByCategory_Name("White", sort);
        assertEquals(2, products.size());
        assertEquals("Apple Iphone 14 Pro Max", products.get(0).getName());
        assertEquals("Apple Iphone 15 Pro Max", products.get(1).getName());
    }

    @Test
    void testPageable() {
        // Page 0
        Pageable pageable = PageRequest.of(0, 1, Sort.by(Sort.Order.asc("id")));
        Page<Product> products = productRepository.findAllByCategory_Name("White", pageable);
        assertEquals(1, products.getContent().size());
        assertEquals(0, products.getNumber());
        assertEquals(2, products.getTotalElements());
        assertEquals(2, products.getTotalPages());
        assertEquals("Apple Iphone 14 Pro Max", products.getContent().get(0).getName());

        // Page 1`
        pageable = PageRequest.of(1, 1, Sort.by(Sort.Order.asc("id")));
        products = productRepository.findAllByCategory_Name("White", pageable);
        assertEquals(1, products.getContent().size());
        assertEquals(1, products.getNumber());
        assertEquals(2, products.getTotalElements());
        assertEquals(2, products.getTotalPages());
        assertEquals("Apple Iphone 15 Pro Max", products.getContent().get(0).getName());
    }

    @Test
    void countByCategory_Name() {
        Long products = productRepository.countByCategory_Name("White");
        assertEquals(2, products);

        Long count = productRepository.count();
        assertEquals(2, count);
    }

    @Test
    void testExistsByName() {
        boolean product = productRepository.existsByName("Apple Iphone 15 Pro Max");
        assertTrue(product);
    }

    @Test
    void testDeleteByNameOld() {
        transactionOperations.executeWithoutResult(transactionOperations -> {
            Category category = categoryRepository.findById(1L).orElse(null);
            assertNotNull(category);

            Product product = new Product();
            product.setName("Samsung Galaxy S9");
            product.setPrice(10_000_000L);
            product.setCategory(category);
            productRepository.save(product);

            int delete = productRepository.deleteByName("Samsung Galaxy S9");
            assertEquals(1, delete);

            delete = productRepository.deleteByName("Samsung Galaxy S9");
            assertEquals(0, delete);
        });
    }

    @Test
    void testDeleteByNameNew() {
        Category category = categoryRepository.findById(1L).orElse(null);
        assertNotNull(category);

        Product product = new Product();
        product.setName("Samsung Galaxy S9");
        product.setPrice(10_000_000L);
        product.setCategory(category);
        productRepository.save(product);

        int delete = productRepository.deleteByName("Samsung Galaxy S9");
        assertEquals(1, delete);

        delete = productRepository.deleteByName("Samsung Galaxy S9");
        assertEquals(0, delete);
    }

    @Test
    void testSearchProductUsingName() {
        Pageable pageable = PageRequest.of(0, 1);
        List<Product> products = productRepository.searchProductUsingName("Apple Iphone 15 Pro Max", pageable);
        assertEquals(1, products.size());
        assertEquals("Apple Iphone 15 Pro Max", products.get(0).getName());
    }

    @Test
    void testSearchProductQuery() {

        Pageable pageable = PageRequest.of(0, 1, Sort.by(Sort.Order.desc("id")));
        assertNotNull(pageable);

        Page<Product> products = productRepository.searchProduct("%Iphone%", pageable);
        assertEquals(1, products.getContent().size());

        assertEquals(0, products.getNumber());
        assertEquals(2, products.getTotalElements());
        assertEquals(2, products.getTotalPages());

        products = productRepository.searchProduct("%White%", pageable);
        assertEquals(1, products.getContent().size());

        assertEquals(0, products.getNumber());
        assertEquals(2, products.getTotalElements());
        assertEquals(2, products.getTotalPages());
    }

    @Test
    void testModifying() {
        // transactionOperations.executeWithoutResult(transactionOperations -> {
        int total = productRepository.deleteProductUsingName("Wrong");
        assertEquals(0, total);

        total = productRepository.updateProductUsingId(1L);
        assertEquals(1, total);

        Product product = productRepository.findById(1L).orElse(null);
        assertNotNull(product);
        assertEquals(0, product.getPrice());
        // });
    }

    @Test
    void testStream() {
        transactionOperations.executeWithoutResult(transactionOperations -> {
            Category category = categoryRepository.findById(1L).orElse(null);
            assertNotNull(category);

            Stream<Product> stream = productRepository.streamAllByCategory(category);
            stream.forEach(product -> System.out.println(product.getId() + " : " + product.getName()));
        });
    }

    @Test
    void testSlice() {
        Pageable firstPage = PageRequest.of(0, 1);

        Category category = categoryRepository.findById(1L).orElse(null);
        assertNotNull(category);

        Slice<Product> product = productRepository.findAllByCategory(category, firstPage);

        while (product.hasNext()) {
            System.out.println("page : " + product.getNumber());
            System.out.println("element : " + product.getContent().get(0).getName());
            product = productRepository.findAllByCategory(category, product.nextPageable());
            System.out.println("page : " + product.getNumber());
            System.out.println("element : " + product.getContent().get(0).getName());
        }
    }

    @Test
    void testSpecification() {
        Specification<Product> specification = (root, criteriaQuery, criteriaBuilder) -> {
            return criteriaQuery.where(
                    criteriaBuilder.or(
                            criteriaBuilder.equal(root.get("name"), "Apple Iphone 14 Pro Max"),
                            criteriaBuilder.equal(root.get("name"), "Apple Iphone 15 Pro Max")))
                    .getRestriction();
        };

        List<Product> products = productRepository.findAll(specification);
        assertEquals(2, products.size());
    }

}
