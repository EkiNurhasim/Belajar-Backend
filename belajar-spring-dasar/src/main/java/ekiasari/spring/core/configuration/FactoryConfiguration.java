package ekiasari.spring.core.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ekiasari.spring.core.factory.PaymentGatewayClientFactoryBean;

@Configuration
@Import({
        PaymentGatewayClientFactoryBean.class
})
public class FactoryConfiguration {

}
