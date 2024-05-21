package ekiasari.spring.core;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ekiasari.spring.core.data.Bar;
import ekiasari.spring.core.data.Foo;
import ekiasari.spring.core.data.FooBar;

public class OptionalDependencyInjectionTest {

    ConfigurableApplicationContext context;
    ConfigurableApplicationContext con;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(OptionalDependencyInjection.class);
        con = new AnnotationConfigApplicationContext(ComponentConfig.class);
        context.registerShutdownHook();
        con.registerShutdownHook();
    }

    @Test
    void testFoo() {

        Foo foo = context.getBean(Foo.class);
        Bar bar = con.getBean(Bar.class);
        FooBar fooBar = context.getBean(FooBar.class);

        assertSame(foo, fooBar.getFoo());
        assertNotSame(bar, fooBar.getBar());
    }
}
