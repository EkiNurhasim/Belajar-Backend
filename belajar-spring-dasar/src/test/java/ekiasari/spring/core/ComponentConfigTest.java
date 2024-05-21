package ekiasari.spring.core;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ekiasari.spring.core.repository.CatRepository;
import ekiasari.spring.core.repository.CustomerRepository;
import ekiasari.spring.core.repository.ProductRepository;
import ekiasari.spring.core.service.CatService;
import ekiasari.spring.core.service.CustomerService;
import ekiasari.spring.core.service.ProductService;

public class ComponentConfigTest {

    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(ComponentConfig.class);
        context.registerShutdownHook();
    }

    @Test
    void componentConfig() {
        ProductService service1 = context.getBean(ProductService.class);
        ProductService service2 = context.getBean("productService", ProductService.class);

        assertSame(service1, service2);
    }

    @Test
    void constructorDependencyInjection() {

        ProductService productService = context.getBean(ProductService.class);
        ProductRepository productRepository = context.getBean(ProductRepository.class);

        assertSame(productService.getProductRepository(), productRepository);
    }

    @Test
    void setterDependencyInjection() {
        CatService catService = context.getBean(CatService.class);
        CatRepository catRepository = context.getBean(CatRepository.class);

        assertSame(catService.getCatRepository(), catRepository);
    }

    @Test
    void fieldDependencyInjection() {
        CustomerService customerService = context.getBean(CustomerService.class);

        CustomerRepository premiumCustomerRepository = context.getBean("premiumCustomerRepository",
                CustomerRepository.class);
        CustomerRepository normalCustomerRepository = context.getBean("normalCustomerRepository",
                CustomerRepository.class);

        assertSame(premiumCustomerRepository, customerService.getPremiumCustomerRepository());
        assertSame(normalCustomerRepository, customerService.getNormaCustomerRepository());
    }
}
