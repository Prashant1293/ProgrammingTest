package edu.knoldus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlayWithString {
    
    //Ques: I have noticed people using private final String name; and at places private String name;
    // So the ques here is to test the difference between these 2 statements.
    private static final Logger LOGGER = LoggerFactory.getLogger(PlayWithString.class);
    private final String finalName;
    
    private String nonFinalName;
    
    private PlayWithString() {
        this.finalName = "Hello";
        this.nonFinalName = "non-Final-Hello";
        LOGGER.info("non-final-name = {}.", nonFinalName);
        LOGGER.info("final-name = {}.", finalName);
    }
    
    public static void main(String[] args) {
        PlayWithString obj = new PlayWithString();
        //obj.finalName = "Can't Set this since it was final."; If try to uncomment this would result in a compile time error.
        obj.nonFinalName = "Can Set to a new name since it was not final";
        LOGGER.info("non-final-name = {}.", obj.nonFinalName);
        LOGGER.info("final-name = {}.", obj.finalName);
        
        //-----------Reason as to why final string cannot be reassigned a value-----------
        // when we declare a String variable final it means that this
        // variable cannot refer to a different value in the constant pool. It means that the reference once made would be a constant
        // and cannot be changed at later stage. If we do not set the String variable final it means that this variable can hold the reference
        // to a different value in the string pool. So when we say that Strings are by default immutable in java that means that when you append
        // something to an existing String a new string variable is created in the constant pool and the value before the append operation
        // and value after the append operation both exist in the pool. Now if your String variable was not declared final then it
        // would now start pointing to this new value(after append value) in the pool and the reference to previous value(before append value)
        // in the pool would be lost.
    }
}
