package com.equipments.rent.config.swagger;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
							.select()
							.apis(RequestHandlerSelectors.basePackage("com.equipments.rent.controllerscom.equipments.rent.controllers"))
							.paths(PathSelectors.ant("/rent-equipment/*"))
							.build()
							.apiInfo(apiInfo())
							.useDefaultResponseMessages(false)
							.globalResponseMessage(RequestMethod.GET, responseMessages());
	}
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "Rent Equipment", 
	      "Services Documentation", 
	      "0.0.1", 
	      "Terms of service", 
	      new Contact("Jonathan Cabral", null, "dev.jonathancabral@gmail.com"), 
	      "License of API", "API license URL", Collections.emptyList());
	}

	private ArrayList<ResponseMessage> responseMessages() {
		 ArrayList<ResponseMessage> responseMessages = new ArrayList<ResponseMessage>();
		 
		 responseMessages.add(new ResponseMessageBuilder().code(200).message("Success")
				    .responseModel(new ModelRef("Success")).build());
		 
		 responseMessages.add(new ResponseMessageBuilder().code(201).message("Created!")
				    .responseModel(new ModelRef("Sucess")).build());
		 
		 responseMessages.add(new ResponseMessageBuilder().code(202).message("Accecpetd, Async with no response")
				    .responseModel(new ModelRef("Success")).build());
		 
		 responseMessages.add(new ResponseMessageBuilder().code(204).message("No Content. Contain Headers")
				    .responseModel(new ModelRef("Success")).build());
		 
		 responseMessages.add(new ResponseMessageBuilder().code(304).message("Not Modified")
				    .responseModel(new ModelRef("Redirect")).build());
		 
		 responseMessages.add(new ResponseMessageBuilder().code(401).message("Unauthorized, no autenticated")
				    .responseModel(new ModelRef("Client Error")).build());
		 
		 responseMessages.add(new ResponseMessageBuilder().code(404).message("Resource Not Found")
				    .responseModel(new ModelRef("Client Error")).build());
		 
		 responseMessages.add(new ResponseMessageBuilder().code(403).message("Forbidden")
				    .responseModel(new ModelRef("Client Error")).build());
		 
		 responseMessages.add(new ResponseMessageBuilder().code(405).message("Not Allowed")
				    .responseModel(new ModelRef("Client Error")).build());
		 
		 responseMessages.add(new ResponseMessageBuilder().code(410).message("Gone")
				    .responseModel(new ModelRef("Client Error")).build());
		 
		 responseMessages.add(new ResponseMessageBuilder().code(414).message("URI too long")
				    .responseModel(new ModelRef("Client Error")).build());
		 
		 responseMessages.add(new ResponseMessageBuilder().code(415).message("Resource do not support that media type, verb http")
				    .responseModel(new ModelRef("Client Error - Unsuported media type")).build());
		 
		 responseMessages.add(new ResponseMessageBuilder().code(503).message("Out of service")
				    .responseModel(new ModelRef("Internal Error")).build());
		 
		 
		 
		 return responseMessages;
	}
}
