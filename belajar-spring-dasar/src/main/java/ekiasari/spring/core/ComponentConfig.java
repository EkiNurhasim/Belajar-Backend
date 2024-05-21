package ekiasari.spring.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "ekiasari.spring.core.service",
        "ekiasari.spring.core.repository",
        "ekiasari.spring.core.configuration",
})
public class ComponentConfig {

}