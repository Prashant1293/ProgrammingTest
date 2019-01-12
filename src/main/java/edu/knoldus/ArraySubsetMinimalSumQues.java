package edu.knoldus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Finds a smallest positive integer value that cannot be represented as the sum of any subset of a given array.
 */
public class ArraySubsetMinimalSumQues {
    
    public List<Integer> processingOnSubsets(int set[]) {
        int n = set.length;
        
        List<Integer> sumList = new ArrayList<>();
        
        // Run a loop for printing all 2^n
        // subsets one by obe
        for (int i = 0; i < (1 << n); i++) {
            
            int sum = 0;
            
            // Print current subset
            for (int j = 0; j < n; j++) {
                // (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not
                if ((i & (1 << j)) > 0) {
                    sum += set[j];
                }
            }
            
            if (sum != 0) {
                sumList.add(sum);
            }
        }
        
        sortSumElements(sumList);
        
        return getUniqueSumOfSubsets(sumList);
    }
    
    private void sortSumElements(List<Integer> sumsList) {
        Collections.sort(sumsList);
    }
    
    private List<Integer> getUniqueSumOfSubsets(List<Integer> sortedList) {
        return sortedList.stream().distinct().collect(Collectors.toList());
    }
    
    public int getMinimalIntegerNotASumOfAnySubset(List<Integer> finalList) {
        if (finalList.get(0) != 1) {
            return 1;
        } else {
            List<Integer> minimum = new ArrayList<>();
            
            IntStream.range(0, finalList.size() - 1)
                    .forEach(index -> {
                        if ((finalList.get(index + 1) - finalList.get(index)) > 1) {
                            minimum.add(finalList.get(index) + 1);
                        }
                    });
            return minimum.isEmpty() ? (finalList.get(finalList.size() - 1) + 1) : minimum.get(0);
        }
    }
    
    public static void main(String[] args) {
        int set[] = {1, 3, 6, 10, 11, 15};
        ArraySubsetMinimalSumQues obj = new ArraySubsetMinimalSumQues();
        List<Integer> sumSubset = obj.processingOnSubsets(set);
        
        int minimalElement = obj.getMinimalIntegerNotASumOfAnySubset(sumSubset);
        
        System.out.println("MinimalElement is = " + minimalElement);
        
    }
}
