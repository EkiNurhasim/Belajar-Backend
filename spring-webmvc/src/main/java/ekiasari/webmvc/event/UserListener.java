package ekiasari.webmvc.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserListener implements ApplicationListener<UserEvent> {

    @Override
    public void onApplicationEvent(@SuppressWarnings("null") UserEvent event) {
        log.info(event.getUser().getUsername());
        log.info(event.getUser().getPassword());
    }

}
