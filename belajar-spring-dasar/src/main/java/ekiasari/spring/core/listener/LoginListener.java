package ekiasari.spring.core.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import ekiasari.spring.core.event.LoginEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LoginListener implements ApplicationListener<LoginEvent> {

    @Override
    public void onApplicationEvent(@SuppressWarnings("null") LoginEvent event) {
        log.info("Username = " + event.getUser().getUsernamee() + " || " + "Password = "
                + event.getUser().getPassword());
    }

}
