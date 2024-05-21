package ekiasari.spring.core.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ekiasari.spring.core.listener.LoginListener;
import ekiasari.spring.core.listener.RegistrationListener;
import ekiasari.spring.core.service.LoginService;
import ekiasari.spring.core.service.RegistrationService;

@Configuration
@Import({
        LoginListener.class,
        LoginService.class,
        RegistrationService.class,
        RegistrationListener.class
})
public class EventListenerConfiguration {

}
