package com.example.service;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

@Service
public class IntegerServiceImpl implements IntegerService {
    public ArrayList<Integer> getNaturalNumsLowerThan(int integer) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int k = 1; k <= integer;k++) {
            arr.add(k);
        }
        return arr;
    }

    @Override
    public ArrayList<Integer> convertToArrayListFrom(int[] arr) {
        return (ArrayList<Integer>) Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    @Override
    public int[] convertIntsFrom(ArrayList<Integer> arr) {
        int[] ints = new int[arr.size()];
        for(int i = 0;i < arr.size();i++) {
            ints[i] = arr.get(i);
        }
        return ints;
    }


    @Override
    public ArrayList<Integer> getSievedNumsFor(int sieve, ArrayList<Integer> nums) {
        for(int i = 0; i < nums.size(); i++) {
            if(nums.get(i).intValue() % sieve == 0) {
                nums.remove(i);
                i--;
            }
        }
        return nums;
    }

    @Override
    public ArrayList<Integer> getCoprimeNumsLowerThan(int integer) {
        ArrayList<Integer> nums = this.getNaturalNumsLowerThan(integer);
        for(int k = 2; k <= integer;k++) {
            if(integer % k == 0) {
                nums = this.getSievedNumsFor(k, nums);
            }
        }
        return nums;
    }

    @Override 
    public int getEulerPhiFunctionValOf(int integer) {
        return this.getCoprimeNumsLowerThan(integer).size();
    }

    @Override
    public boolean isPrime(int integer) {
        ArrayList<Integer> sievedNums = this.getNaturalNumsLowerThan(integer);
        for(int k = 2; k*k < integer;k++) {
            if(integer % k == 0) {
                return false;
            }
        }
        return true;
    }


    @Override
    public int[] getPrimeFactorsOf(int integer) {
        int[] ints = new int[3];
        ints[0] = 4;
        ints[1] = 5;
        ints[2] = 6;
        return ints;
    }


}
