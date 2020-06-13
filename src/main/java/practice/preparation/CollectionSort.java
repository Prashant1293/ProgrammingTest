package practice.preparation;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionSort {
    public static void main(String[] args) {
        CollectionSort collectionSort = new CollectionSort();
        
        collectionSort.traditionalSortComparator();
        collectionSort.lambdaWayToSortComparator();
        collectionSort.methodReferenceWayToSortComparator();
        try {
            collectionSort.streamSortingListComparators();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void traditionalSortComparator() {
        Comparator<Human> humanComparator = new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                return o1.getName().compareTo(o2.getName());
            }
            
        };
        List<Human> humans = Arrays.asList(Human.builder().name("Prashant").build(),
                Human.builder().name("prashant").build(), Human.builder().name("prash").build());
        System.out.println("\nbefore sorting => " + humans);
        //traditional ways of sorting a collection elements prior to lambda expressions were introduced in java. This
        // uses the concept of anonymous classes.
        Collections.sort(humans, humanComparator);
        System.out.println("\nafter sorting => " + humans);
    }
    
    private void lambdaWayToSortComparator() {
        List<Human> freshHumans = Arrays.asList(new Human("abra", 24, 5.11f),
                new Human("ABRA", 25, 5.11f));
        System.out.println("\nunsorted freshHumans -> " + freshHumans);
        // New way to sort the collection elements using the lambda's power, we’re also using the new sort API added to
        // java.util.List in Java 8 – instead of the old Collections.sort API. Internally the sort() will
        // create an array out of the list elements and then uses merge sort on this array to give the complexity
        // of n log(n). Also if the size of the array you want to be sorted is <7 then InsertionSort is applied
        // rather than the merge sort.
        freshHumans.sort((Human h1, Human h2) -> h1.getName().compareTo(h2.getName()));
        //could also be done by replacing the type of the params in the comparator lambda, the compiler would automatically infer that.
        freshHumans.sort((h1, h2) -> h1.getName().compareTo(h2.getName()));
        
        System.out.println("\nsorted freshHumans -> " + freshHumans);
    }
    
    private void methodReferenceWayToSortComparator() {
        //Alternative to using -> freshHumans.sort((Human h1, Human h2) -> h1.getName().compareTo(h2.getName()))
        List<Human> freshHumans1 = Arrays.asList(new Human("abra", 24, 5.11f),
                new Human("ABRA", 21, 5.11f), new Human("aBRA", 26, 5.11f),
                new Human("aBRo", 23, 5.11f), new Human("aBRo", 22, 5.11f));
        
        List<Human> freshHumans2 = Arrays.asList(new Human("abra", 24, 5.11f),
                new Human("ABRA", 21, 5.11f), new Human("aBRA", 26, 5.11f),
                new Human("aBRo", 23, 5.11f), new Human("aBRo", 22, 5.11f));
        
        System.out.println("\nunsorted freshHumans1 -> " + freshHumans1);
        //Here we use the Comparator.comparing() method API, that would return a comparator instance with comparing key from your collection object.
        freshHumans1.sort(Comparator.comparing(Human::getName)); //will compare every element of the freshHumans1 list
        // on the basis of the name stored in the object.
        System.out.println("\nsorted freshHumans1 -> " + freshHumans1);
        //Now sort the already sorted list in terms of the human age.
        freshHumans1.sort(Comparator.comparing(Human::getAge));
        System.out.println("\nsorted freshHumans1 on age basis -> " + freshHumans1);
        
        freshHumans2.sort(Comparator.comparing(Human::getName).thenComparing(Human::getAge));
        System.out.println("\n\nsorted freshHumans2 on name basis and then on the basis of age -> " + freshHumans1);
        
    }
    
    private void streamSortingListComparators() {
        List<String> freshHumans1 = Arrays.asList("A", "D", "0", "$", "a", "+");
        List<String> simpleSortedList = freshHumans1.stream().sorted().collect(Collectors.toList());//Note: You can only
        // use the `stream.sorted()` on the list whose elements are of the type that implements the Comparable interface.
        // Here it is working bcoz we have a list<String> and String does implement the comparable interface.
        System.out.println("\n\n simple sorted list = " + simpleSortedList);
        
        List<Human> freshHumans2 = Arrays.asList(new Human("abra", 24, 5.11f),
                new Human("ABRA", 21, 5.11f), new Human("aBRA", 26, 5.11f),
                new Human("aBRo", 23, 5.11f), new Human("aBRo", 22, 5.11f));
        List<Human> comparatorSortedList = freshHumans2.stream().sorted(Comparator.comparing(Human::getAge))
                .collect(Collectors.toList());
        System.out.println("\n\n comparator sorted list = " + comparatorSortedList);
        
    }
}

@AllArgsConstructor
@Builder
@Value
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class Human {
    String name;
    int age;
    Float height;
}

