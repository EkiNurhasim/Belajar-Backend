package ekiasari.spring.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ekiasari.spring.core.data.Connection;
import ekiasari.spring.core.data.Server;

public class LifeCicleConfigurationTest {

    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(LifeCicleConfiguration.class);
        context.registerShutdownHook();
    }

    // @AfterEach
    // void close() {
    // context.close();
    // }

    @Test
    void testConnection() {
        context.getBean(Connection.class);
    }

    @Test
    void testServer() {
        context.getBean(Server.class);
    }
}
