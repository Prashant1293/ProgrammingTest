package edu.knoldus;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class UnmodifiableVsImmutableTest {
    
    @Test
    public void testList() {
        
        List<String> modifiableList = new ArrayList<>();
        //Add your name to the modifiable list.
        modifiableList.add("Prashant");
        
        System.out.println("modifiableList:" + modifiableList);
        
        assertEquals(1, modifiableList.size());
        
        //unModifiableList created using the Collections.unmodifiableList() helper.
        List<String> unModifiableList = Collections.unmodifiableList(
                modifiableList);
        
        //Add your friend's name to the modifiable list, this would work since it is an unmodifiable list..
        modifiableList.add("Harmeet");
        
        boolean exceptionThrown = false;
        try {
            //Try adding your other friend's name to the un-modifiable list, which would throw an exception..
            unModifiableList.add("Mukesh");
            fail("add() supported for unModifiableList, that's a blunder!!");
        } catch (UnsupportedOperationException e) {
            exceptionThrown = true;
            System.out.println("unModifiableList.add() not supported");
        }
        
        assertTrue(exceptionThrown);
        
        //Even though when trying to add the friend Mukesh failed in the unmodifiable list you would still see that the
        // contents of both modifiable and unmodifiable lists have changed and Harmeet is present in both now.
        System.out.println("\nmodifiableList:" + modifiableList);
        System.out.println("unModifiableList:" + unModifiableList);
        
        assertEquals(2, modifiableList.size());
        assertEquals(2, unModifiableList.size());
        
        
        //Let us know test for the immutableList
        List<String> immutableList = Collections.unmodifiableList(new ArrayList<>(modifiableList));
        
        //Try adding your other friend's name(Mukesh) to the modifiable list.
        modifiableList.add("Mukesh");
        
        exceptionThrown = false;
        try {
            //Try adding your other friend's name(Mukesh) to the immutable list, which would throw an exception.
            immutableList.add("Mukesh");
            fail("add supported for immutableList, that's a blunder!!");
        } catch (UnsupportedOperationException e) {
            exceptionThrown = true;
            System.out.println("\nimmutableList.add() not supported");
        }
        assertTrue(exceptionThrown);
        
        //When trying to add the friend Mukesh failed in the immutable list you would see that the contents of immutable list have not changed
        // unlike the changed content of the unmodifiable list where you now would see that Mukesh is also present now.
        System.out.println("\n\nmodifiableList:" + modifiableList);
        System.out.println("unModifiableList:" + unModifiableList);
        System.out.println("immutableList:" + immutableList);
        
        assertEquals(3, modifiableList.size());
        assertEquals(3, unModifiableList.size());
        assertEquals(2, immutableList.size());
        
    }
}
