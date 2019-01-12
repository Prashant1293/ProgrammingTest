package edu.knoldus;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ArraySubsetMinimalSumQuesTest {
    
    @Test
    public void shouldTestTheMinimalElementThatCannotBeFormedFromTheSubsetOfArray() {
        int[] testInput1 = {4, 1, 3, 1};
        int[] testInput2 = {1, 1, 1, 1};
        int[] testInput3 = {1, 2, 5, 10, 20, 40};
        int[] testInput4 = {4, 3, 5, 2, 1, 6};
        List<Integer> minimalElementsForTestCases = new ArrayList<>();
        
        ArraySubsetMinimalSumQues obj = new ArraySubsetMinimalSumQues();
        
        minimalElementsForTestCases.add(obj.getMinimalIntegerNotASumOfAnySubset((obj.processingOnSubsets(testInput1))));
        minimalElementsForTestCases.add(obj.getMinimalIntegerNotASumOfAnySubset((obj.processingOnSubsets(testInput2))));
        minimalElementsForTestCases.add(obj.getMinimalIntegerNotASumOfAnySubset((obj.processingOnSubsets(testInput3))));
        minimalElementsForTestCases.add(obj.getMinimalIntegerNotASumOfAnySubset((obj.processingOnSubsets(testInput4))));
        
        assertEquals(minimalElementsForTestCases.get(0), 10, 0);
        assertEquals(minimalElementsForTestCases.get(1), 5, 0);
        assertEquals(minimalElementsForTestCases.get(2), 4, 0);
        assertEquals(minimalElementsForTestCases.get(3), 22, 0);
    }
}
