package ekiasari.spring.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ekiasari.spring.core.configuration.EventListenerConfiguration;
import ekiasari.spring.core.service.LoginService;

public class TestEventListener {

    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(EventListenerConfiguration.class);
        context.registerShutdownHook();
    }

    @Test
    public void testEventListener() {
        LoginService loginService = context.getBean(LoginService.class);
        loginService.login("orange", "orange");
        loginService.login("white", "white");
        loginService.login("hia", "hia");

    }
}
