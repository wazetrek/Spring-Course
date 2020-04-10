package com.course.HelloSpring2.web;

import com.course.HelloSpring2.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/personas")
    public String home(Model model) {
        var personas = personaService.listarPersonas();
        model.addAttribute("personas", personas);
        return "indexPersonas";
    }
}
