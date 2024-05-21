package ekiasari.spring.core.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import ekiasari.spring.core.event.RegistrationEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RegistrationListener implements ApplicationListener<RegistrationEvent> {

    @Override
    public void onApplicationEvent(RegistrationEvent event) {
        log.info("Username : " + event.getRegistration().getUsername());
        log.info("Email : " + event.getRegistration().getEmail());
        log.info("Password : " + event.getRegistration().getPassword());
    }

}
