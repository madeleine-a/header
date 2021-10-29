package se.mad.poc.header;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class HeaderApplication {
    public static void main(String[] args) {
        SpringApplication.run(HeaderApplication.class, args);
    }
}
