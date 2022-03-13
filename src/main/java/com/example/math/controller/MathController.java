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
    public String getEulerFunctionValStr(int integer) {
        IntegerServiceImpl impl = new IntegerServiceImpl();
        int eulerPhiFunctionVal = impl.getEulerPhiFunctionValOf(integer);
        return new Integer(eulerPhiFunctionVal).toString();
    }

    @ResponseBody
    @RequestMapping("/PrimeNumsUnderSetVal")
    public String getPrimeNumsStrUnderSetVal(int integer) {
        IntegerServiceImpl impl = new IntegerServiceImpl();
        ArrayList<Integer> primeNumsUnderSetVal = impl.getPrimeNumsUnder(integer);
        return primeNumsUnderSetVal.toString();
    }

    @ResponseBody
    @RequestMapping("/isPrime")
    public String getIsPrimeStr(int integer) {
        IntegerServiceImpl impl = new IntegerServiceImpl();
        boolean isPrime = impl.isPrime(integer);
        return String.valueOf(isPrime);
    }
    

}