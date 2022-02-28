package com.example.service;
import java.util.ArrayList;

public interface IntegerService {
    ArrayList<Integer> getNaturalNumsLowerThan(int integer);
    ArrayList<Integer> getSievedNumsFor(int sieve, ArrayList<Integer> nums);
    int getEulerPhiFunctionValOf(int integer);
    boolean isPrime(int integer);
    int[] getPrimeFactorsOf(int integer);
    ArrayList<Integer> convertToArrayListFrom(int[] arr);
    int[] convertIntsFrom(ArrayList<Integer> arr);
    ArrayList<Integer> getCoprimeNumsLowerThan(int integer);
}
