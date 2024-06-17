package br.newtonpaiva.JWT_Security_RESTAPI.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication(scanBasePackages = {"br.newtonpaiva"})
@EnableMongoRepositories("br.newtonpaiva.JWT_Security_RESTAPI.repository")
public class JwtSecurityRestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtSecurityRestapiApplication.class, args);
	}

}
