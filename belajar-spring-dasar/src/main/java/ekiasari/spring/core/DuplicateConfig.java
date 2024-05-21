package ekiasari.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import ekiasari.spring.core.data.Foo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class DuplicateConfig {

    @Primary
    @Bean(value = "fooFirst")
    public Foo foo1() {
        log.info("foo1");
        return new Foo();
    }

    @Bean(value = "fooSecond")
    public Foo foo2() {
        log.info("foo2");
        return new Foo();
    }
}
