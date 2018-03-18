package com.revature.hydra.client.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.revature.hydra.client.controller.ClientController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableJpaRepositories("com.revature.hydra.client.data")
@SpringBootApplication
@Configuration
@EnableSwagger2
@ComponentScan(basePackages = {"com.revature.hydra.client.controller", "com.revature.hydra.client.service"})
@EntityScan("com.revature.beans")
public class ClientRepositoryServiceApplication {
	/*@Autowired
	ClientService cs;
	
	@Autowired
	ClientRepository cr;*/

	public static void main(String[] args) {
		SpringApplication.run(ClientRepositoryServiceApplication.class, args);
	}
	
	/*
	 * We believe that this is called by the gateway microservice.  And because this is currently working
	 * standalone we do not need it.
	 * Instead we use basePackageClasses in the @ComponentScan annotation
	 */
	/*@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.revature.hydra.client.controller"))              
          .paths(PathSelectors.any())                          
          .build();
    }*/
	
}
