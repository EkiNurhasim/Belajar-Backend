package ekiasari.spring.core;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ekiasari.spring.core.data.Bar;
import ekiasari.spring.core.data.Foo;
import ekiasari.spring.core.data.FooBar;

public class DependencyInjectionTest {

    private static ApplicationContext context;

    @BeforeAll
    public static void setUp() {
        context = new AnnotationConfigApplicationContext(DependencyInjection.class);
    }

    @Test
    void testFooBar() {

        Foo foo = context.getBean("fooSecond", Foo.class);
        Bar bar = context.getBean(Bar.class);

        FooBar fooBar = context.getBean(FooBar.class);

        assertSame(foo, fooBar.getFoo());
        assertSame(bar, fooBar.getBar());
    }
}
