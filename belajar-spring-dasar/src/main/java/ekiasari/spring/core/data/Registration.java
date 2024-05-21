package ekiasari.spring.core.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Registration {

    private String username;
    private String email;
    private String password;
}
