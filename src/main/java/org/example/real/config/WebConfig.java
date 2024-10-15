package org.example.real.config;

import org.example.real.interceptor.AuthInterceptor;
import org.example.real.interceptor.LoggingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private AuthInterceptor authInterceptor;

    @Autowired
    private LoggingInterceptor loggingInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Interceptor de logging se aplica a todas las rutas
        registry.addInterceptor(loggingInterceptor)
                .addPathPatterns("/**");

        // Interceptor de autenticación se aplica a rutas específicas
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/privado/**", "/admin/**");
    }
}
