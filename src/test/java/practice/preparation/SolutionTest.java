package practice.preparation;

import com.fasterxml.jackson.databind.ObjectMapper;
import practice.preparation.hackerrank.Solution;
import org.junit.Test;

import java.io.File;

public class SolutionTest {
    private Solution obj = new Solution();
    private static final ObjectMapper MAPPER = new ObjectMapper();
    
    @Test
    public void testDynamicArrayMethod() {
        int sequenceCount = 100000;
        int querySize = 100000;
        File testData = null;
        try {
            testData = new File("/home/knoldus/Documents/rccl/programmingtest/src/test/resources/SolutionTestData");
        } catch (Exception ex) {
            System.out.println("Do nothing.");
        }
        try {
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
