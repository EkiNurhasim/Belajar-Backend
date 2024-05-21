package ekiasari.spring.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ekiasari.spring.core.client.PaymentGatewayClient;
import ekiasari.spring.core.configuration.FactoryConfiguration;

public class FactoryBeanTest {

    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(FactoryConfiguration.class);
        context.registerShutdownHook();
    }

    @Test
    void TestFactoryBean() {
        PaymentGatewayClient client = context.getBean(PaymentGatewayClient.class);
        assertEquals("https://example.com", client.getEndpoint());
        assertEquals("public", client.getPublicKey());
        assertEquals("private", client.getPrivateKey());
    }

}
