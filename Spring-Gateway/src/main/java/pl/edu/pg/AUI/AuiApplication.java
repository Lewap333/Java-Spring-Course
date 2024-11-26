package pl.edu.pg.AUI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AuiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuiApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder,
									 @Value("${aui.product.url}") String productUrl,
									 @Value("${aui.category.url}") String categoryUrl,
									 @Value("${aui.gateway.host}") String host

	){
		return builder
				.routes()
				.route("categories", route -> route
						.host(host).and().path(
								"/api/categories",
								"/api/categories/{uuid}"
						).uri(categoryUrl)
				)
				.route("products", route -> route
						.host(host).and().path(
								"/api/products",
								"/api/products/**",
								"/api/products/**",
								"/api/categories/{uuid}/products",
								"/api/categories/{uuid}/products/**"
						).uri(productUrl)
				)
				.build();
	}
}
