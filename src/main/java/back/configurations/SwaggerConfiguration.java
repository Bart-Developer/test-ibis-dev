package back.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket swagger() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.none())
				.paths(PathSelectors.none())
				.build()
				.enable(false);
	}

	@Primary
	@Bean
	public SwaggerResourcesProvider swaggerResourcesProvider(InMemorySwaggerResourcesProvider defaultResourcesProvider) {
		return () -> {
			SwaggerResource wsResource = new SwaggerResource();
			wsResource.setName("Person Minimum Information Processor Swagger");
			wsResource.setSwaggerVersion("2.0");
			wsResource.setLocation("/api-docs/demo-api-swagger.json");
			List<SwaggerResource> resources = new ArrayList<>(defaultResourcesProvider.get());
			resources.add(wsResource);
			return resources;
		};
	}

}
