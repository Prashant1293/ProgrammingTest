package designpatterns.creational.singleton;

public class LazyBindSingleton {
    // This is Lazy binding.
    private static LazyBindSingleton instance;

    private LazyBindSingleton() {
        // A no-operation private constructor to discourage the creation of new instances from outside the class.
    }

    public static LazyBindSingleton getInstance() {
        // Always return the static instance of the singleton object, if it is not already created.
        if (instance == null) {
            instance = new LazyBindSingleton();
        }

        return instance;
    }
}
