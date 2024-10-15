package org.example.real.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

    private long tiempoInicio;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        tiempoInicio = System.currentTimeMillis();
        String uri = request.getRequestURI();
        System.out.println("LoggingInterceptor: Solicitando " + uri);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long tiempoFin = System.currentTimeMillis();
        long tiempoTotal = tiempoFin - tiempoInicio;
        String uri = request.getRequestURI();
        System.out.println("LoggingInterceptor: Finalizada solicitud a " + uri + " en " + tiempoTotal + " ms");
    }
}
