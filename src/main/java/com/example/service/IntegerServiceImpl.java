package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class IntegerServiceImpl implements IntegerService {
    
    @Override
    public int[] getPrimeFactorsOf(int integer) {
        int[] ints = new int[3];
        ints[0] = 4;
        ints[1] = 5;
        ints[2] = 6;
        return ints;
    }
}
