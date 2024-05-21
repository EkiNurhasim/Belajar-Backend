package ekiasari.spring.core.service;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import ekiasari.spring.core.data.User;
import ekiasari.spring.core.event.LoginEvent;

@Service
public class LoginService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(
            @SuppressWarnings("null") ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public boolean login(String username, String password) {
        if (hasLoggedIn(username, password)) {
            applicationEventPublisher.publishEvent(new LoginEvent(new User(username, password)));
            return true;
        } else {
            return false;
        }
    }

    private boolean hasLoggedIn(String username, String password) {
        return "orange".equals(username) && "orange".equals(password);
    }

}
