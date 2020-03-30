package com.course.HelloSpring2.web;

import com.course.HelloSpring2.dao.PersonaDao;
import com.course.HelloSpring2.domain.Persona2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class StartController {

    @Autowired
    private PersonaDao personaDao;

    @GetMapping("/home")
    public String home(Model model) {
        var personas = personaDao.findAll();
        model.addAttribute("personas", personas);
        return "index";
    }
}
