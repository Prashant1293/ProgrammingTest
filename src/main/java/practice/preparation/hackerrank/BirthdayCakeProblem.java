package practice.preparation.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Refer to the problem here: https://www.hackerrank.com/challenges/the-birthday-bar/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign&h_r=next-challenge&h_v=zen
 */
public class BirthdayCakeProblem {
    static List<List<Integer>> mList = new ArrayList<>();
    static List<Integer> subsets = new ArrayList<>();
    
    static int birthday(List<Integer> s, int d, int m) {
        for (int i = 0; i < s.size(); i++) {
            for (int j = i; (j < (i + m) ) && ((i + m) <= s.size()); j++) {
                subsets.add(s.get(j));
            }

            mList.add(subsets);
            subsets = new ArrayList<>();
        }
        Long count = mList.stream().filter(sub -> isRequiredSum(sub, d)).count();
        return count.intValue();
    }
    
    static boolean isRequiredSum(List<Integer> subsetToCheck, int sum) {
        return subsetToCheck.stream().mapToInt(ele -> ele).sum() == sum;
    }
    
    public static void main(String[] args) {
        List<Integer> inputs = new ArrayList<>();
        int[] ints = {1,2,1,3,2};
        Arrays.stream(ints).forEach(inputs::add);
        int d = 3;
        int m = 2;
        
        System.out.println(birthday(inputs, d, m));
    }
}
