package org.example.real.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class MiControlador {

    @GetMapping("/publico")
    public String paginaPublica(Model model) {
        model.addAttribute("mensaje", "Esta es una página pública accesible por todos.");
        return "publico";
    }

    @GetMapping("/privado")
    public String paginaPrivada(Model model, HttpServletRequest request) {
        String rol = (String) request.getAttribute("rol");
        model.addAttribute("mensaje", "Bienvenido a la página privada. Rol: " + rol);
        return "privado";
    }

    @GetMapping("/admin")
    public String paginaAdmin(Model model, HttpServletRequest request) {
        String rol = (String) request.getAttribute("rol");
        model.addAttribute("mensaje", "Bienvenido a la página de administrador. Rol: " + rol);
        return "privado";
    }

}
