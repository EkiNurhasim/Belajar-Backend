package ekiasari.spring.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ekiasari.spring.core.configuration.EventListenerConfiguration;
import ekiasari.spring.core.service.RegistrationService;

public class RegistrationServiceTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(EventListenerConfiguration.class);
    }

    @Test
    public void testRegister() {
        RegistrationService registrationService = applicationContext.getBean(RegistrationService.class);
        registrationService.Register("Umami", "umamio@gmail.com", "umiuiuiu");
        registrationService.Register("orange", "orange@gmail.com", "orangeorangeorange");
    }

}
