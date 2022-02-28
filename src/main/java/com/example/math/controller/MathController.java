package com.example.math.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.service.IntegerServiceImpl;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class MathController {
    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("tag","Spr Boot + Thymeleaf入門");
        return "index";
    }

    @RequestMapping("/primeFactorization")
    public String text(int integer,HttpServletRequest req, HttpServletResponse res, Model model) throws IOException {
        IntegerServiceImpl impl = new IntegerServiceImpl();
        int eulerPhiFunctionVal = impl.getEulerPhiFunctionValOf(integer);
        Logger logger = LoggerFactory.getLogger(MathController.class);
        logger.info("test");
        model.addAttribute("primeFactors", "$\\phi(" + integer + ")=" + eulerPhiFunctionVal + "$");
        return "index";
    }

}