package com.example.demo2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.service.IntegerServiceImpl;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;


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

    @RequestMapping("/integer")
    public String integer(){
        return "integer";
    }

    @RequestMapping("/primeFactorization")
    @ResponseBody
    public int[] primeFactorization2(int integer, Model model){
        IntegerServiceImpl impl = new IntegerServiceImpl();
        int[] primeFactors = impl.getPrimeFactorsOf(integer);
        model.addAttribute("primeFactors", primeFactors[0]);
        return impl.getPrimeFactorsOf(integer);
    }


}