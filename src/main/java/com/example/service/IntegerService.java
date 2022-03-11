package com.example.service;
import java.util.ArrayList;

public interface IntegerService {
    ArrayList<Integer> getPrimeNumsUnder(int integer);
    ArrayList<Integer> convertToArrayListFrom(int[] arr);
    int[] convertIntsFrom(ArrayList<Integer> arr);
    ArrayList<Integer> getNaturalNumsLowerThan(int integer);
    ArrayList<Integer> getSievedNumsFor(int sieve, ArrayList<Integer> nums);
    ArrayList<Integer> getCoprimeNumsLowerThan(int integer);
    int getEulerPhiFunctionValOf(int integer);
    String getStringForMathJaxAboutEulerPhiFunctionFrom(int input, int output);
    String getStringForMathJaxAboutPrimeNumsUnderSetVal(int integer, ArrayList<Integer> output);
    String getStringForMathJaxAboutCayleyTableFrom(int input, int output);
    boolean isPrime(int integer);
    int[] getPrimeFactorsOf(int integer);
    
}
