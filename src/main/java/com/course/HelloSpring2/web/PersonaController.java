package com.course.HelloSpring2.web;

import com.course.HelloSpring2.domain.Persona;
import com.course.HelloSpring2.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/personas")
    // Se agrega la anotación @AuthenticationPrincipal para poder obtener el usuario que está logueado
    public String home(Model model, @AuthenticationPrincipal User user) {
        var personas = personaService.listarPersonas();
        model.addAttribute("personas", personas);
        return "indexPersonas";
    }

    @GetMapping("/agregar")
    public String agregar(Persona persona) {
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores) {
        if(errores.hasErrors()) {
            return "modificar";
        }
        personaService.guardar(persona);
        return "redirect:/personas";
    }

    @GetMapping("/editar/{id}")
    public String editar(Persona persona, Model model) {
        persona = personaService.encontrar(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }

    @GetMapping("/eliminar")
    public String eliminar(Persona persona) {
        personaService.eliminar(persona);
        return "redirect:/personas";
    }
}
