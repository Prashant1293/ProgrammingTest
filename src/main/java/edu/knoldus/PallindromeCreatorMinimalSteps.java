package edu.knoldus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PallindromeCreatorMinimalSteps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string for pallindrome creation in minimal steps: ");
        String input = scanner.nextLine();
        String reverseInput = new StringBuffer(input).reverse().toString();
        char[] inputCharArr = input.toCharArray();
        char[] reverseCharArr = reverseInput.toCharArray();
        List<String> pairs = new ArrayList<>();
        if (input.length() == 2) {
            int count = input.equalsIgnoreCase(reverseInput) ? 0 : 1;
            System.out.println(" The minimal steps required are = " + count + " , and string is "
                    + (count > 0 ? input + input.charAt(0) : input));
        } else {
            for (int i = inputCharArr.length - 1; i >= 1; i -= 2) {
                pairs.add(inputCharArr[i] + inputCharArr[i - 1] + "");
            }
            //start comparing the pairs...
            for (int index = 0; index < pairs.size(); index++) {
                if (pairs.get(index).equals(pairs.get(index+1))){
                    int count = input.equalsIgnoreCase(reverseInput) ? 0 : 1;
                    System.out.println(" The minimal steps required are = " + count + " , and string is "
                            + (count > 0 ? input + input.charAt(0) : input));
                }
            }
        }
    }
}
