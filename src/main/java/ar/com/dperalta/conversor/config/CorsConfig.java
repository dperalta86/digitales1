package ar.com.dperalta.conversor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuración para evitar error de CORS al estar en producción.
 */

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://dperalta.com.ar/",
                                "https://digitales1.dperalta.com.ar/",
                                "https://digitales1.dperalta.com.ar/conversor",
                                "https://digitales1.dperalta.com.ar/ieee754")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
