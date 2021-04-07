package br.com.ufc.gedito.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.ufc.gedito.api.GeditoApplication;

@SpringBootApplication(scanBasePackages = "br.com.ufc.gedito.api", exclude = {SecurityAutoConfiguration.class})
@ComponentScan(basePackages = "br.com.ufc.gedito")
@PropertySource("classpath:/exception.properties")
@EntityScan(basePackages = {"br.com.ufc.gedito.entity"})
@EnableJpaRepositories("br.com.ufc.gedito.repository")
public class GeditoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeditoApplication.class, args);
	}

}
