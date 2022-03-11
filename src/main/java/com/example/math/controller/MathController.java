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
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.service.IntegerServiceImpl;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class MathController {
    @ResponseBody
    @RequestMapping("/EulerPhiFunction")
    public String getTemplateSetEulerFunctionVal(int integer,HttpServletRequest req, HttpServletResponse res, Model model) throws IOException {
        IntegerServiceImpl impl = new IntegerServiceImpl();
        int eulerPhiFunctionVal = impl.getEulerPhiFunctionValOf(integer);
        String stringOfEulerPhiFunctionCalculate = impl.getStringForMathJaxAboutEulerPhiFunctionFrom(integer, eulerPhiFunctionVal);
        // String stringOfCayleyTableCalculate = impl.getStringForMathJaxAboutCayleyTableFrom(integer, integer);
        return stringOfEulerPhiFunctionCalculate;
    }

    @ResponseBody
    @RequestMapping("/PrimeNumsUnderSetVal")
    public String getTemplateSetPrimeNumsUnderSetVal(int integer,HttpServletRequest req, HttpServletResponse res, Model model) throws IOException {
        IntegerServiceImpl impl = new IntegerServiceImpl();
        ArrayList<Integer> primeNumsUnderSetVal = impl.getPrimeNumsUnder(integer);
        String stringOfPrimeNumsUnderSetVal = impl.getStringForMathJaxAboutPrimeNumsUnderSetVal(integer, primeNumsUnderSetVal);
        return stringOfPrimeNumsUnderSetVal;
    }
    

}