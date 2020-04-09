package designpatterns.creational.singleton;

/**
 * A basic singleton class showing the basic form of using the singleton pattern.
 * This does not depict the usage of lazy binding or thread safety practices in singleton pattern.
 */
public class EarlyBindSingleton {
    // This is eagerly binding which makes program execution slow if there are multiple such bindings.
    private static EarlyBindSingleton instance = new EarlyBindSingleton();
    
    private EarlyBindSingleton() {
        // A no-operation private constructor to discourage the creation of new instances from outside the class.
    }
    
    public static EarlyBindSingleton getInstance() {
        // Always return the static instance of the singleton object.
        return instance;
    }
}
