package com.trading.trader;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableWebMvc
@Profile("!test") // here to fix a bug in swagger since swagger messes up the test class
@Component
public class SwaggerConfig implements WebMvcConfigurer {
    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("stockOrdering")
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.any())
                .build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Stock Ordering REST API with Swagger")
                .description("This API allows you to interact with stock ordering. It is a CRUD API")
                //.termsOfServiceUrl("http://www.conygre.com")
//                .contact(new Contact("Nick Todd", "http://www.conygre.com", "nick.todd@conygre.com"))
                //.license("Apache License Version 2.0")
                //.licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
                //.version("2.0")
                .build();
    }
}
