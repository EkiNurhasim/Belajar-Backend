package ekiasari.webmvc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "database")
@PropertySource("classpath:/application-database.properties")
public class Database {

    private String name;
    private String password;
}
