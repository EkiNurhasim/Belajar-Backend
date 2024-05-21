package ekiasari.spring.core.service;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import ekiasari.spring.core.data.Registration;
import ekiasari.spring.core.event.RegistrationEvent;

@Service
public class RegistrationService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void Register(String username, String email, String password) {
        applicationEventPublisher.publishEvent(new RegistrationEvent(new Registration(username, email, password)));
    }

}
