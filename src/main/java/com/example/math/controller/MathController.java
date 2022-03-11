package com.example.math.controller;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.Handler;
import java.util.logging.FileHandler;
import java.io.File;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.service.IntegerServiceImpl;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class MathController {
    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("tag","Spr Boot + Thymeleaf入門");
        return "index";
    }

    @RequestMapping("/EulerPhiFunction")
    public String getTemplateSetEulerFunctionVal(int integer,HttpServletRequest req, HttpServletResponse res, Model model) throws IOException {
        IntegerServiceImpl impl = new IntegerServiceImpl();
        int eulerPhiFunctionVal = impl.getEulerPhiFunctionValOf(integer);
        String stringOfEulerPhiFunctionCalculate = impl.getStringForMathJaxAboutEulerPhiFunctionFrom(integer, eulerPhiFunctionVal);
        // String stringOfCayleyTableCalculate = impl.getStringForMathJaxAboutCayleyTableFrom(integer, integer);
        model.addAttribute("stringOfEulerPhiFunctionCalculate", stringOfEulerPhiFunctionCalculate);
        // model.addAttribute("cayleyTable", stringOfCayleyTableCalculate);
        
        Logger sample_logger = Logger.getLogger("Sample log");
        String path =  System.getProperty("user.dir"); path = new File(path, "sample_log.txt").getPath();
        System.out.println(path);
        try{ 
            Handler sample_handler = new FileHandler(path);
            sample_logger.addHandler(sample_handler);
        }catch(IOException e){}
        sample_logger.log(Level.INFO, model.toString()); 

        return "index";
    }

    @RequestMapping("/PrimeNumsUnderSetVal")
    public String getTemplateSetPrimeNumsUnderSetVal(int integer,HttpServletRequest req, HttpServletResponse res, Model model) throws IOException {
        IntegerServiceImpl impl = new IntegerServiceImpl();
        ArrayList<Integer> primeNumsUnderSetVal = impl.getPrimeNumsUnder(integer);
        String stringOfPrimeNumsUnderSetVal = impl.getStringForMathJaxAboutPrimeNumsUnderSetVal(integer, primeNumsUnderSetVal);

        Logger sample_logger = Logger.getLogger("Sample log");
        String path =  System.getProperty("user.dir"); path = new File(path, "sample_log.txt").getPath();
        System.out.println(path);
        try{ 
            Handler sample_handler = new FileHandler(path);
            sample_logger.addHandler(sample_handler);
        }catch(IOException e){}
        sample_logger.log(Level.INFO, model.toString()); 
        model.addAttribute("stringOfPrimeNumsUnderSetVal", stringOfPrimeNumsUnderSetVal);

        return "index";
    }
    

}