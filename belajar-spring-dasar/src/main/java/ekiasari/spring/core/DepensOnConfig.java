package ekiasari.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import ekiasari.spring.core.data.Bar;
import ekiasari.spring.core.data.Foo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class DepensOnConfig {

    @Bean
    @Lazy
    @DependsOn(value = "bar")
    public Foo foo() {
        log.info("Create Foo ");
        return new Foo();
    }

    @Bean
    @Scope("prototype")
    public Bar bar() {
        log.info("Create Bar ");
        return new Bar();
    }
}
