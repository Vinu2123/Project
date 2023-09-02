//package com.rest.webservices;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
////import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import springfox.documentation.builders.RequestHandlerSelectors;
////import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import static springfox.documentation.builders.PathSelectors.regex;

//import java.util.ArrayList;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//    
//    @Bean
//    public Docket atividadeApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.rest.webservices"))
//                .paths(regex("/api.*"))
//                .build()
//                ;
//    }
//
//    private ApiInfo metaInfo() {
//
//        ApiInfo apiInfo = new ApiInfo(
//                "Atividades API REST",
//                "API REST de cadastro de atividades.",
//                "1.0",
//                "Terms of Service",
//                new Contact("João VR", "www.una.br/",
//                        " "),
//                "Apache License Version 2.0",
//                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
//        );
//
//        return apiInfo;
  //  }

