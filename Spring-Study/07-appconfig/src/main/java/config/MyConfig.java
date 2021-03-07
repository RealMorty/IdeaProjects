package config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertyResolver;
import pojo.User;

@Configuration
public class MyConfig {
    @Bean
    public User getUser() {
        return new User();
    }
}
