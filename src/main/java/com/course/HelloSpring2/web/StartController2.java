package com.course.HelloSpring2.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartController2 {

    @GetMapping("rest")
    public String start() {
        return "Hola mundo con sprint ";
    }
}
