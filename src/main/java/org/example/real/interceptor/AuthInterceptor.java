package org.example.real.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String uri = request.getRequestURI();
        System.out.println("AuthInterceptor: Verificando acceso a " + uri);

        // Rutas públicas que no requieren autenticación
        if (uri.equals("/publico") || uri.startsWith("/css/") || uri.startsWith("/js/")) {
            return true;
        }

        // Obtener token de autenticación
        String token = request.getParameter("token");

        if (token == null || token.isEmpty()) {
            response.sendRedirect("/error?mensaje=No%20autenticado");
            return false;
        }

        // Simular verificación de token y roles
        String rol;
        if (token.equals("usuario123")) {
            rol = "usuario";
        } else if (token.equals("admin123")) {
            rol = "admin";
        } else {
            response.sendRedirect("/error?mensaje=Token%20inválido");
            return false;
        }

        // Verificar permisos para la ruta
        if (uri.startsWith("/admin") && !rol.equals("admin")) {
            response.sendRedirect("/error?mensaje=Acceso%20denegado%20para%20usuarios%20no%20administradores");
            return false;
        }

        // Almacenar el rol en la solicitud para uso futuro
        request.setAttribute("rol", rol);
        return true;
    }

}
