package practice.preparation.hackerrank;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Solves the problem statement provided here: https://www.hackerrank.com/challenges/divisible-sum-pairs/problem
 */
public class DivisibleSumPairProblem {
    static AtomicInteger count = new AtomicInteger(0);
    
    static int divisibleSumPairs(int n, int k, int[] ar) {
        for (int i = 0; i < ar.length - 1; i++) {
            for (int j = i + 1; j < ar.length; j++) {
                if ((ar[i] + ar[j]) % k == 0 && i < j) {
                    count.incrementAndGet();
                }
            }
        }
        return count.intValue();
    }
    
    
    public static void main(String[] args) {
        int n = 6;
        int k = 3;
        int[] ar = {1, 3, 2, 6, 1, 2};
        
        System.out.println(divisibleSumPairs(n, k, ar));
    }
}
