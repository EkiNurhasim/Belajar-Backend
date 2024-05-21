package ekiasari.spring.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ekiasari.spring.core.configuration.BarConfiguration;
import ekiasari.spring.core.configuration.FooConfiguration;

@Configuration
@Import(value = {
        FooConfiguration.class,
        BarConfiguration.class
})
public class MainConfiguration {

}
