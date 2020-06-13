package practice.preparation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ListCleanUp {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(null, 1, null, 2, null, 3);
        ListCleanUp obj = new ListCleanUp();
        obj.removeNullJava8Approach(myList);
        obj.removeNullPlainJavaApproach(myList);
    }
    
    private void removeNullPlainJavaApproach(List<Integer> sampleList) {
        System.out.println("PlainJava -> Original-List: " + sampleList);
        sampleList.removeAll(Collections.singletonList(null));
        System.out.println("PlainJava -> Altered-List: " + sampleList.size());
    }
    
    private void removeNullJava8Approach(List<Integer> sampleList) {
        System.out.println("Java8 -> Original-List: " + sampleList);
        List<Integer> newList = sampleList.stream().filter(Objects::nonNull).collect(Collectors.toList());
        System.out.println("Java8 -> Altered-List: " + newList);
    }
}
