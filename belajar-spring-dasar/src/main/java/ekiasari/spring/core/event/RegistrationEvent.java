package ekiasari.spring.core.event;

import org.springframework.context.ApplicationEvent;

import ekiasari.spring.core.data.Registration;
import lombok.Getter;

public class RegistrationEvent extends ApplicationEvent {

    @Getter
    private Registration registration;

    public RegistrationEvent(Registration registration) {
        super(registration);
        this.registration = registration;
    }

}
