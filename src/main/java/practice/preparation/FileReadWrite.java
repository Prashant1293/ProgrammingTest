package practice.preparation;

import java.io.File;

public class FileReadWrite {
    //How to read all the lines from a large file in Java in an efficient manner.
    
    public static void main(String[] args) {
        FileReadWrite obj = new FileReadWrite();
        obj.readFileStandardWay();
        
        //we usually don’t need all of the lines in the file in memory at once so why should we load all the content
        // of a large file all at once in the memory?
        //1 solution is to use streaming through the file using java.util.Scanner to run through the contents of the
        // file and retrieve lines serially, one by one.
        // @link Solutions are here: https://www.baeldung.com/java-read-lines-large-file?utm_source=email-newsletter&utm_medium=email&utm_campaign=auto_32_java&tl_inbound=1&tl_target_all=1&tl_period_type=3
    }
    
    /**
     * The standard way of reading the lines of the file is in memory.
     */
    private void readFileStandardWay() {
        //keeping in memory the contents of the file will quickly exhaust the available memory at some point.
        File enronJson = new File("src/main/resources/enron.json");
        
        System.out.println("\n total file length =" + enronJson.length());
        
    }
}
