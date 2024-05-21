package ekiasari.spring.core;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ekiasari.spring.core.data.Foo;

public class DuplicateConfigTest {

    @Test
    void testDuplicate() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DuplicateConfig.class);

        Foo foo = context.getBean("fooFirst", Foo.class);
        Foo foo1 = context.getBean(Foo.class); // nama methodnya
        Foo foo2 = context.getBean("fooSecond", Foo.class); // nama methodnya
        assertSame(foo, foo1);
        assertNotSame(foo, foo2);
        assertNotSame(foo1, foo2);
        assertNotNull(context);
    }
}
