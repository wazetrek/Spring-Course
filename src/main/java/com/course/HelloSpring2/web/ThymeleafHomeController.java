package com.course.HelloSpring2.web;

import com.course.HelloSpring2.domain.Persona2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class ThymeleafHomeController {

    @GetMapping("/home2")
    public String home(Model model) {
        var mensaje = "Hola mundo desde variable";
        var persona = new Persona2();
        var persona2 = new Persona2();
        persona.setNombre("Andrés");
        persona.setApellido("Blandón");
        persona.setEmail("blandonfelipe1");
        persona.setTelefono("3148131994");
        persona2.setNombre("Estefanía");
        persona2.setApellido("Bernal");
        persona2.setEmail("Muñoz");
        persona2.setTelefono("3137658163");
        var personas = Arrays.asList(persona, persona2);
        model.addAttribute("persona", persona);
        model.addAttribute("personas", personas);
        model.addAttribute("mensaje", mensaje);
        return "index";
    }
}
