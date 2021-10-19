
package org.hmti.JavaCourse.config;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {
   
    /**
     * The Swagger configuration. <br>
     * Docket bean content list : <br>
     * <ul>
     * <li>API info</li>
     * <li>Security contexts</li>
     * <li>Security schemes</li>
     * <li>API selector builder (Request handlers and Request handlers
     * selectors)</li>
     * </ul>
     *
     * @return Docket bean object.
     * @see Docket
     * @see DocumentationType
     * @see RequestHandlerSelectors
     * @see PathSelectors
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * The {@link ApiInfo} class that contains custom information about the API.
     *
     * @return {@link ApiInfo} object.
     *
     * @see ApiInfo#ApiInfo(java.lang.String, java.lang.String,
     * java.lang.String, java.lang.String,
     * springfox.documentation.service.Contact, java.lang.String,
     * java.lang.String, java.util.Collection)
     * @see Contact
     */
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "TMS REST API",
                "Application programming interface for Spring.",
                "1.0",
                " ",
                new Contact("PT. XYZ", " ",
                        "asepud28@gmail.com"),
                "License of API",
                "PT. XYZ",
                Collections.emptyList());
    }
}
