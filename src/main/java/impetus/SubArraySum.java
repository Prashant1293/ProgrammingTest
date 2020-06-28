package impetus;

/**
 * Question: To find the array subset index/ranges in the input array whose value's sum would be equal to a given integer sum.
 */
public class SubArraySum {
    
    private static void printArraySubsets(int[] arr, int sum) {
        for (int i = 0; i < arr.length; i++) {
            int subsetSum = arr[i];
            int j = i + 1;
            if (arr[i] == sum) {
                System.out.println(i);
            } else {
                while (j < arr.length) {
                    if (subsetSum != sum) {
                        subsetSum += arr[j];
                    } else {
                        System.out.println(i + " to " + (j - 1));
                    }
                    j++;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {-20, -10, 10, 2, -2, -20, 10, -10};
        int sum = -10;
        
        printArraySubsets(arr, sum);
    }
}

// Output of the above program, denoting the index ranges that would contain the requested sum:
// 1
// 2 to 5