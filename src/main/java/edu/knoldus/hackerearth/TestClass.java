package edu.knoldus.hackerearth;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/*
This is the brute force method to capture the greater & greaterThanAndEqual values, space and time constraints is an issue.
class TestClass {
    private final static int GREATER_THAN_OR_EQUAL = 0;
    private final static int GREATER_THAN = 1;
    
    public static void main(String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String name = br.readLine();
        
        //Scanner
        Scanner s = new Scanner(System.in);
        int inputLength = s.nextInt();
        //int inputLength = br.read();
        Integer[] input = new Integer[inputLength];
        IntStream.range(0, inputLength)
                .forEach(index ->
                        input[index] = s.nextInt()
                );
        int querySize = s.nextInt();
        int[][] queries = new int[querySize][2];
        IntStream.range(0, querySize)
                .forEach(index ->
                {
                    queries[index][0] = s.nextInt();
                    queries[index][1] = s.nextInt();
                });
        
        // Write your code here
        // Sort the input first for binary searching.
        Arrays.sort(input);
        
        List<Integer> sortedInput = Arrays.asList(input);
        //System.out.println("sorted array = " + sortedInput);
        int max = sortedInput.get(inputLength - 1);
        int min = sortedInput.get(0);
        int[] answers = new int[querySize];
        
        IntStream.range(0, querySize)
                .forEach(pos -> {
                    int queryType = queries[pos][0];
                    int value = queries[pos][1];
                    
                    // If value to be searched for is max in the input array.
                    if (value == max && queryType == GREATER_THAN) {
                        answers[pos] = 0;
                    } else if (value == max && queryType == GREATER_THAN_OR_EQUAL) {
                        answers[pos] = sortedInput.parallelStream().filter(item -> item == max)
                                .collect(Collectors.toList()).size();
                    }
                    
                    // If value to be searched for is min in the input array.
                    else if (value == min && queryType == GREATER_THAN) {
                        answers[pos] = inputLength - sortedInput.parallelStream().filter(item -> item == min)
                                .collect(Collectors.toList()).size();
                    } else if (value == min && queryType == GREATER_THAN_OR_EQUAL) {
                        answers[pos] = inputLength;
                    }
                    
                    // For the cases when the value to be searched for lies out of bounds in the input array.
                    else if (value < min) {
                        answers[pos] = inputLength;
                    } else if (value > max) {
                        answers[pos] = 0;
                    }
                    
                    // Final case would be when the value to be searched for lies in b/w min and max values.
                    else if (value > min && value < max) {
                        int mid = findMid(inputLength);
                        
                        if (value <= sortedInput.get(mid)) {
                            
                            if (queryType == GREATER_THAN) {
                                answers[pos] = inputLength - mid - 1;
                                for (int i = 0; i <= mid; i++) {
                                    if (value < sortedInput.get(i)) {
                                        answers[pos] = inputLength - i;
                                        break;
                                    }
                                }
                            }
                            if (queryType == GREATER_THAN_OR_EQUAL) {
                                answers[pos] = inputLength - mid;
                                for (int i = 0; i < mid; i++) {
                                    if (value <= sortedInput.get(i)) {
                                        answers[pos] = inputLength - i;
                                        break;
                                    }
                                }
                            }
                        } else {
                            if (queryType == GREATER_THAN) {
                                answers[pos] = inputLength - mid - 1;
                                for (int i = mid + 1; i < inputLength; i++) {
                                    if (value < sortedInput.get(i)) {
                                        answers[pos] = inputLength - i;
                                        break;
                                    }
                                }
                            }
                            if (queryType == GREATER_THAN_OR_EQUAL) {
                                answers[pos] = inputLength - mid;
                                for (int i = mid + 1; i < inputLength; i++) {
                                    if (value <= sortedInput.get(i)) {
                                        
                                        answers[pos] = inputLength - i;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                });
        IntStream.range(0, querySize).forEach(queryIndex -> System.out.println(answers[queryIndex]));
    }
    
    private static int findMid(int length) {
        if (length % 2 == 0) {
            return length / 2;
        }
        return (length + 1) / 2;
    }
}
*/

// This is a Map implementation for the same query let's see if this resolves the space and time constraint.
// This one is concise and less complex as compared to the above implementation but still not fast enough to be considered good.
public class TestClass {
    private final static int GREATER_THAN_OR_EQUAL = 0;
    private final static int GREATER_THAN = 1;
    
    public static void main(String[] args) {
        //Scanner
        Scanner s = new Scanner(System.in);
        int inputLength = s.nextInt();
        //Integer[] input = new Integer[inputLength];
        Map<Integer, Integer> values = new Hashtable<>();
        
        // Insert values to the map with their counts.
        IntStream.range(0, inputLength)
                .forEach(index ->
                        {
                            int num = s.nextInt();
                            if (values.containsKey(num)) {
                                values.put(num, values.get(num) + 1);
                            } else {
                                values.put(num, 1);
                            }
                        }
                );
        Integer querySize = s.nextInt();
        //int[][] queries = new int[querySize][2];
        /*IntStream.range(0, querySize)
                .forEach(index ->
                {
                    queries[index][0] = s.nextInt();
                    queries[index][1] = s.nextInt();
                })*/
        
        Integer[] answers = new Integer[querySize];
        IntStream.range(0, querySize)
                .forEach(pos -> {
                    int queryType = s.nextInt();
                    int value = s.nextInt();
                    
                    if (queryType == GREATER_THAN_OR_EQUAL) {
                        values.keySet().stream()
                                .filter(key -> key >= value)
                                .forEach(resultSet -> {
                                    answers[pos] = answers[pos] + values.get(resultSet);
                                });
                    } else if (queryType == GREATER_THAN) {
                        values.keySet().stream()
                                .filter(key -> key > value)
                                .forEach(resultSet -> {
                                    answers[pos] = answers[pos] + values.get(resultSet);
                                });
                    }
                });
        IntStream.range(0, querySize).forEach(index -> System.out.println(answers[index]));
    }
}
