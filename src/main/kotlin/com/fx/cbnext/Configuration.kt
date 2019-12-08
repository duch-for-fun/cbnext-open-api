package com.fx.cbnext

import org.springframework.context.annotation.*
import springfox.documentation.builders.*
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfiguration {
    @Bean
    open fun api() = Docket(DocumentationType.SWAGGER_2)
            .apiInfo(ApiInfoBuilder()
                    .title("CB T+1 API prototype")
                    .version(CBNextApi.VERSION)
                    .description("by DCBFX team")
                    .build())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.fx.cbnext"))
            .paths(PathSelectors.any())
            .build()
}