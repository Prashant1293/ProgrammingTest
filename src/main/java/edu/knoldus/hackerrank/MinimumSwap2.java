package edu.knoldus.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MinimumSwap2 {
    
    /*Question: You are given an unordered array consisting of consecutive integers = [1, 2, 3, ..., n] without any duplicates.
     You are allowed to swap any two elements. You need to find the minimum number of swaps required to sort the array in ascending order.
    For example, given the array arr = [7, 1, 3, 2, 4, 5, 6] we perform the following steps:
    i   arr                         swap (indices)
0   [7, 1, 3, 2, 4, 5, 6]   swap (0,3)
1   [2, 1, 3, 7, 4, 5, 6]   swap (0,1)
2   [1, 2, 3, 7, 4, 5, 6]   swap (3,4)
3   [1, 2, 3, 4, 7, 5, 6]   swap (4,5)
4   [1, 2, 3, 4, 5, 7, 6]   swap (5,6)
5   [1, 2, 3, 4, 5, 6, 7]
It took 5 swaps to sort the array.

Link to the question: https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
    */
    
    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        List<Integer> array = new ArrayList();
        //create a list of integers out of the received array so that we can easily find the min and max element of the received array.
        IntStream.range(0, arr.length).forEach(index -> array.add(arr[index]));
        
        //Initial counts for the swaps made.
        int swap = 0;
        
        int min = array.stream().mapToInt(value -> value)
                .min().orElseThrow(NoSuchElementException::new);
        int max = array.stream().mapToInt(value -> value)
                .max().orElseThrow(NoSuchElementException::new);
        
        //start comparing from the very first element of the list.
        int index = 0;
        
        //Loop till the time all minimum elements have not been repositioned to the index where they must be in order for the list to be sorted.
        while (min != max) {
            if (!(min == array.get(index))) {
                //if true means that the element is already at the right position and no need to swap.
                // Find the current position in the list for the element.
                int posToSwap = array.indexOf(min);
                //Save the number that needs to be replaced by the element.
                int temp = array.get(index);
                //Update the list by placing the min element at the right place.
                array.set(index, min);
                array.set(posToSwap, temp);
                //update the swaps.
                ++swap;
            }
            //increment the minimal element and index by 1 since the array consists of consecutive elements/numbers only.
            ++min;
            ++index;
        }
        // Return the swaps count.
        return swap;
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter());
        
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        int[] arr = new int[n];
        
        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }
        
        int res = minimumSwaps(arr);
        System.out.println("Result is = " + res);
        
        scanner.close();
    }
}
