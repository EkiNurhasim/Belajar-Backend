package ekiasari.spring.core;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ekiasari.spring.core.data.Bar;

public class DepensOnConfigTest {

    @Test
    void prototypeScope() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DepensOnConfig.class);
        assertNotNull(context);
        Bar foo1 = context.getBean(Bar.class);
        Bar foo2 = context.getBean(Bar.class);

        assertNotSame(foo1, foo2);
    }
}
