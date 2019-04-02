package org.smh.restful.RestfulTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableRedisRepositories
public class RestfulTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulTestApplication.class, args);
	}

}
