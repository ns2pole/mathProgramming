package com.example.service;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class IntegerServiceImpl implements IntegerService {

    public ArrayList<Integer> getNaturalNumsLowerThan(int integer) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int k = 1; k <= integer;k++) {
            arr.add(k);
        }
        return arr;
    }

	//エラストテネスの篩
	public ArrayList<Integer> getPrimeNumsUnder(int integer) {
        ArrayList<Integer> sievedNums = getNaturalNumsLowerThan(integer);
        sievedNums.remove(0);
        for(int i = 0; i < sievedNums.size(); i++) {
            int unFoundPrime = sievedNums.get(0);
            sievedNums = getSievedNumsFor(sievedNums.get(0), sievedNums);
            sievedNums.add(unFoundPrime);
        }
		return sievedNums;
	}

    public boolean isPrime(int integer) {
        ArrayList<Integer> primes = this.getPrimeNumsUnder((int)Math.floor(Math.sqrt(integer)));
        // Logger logger = LoggerFactory.getLogger(IntegerServiceImpl.class);
        // logger.info(primes.toString());
        if(integer == 1) {
            return false;
        }
        for(int i = 0; i < primes.size(); i++) {
            if(integer % primes.get(i) == 0) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Integer> convertToArrayListFrom(int[] arr) {
        return (ArrayList<Integer>) Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    public int[] convertIntsFrom(ArrayList<Integer> arr) {
        int[] ints = new int[arr.size()];
        for(int i = 0;i < arr.size();i++) {
            ints[i] = arr.get(i);
        }
        return ints;
    }

    public ArrayList<Integer> getSievedNumsFor(int sieve, ArrayList<Integer> nums) {
        for(int i = 0; i < nums.size(); i++) {
            if(nums.get(i).intValue() % sieve == 0) {
                nums.remove(i);
                i--;
            }
        }
        return nums;
    }

    public ArrayList<Integer> getCoprimeNumsLowerThan(int integer) {
        ArrayList<Integer> nums = this.getNaturalNumsLowerThan(integer);
        for(int k = 2; k <= integer;k++) {
            if(integer % k == 0) {
                nums = this.getSievedNumsFor(k, nums);
            }
        }
        return nums;
    }

    public int getEulerPhiFunctionValOf(int integer) {
        return this.getCoprimeNumsLowerThan(integer).size();
    }

    //お試しで書いている。
    public String getStringForMathJaxAboutCayleyTableFrom(int input, int output) {
        return "\\begin{array} {|c|c|} \\hline \\cdot & 0_1 & 0_2 & 0_3 \\\\ \\hline 1_0 & 1_1 & 1_2 & 1_3 \\\\ \\hline 2_0 & 2_1 & 2_2 & 2_3 \\\\ \\hline 3_0 & 3_1 & 3_2 & 3_3 \\\\ \\hline  \\end{array}";
    }

}
