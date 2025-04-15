package com.FinalEcommerce.Main.CorsCongfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow CORS for all endpoints and for the specific frontend domain
        registry.addMapping("/**")  // Allow all paths
                .allowedOrigins("http://localhost:5173")  // Your frontend origin (can be localhost or deployed URL)
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allowed HTTP methods
                .allowCredentials(true)  // Allow credentials (cookies, authorization headers, etc.)
                .allowedHeaders("*");  // Allow all headers
    }
}

