package designpatterns.creational.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class would help to understand the usage of singleton pattern, and its different forms.
 */
public class SingletonDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger("SingletonDemo");
    
    public static void main(String[] args) {
        BasicSingleton basicSingletonInstance1 = BasicSingleton.getInstance();
        BasicSingleton basicSingletonInstance2 = BasicSingleton.getInstance();
        // Since we create instances of a singleton they should be equal.
        if (basicSingletonInstance1 == basicSingletonInstance2) {
            LOGGER.info("Both the instances of BasicSingleton Class were equal, their hashcode was: {}.",
                    basicSingletonInstance1.hashCode());
        }
    }
    
}
