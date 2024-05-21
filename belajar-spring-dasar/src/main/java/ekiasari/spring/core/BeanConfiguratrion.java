package ekiasari.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ekiasari.spring.core.data.Foo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class BeanConfiguratrion {

    @Bean
    public Foo foo() {
        Foo foo = new Foo();
        log.info("create new");
        return foo;
    }
}
