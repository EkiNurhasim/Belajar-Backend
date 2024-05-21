package ekiasari.webmvc.event;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

public class UserEvent extends ApplicationEvent {

    @Getter
    private UserPojo user;

    public UserEvent(UserPojo user) {
        super(user);
        this.user = user;
    }

}
