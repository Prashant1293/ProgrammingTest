package designpatterns.creational.singleton;

/**
 * Protecting our Singleton model from use of reflection to create different objects and to avoid its failure in a
 * multithreaded environment we will modify the {@link LazyBindSingleton} implementation a bit.
 */
public class ThreadAndReflectionSafeSingleton {
    /**
     * For multithreaded applications, we need to ensure a couple of rules for consistent behavior:
     * Mutual Exclusion – only one thread executes a critical section at a time.
     * Visibility – changes made by one thread to the shared data are visible to other threads to maintain data
     * consistency.
     * <p>
     * synchronized methods and blocks provide both of the above properties, at the cost of application performance.
     * <p>
     * volatile is quite a useful keyword because it can help ensure the visibility aspect of the data change without,
     * of course, providing mutual exclusion. Thus, it's useful in the places where we're ok with multiple threads
     * executing a block of code in parallel, but we need to ensure the visibility property.
     * <p>
     * Technically speaking, any write to a volatile field happens before every subsequent read of the same field.
     */
    // Though volatile is self-sufficient to make our singleton thread safe, I'll still add a synchronization block
    // to the getInstance() of the class just to make sure I can show the double-lock-check procedure.
    private static volatile ThreadAndReflectionSafeSingleton instance;

    private ThreadAndReflectionSafeSingleton() {
        // Checking and throwing an exception if the constructor is used for instance creation using reflection.
        if (instance != null) {
            throw new RuntimeException("Call getInstance() of the ThreadAndReflectionSafeSingleton class to get an"
                    + " instance.");
        }
    }

    // We will use the Double-lock-check strategy here to make the singleton thread safe, focus on the placement of
    // the synchronization keyword.
    public static ThreadAndReflectionSafeSingleton getInstance() {
        if (instance == null) {
            // Now create synchronized block on the class.
            synchronized (ThreadAndReflectionSafeSingleton.class) {
                // Double check lock on the instance.
                if (instance == null) {
                    instance = new ThreadAndReflectionSafeSingleton();
                }
            }
        }
        return instance;
    }
}
