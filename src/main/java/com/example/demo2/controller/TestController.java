package com.example.demo2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.service.IntegerServiceImpl;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

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
    public String integer(Model model){
        return "integer";
    }

    // @RequestMapping("/primeFactorization")
    // // @ResponseBody
    // public String primeFactorization(int integer, Model model){
    //     IntegerServiceImpl impl = new IntegerServiceImpl();
    //     int[] primeFactors = impl.getPrimeFactorsOf(integer);
    //     model.addAttribute("primeFactors", primeFactors[2]);
    //     return "integer";
    // }

    @RequestMapping("/primeFactorization")
    public String text(int integer,HttpServletRequest req, HttpServletResponse res, Model model) throws IOException {
        IntegerServiceImpl impl = new IntegerServiceImpl();
        int eulerPhiFunctionVal = impl.getEulerPhiFunctionValOf(integer);
        Logger logger = LoggerFactory.getLogger(TestController.class);
        logger.info("test");
        model.addAttribute("primeFactors", "$\\phi(" + integer + ")=" + eulerPhiFunctionVal + "$");
        return "integer";
    }


}