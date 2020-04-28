package edu.knoldus.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * The question is available here:
 * https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/monk-and-search-2/
 */

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
    
    public static void main(String[] args) throws Exception {
        //Scanner
        //Scanner s = new Scanner(System.in);
        //FastReader reader = new FastReader();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //int inputLength = s.nextInt();
        //int inputLength = reader.nextInt();
        Map<Integer, Integer> values = new Hashtable<>();
        int inputLength = Integer.parseInt(bf.readLine());
        StringTokenizer tk = new StringTokenizer(bf.readLine());
        
        for (int i = 0; i < inputLength; i++) {
            int num = Integer.parseInt(tk.nextToken());
            if (values.containsKey(num)) {
                values.put(num, values.get(num) + 1);
            } else {
                values.put(num, 1);
            }
        }
        // Insert values to the map with their counts.
        /*IntStream.range(0, inputLength)
                .forEach(index ->
                        {
                            //int num = s.nextInt();
                            int num = reader.nextInt();
                            
                            if (values.containsKey(num)) {
                                values.put(num, values.get(num) + 1);
                            } else {
                                values.put(num, 1);
                            }
                        }
                );*/
        //int querySize = s.nextInt();
        //int querySize = reader.nextInt();
        int querySize = Integer.parseInt(bf.readLine());
        int[] answers = new int[querySize];

        /*IntStream.range(0, querySize)
                .forEach(pos -> {
                    //int queryType = s.nextInt();
                    int queryType = reader.nextInt();
                    //int value = s.nextInt();
                    int value = reader.nextInt();
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
        */
        for (int i = 0; i < querySize; i++) {
            int pos = i;
            //int queryType = s.nextInt();
            String[] query = bf.readLine().split("\\s");
            int queryType = Integer.parseInt(query[0]);
            //int value = s.nextInt();
            int value = Integer.parseInt(query[1]);
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
            System.out.println(answers[pos]);
        }
        // Print the answers to the console
        /*IntStream.range(0, querySize)
                .forEach(index -> {
                    System.out.println(answers[index]);
                });*/
        
        /*for (int i =0 ; i < querySize; i++){
            sou
        }*/
        
    }
    
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        
        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

/*

// Some random code for making I/O faster, but something is still wrong and i need to figure it out.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TestClass {
    
    public static void main(String[] args) {
        
        FastReader reader = new FastReader();
        
        int size = reader.nextInt();
        
        int[] array = new int[size];
        
        for (int i = 0; i < size; i++) {
            array[i] = reader.nextInt();
        }
        
        Arrays.sort(array);
        
        int queryCount = reader.nextInt();
        
        for (int i = 0; i < queryCount; i++) {
            
            int queryType = reader.nextInt();
            
            int x = reader.nextInt();
            
            int numberCount = countNumbers(queryType, x, array);
            
            System.out.println(numberCount);
        }
    }
    
    private static int countNumbers(int queryType, int x, int[] array) {
        
        switch (queryType) {
            
            case 0:
                return countNotLessNumbers(x, array);
            
            case 1:
                return countGreaterNumbers(x, array);
            
            default:
                throw new RuntimeException("Unknown query type.");
        }
    }
    
    private static int countGreaterNumbers(int x, int[] sortedArray) {
        
        int count = 0;
        
        int low = 0;
        int high = sortedArray.length - 1;
        
        while (low <= high) {
            
            int mid = (high + low) / 2;
            
            if (sortedArray[mid] > x) {
                
                count += (high - mid + 1);
                high = mid - 1;
                
            } else {
                low = mid + 1;
            }
        }
        
        return count;
    }
    
    private static int countNotLessNumbers(int x, int[] sortedArray) {
        
        int count = 0;
        
        int low = 0;
        int high = sortedArray.length - 1;
        
        while (low <= high) {
            
            int mid = (high + low) / 2;
            
            if (sortedArray[mid] >= x) {
                
                count += (high - mid + 1);
                high = mid - 1;
                
            } else {
                low = mid + 1;
            }
        }
        
        return count;
    }
    
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        
        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }
        
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        
        int nextInt() {
            return Integer.parseInt(next());
        }
        
        long nextLong() {
            return Long.parseLong(next());
        }
        
        double nextDouble() {
            return Double.parseDouble(next());
        }
        
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}*/
