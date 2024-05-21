package ekiasari.spring.core;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ekiasari.spring.core.data.Bar;
import ekiasari.spring.core.data.Foo;
import ekiasari.spring.core.data.FooBar;

@Configuration
public class OptionalDependencyInjection {

    @Bean
    public Foo foo() {
        return new Foo();
    }

    @Bean
    public FooBar fooBar(Optional<Foo> foo, Optional<Bar> bar) {
        return new FooBar(foo.orElse(null), bar.orElse(null));
    }

}
