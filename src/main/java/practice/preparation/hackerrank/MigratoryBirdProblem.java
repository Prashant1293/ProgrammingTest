package practice.preparation.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Solution to the problem listed here: https://www.hackerrank.com/challenges/migratory-birds/problem.
 */
public class MigratoryBirdProblem {
    static int keyPos = 0;
    static int maxValuePos = 1;
    static Integer[] answer = {0, 0};
    
    static int migratoryBirds(List<Integer> arr) {
        Map<Integer, Integer> mappings = new HashMap<>();
        IntStream.range(0, 5).forEach(index -> mappings.put(index + 1, 0));
        
        arr.forEach(input -> mappings.computeIfPresent(input, (k, v) -> v + 1));
        mappings.keySet().forEach(key -> getMaxPosSet(key, mappings));
        return answer[keyPos];
    }
    
    private static void getMaxPosSet(int key, Map<Integer, Integer> mappings) {
        Integer value = mappings.get(key);
        if (value > answer[maxValuePos] && key > answer[keyPos]) {
            answer[maxValuePos] = value;
            answer[keyPos] = key;
        } else if (value.intValue() == answer[maxValuePos] && key < answer[keyPos]) {
            answer[keyPos] = key;
        }
    }
    
    public static void main(String[] args) {
        int[] migratoryBirds = {1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4};
        List<Integer> integers = new ArrayList<>();
        
        Arrays.stream(migratoryBirds).forEach(integers::add);
        System.out.println(migratoryBirds(integers));
    }
}
