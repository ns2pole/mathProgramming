package com.example.math.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.service.IntegerServiceImpl;
import java.util.ArrayList;

@Controller
public class MathController {
    @ResponseBody
    @RequestMapping("/EulerPhiFunction")
    public String getTemplateSetEulerFunctionVal(int integer) {
        IntegerServiceImpl impl = new IntegerServiceImpl();
        int eulerPhiFunctionVal = impl.getEulerPhiFunctionValOf(integer);
        // String stringOfEulerPhiFunctionCalculate = impl.getStringForMathJaxAboutEulerPhiFunctionFrom(integer, eulerPhiFunctionVal);
        // String stringOfCayleyTableCalculate = impl.getStringForMathJaxAboutCayleyTableFrom(integer, integer);
        return new Integer(eulerPhiFunctionVal).toString();
    }

    @ResponseBody
    @RequestMapping("/PrimeNumsUnderSetVal")
    public String getTemplateSetPrimeNumsUnderSetVal(int integer) {
        IntegerServiceImpl impl = new IntegerServiceImpl();
        ArrayList<Integer> primeNumsUnderSetVal = impl.getPrimeNumsUnder(integer);
        // String stringOfPrimeNumsUnderSetVal = impl.getStringForMathJaxAboutPrimeNumsUnderSetVal(integer, primeNumsUnderSetVal);
        return primeNumsUnderSetVal.toString();
    }
    

}