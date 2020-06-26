package impetus;

import java.util.HashMap;
import java.util.Map;

/**
 * Question: Find the index of the character or the character itself that is non-repeated in the input string.
 */
public class StringComp {
    public static void main(String[] args) {
        String inp = "stress";
        int[] pos = {-1};
        char[] chars = inp.toCharArray();
        Map<Character, Integer> counts = new HashMap<>();
        
        for (char aChar : chars) {
            if (!counts.containsKey(aChar)) {
                counts.put(aChar, 1);
            } else {
                counts.computeIfPresent(aChar, (key, value) -> value + 1);
            }
        }
        
        counts.keySet().forEach(key -> {
            if (counts.get(key) == 1) {
                if (pos[0] != -1 && pos[0] > inp.indexOf(key)) {
                    pos[0] = inp.indexOf(key);
                } else if (pos[0] == -1) {
                    pos[0] = inp.indexOf(key);
                }
            }
        });
        
        if (pos[0] == -1) {
            System.out.println("The string contains repeatable characters only.");
        } else {
            System.out.println("The first character not to repeat is at pos = " + pos[0]
                    + " and it is = " + inp.charAt(pos[0]));
        }
    }
}

// Output of the program is:
// The first character not to repeat is at pos = 1 and it is = t
