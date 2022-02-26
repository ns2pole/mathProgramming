package com.example.demo2.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("tag","Spr Boot + Thymeleaf入門");
        return "index";
    }

    @RequestMapping("/input")
    public String input(String testInput, Model model){
        model.addAttribute("tag", "Spring Boot + Thymeleaf入門");
        testInput = testInput + testInput;
        model.addAttribute("testInput", testInput);
        return "index";
    }

}