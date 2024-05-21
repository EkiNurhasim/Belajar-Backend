package ekiasari.spring.core.event;

import org.springframework.context.ApplicationEvent;

import ekiasari.spring.core.data.User;
import lombok.Getter;

public class LoginEvent extends ApplicationEvent {

    @Getter
    private final User user;

    public LoginEvent(User user) {
        super(user);
        this.user = user;
    }

}
