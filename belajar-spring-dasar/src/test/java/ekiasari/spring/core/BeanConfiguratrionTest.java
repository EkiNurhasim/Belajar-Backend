package ekiasari.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ekiasari.spring.core.data.Foo;

public class BeanConfiguratrionTest {

    @Test
    void testFoo() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguratrion.class);
        Assertions.assertNotNull(context);

        Foo foo1 = context.getBean(Foo.class);
        Foo foo2 = context.getBean(Foo.class);
        Assertions.assertSame(foo1, foo2);
    }
}
