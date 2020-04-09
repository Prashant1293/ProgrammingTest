package designpatterns.creational.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;

/**
 * This class would help to understand the usage of singleton pattern, and its different forms.
 * Though there are many ways through which the singleton property of a class could be destroyed, we will take a look at
 * a few. Though, using Enums in place of class to create singletons is the best possible way to make it robust to the
 * destructive hacks.
 */
public class SingletonDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger("SingletonDemo");

    public static void main(String[] args) {
        LOGGER.info("\n----Main method calls to instantiate different forms of singletons.----.\n");
        // 1st form of Singleton:: EarlyBinding.
        EarlyBindSingleton earlyBindSingletonInstance1 = EarlyBindSingleton.getInstance();
        EarlyBindSingleton earlyBindSingletonInstance2 = EarlyBindSingleton.getInstance();
        // Since we create instances of a singleton they should be equal.
        if (earlyBindSingletonInstance1 == earlyBindSingletonInstance2) {
            LOGGER.info("Both the instances of BasicSingleton Class were equal, their hashcode was: {}.",
                    earlyBindSingletonInstance1.hashCode());
        }

        // 2nd form of Singleton:: LazyBinding.
        LazyBindSingleton lazyBindSingleton1 = LazyBindSingleton.getInstance();
        LazyBindSingleton lazyBindSingleton2 = LazyBindSingleton.getInstance();
        // Since we create instances of a singleton they should be equal.
        if (lazyBindSingleton1 == lazyBindSingleton2) {
            LOGGER.info("Both the instances of LazyBindSingleton Class were equal, their hashcode was: {}.",
                    lazyBindSingleton1.hashCode());
        }

        // 3rd form of Singleton:: ThreadAndReflectionSafeSingleton.
        ThreadAndReflectionSafeSingleton threadAndReflectionSafeSingleton1 = ThreadAndReflectionSafeSingleton.getInstance();
        ThreadAndReflectionSafeSingleton threadAndReflectionSafeSingleton2 = ThreadAndReflectionSafeSingleton.getInstance();
        // Since we create instances of a singleton they should be equal.
        if (threadAndReflectionSafeSingleton1 == threadAndReflectionSafeSingleton2) {
            LOGGER.info("Both the instances of ThreadAndReflectionSafeSingleton Class were equal, their hashcode was: {}.",
                    threadAndReflectionSafeSingleton1.hashCode());
        }

        // In a multithreading environment the hashcode from Early and Lazy bind classes should be different from what
        // is already created in steps above.
        new Thread2().start();

        singletonDestroyerWithReflection();
    }

    /**
     * Singleton property destroyer method, that would successfully destroy the {@link LazyBindSingleton} and
     * {@link EarlyBindSingleton} properties. This uses the Reflection support from {@code java.lang.reflect.Constructor}
     * to break singletons. Though this won't be able to destroy the {@link ThreadAndReflectionSafeSingleton} class
     * because that is resilient to Reflection hacks.
     */
    private static void singletonDestroyerWithReflection() {
        LOGGER.info("\n----Using Singleton destroyer method with reflection to break singletons----.\n");
        LazyBindSingleton lazyBindSingleton1 = LazyBindSingleton.getInstance();
        LazyBindSingleton lazyBindSingleton2 = null;

        // This would work fine when trying to destroy LazyBindSingleton instance.
        try {
            Constructor[] constructors = LazyBindSingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                constructor.setAccessible(true);
                lazyBindSingleton2 = (LazyBindSingleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (lazyBindSingleton1 != lazyBindSingleton2) {
            LOGGER.info("Instances for LazyBindSingleton were not the same, when reflection was used.");
            LOGGER.info("Hashcode for lazyInstance1 = {}, and for lazyInstance2 = {}.", lazyBindSingleton1.hashCode(),
                    lazyBindSingleton2.hashCode());
        }

        // Now try to use reflection to destroy the ReflectionAndThreadSafeSingleton instance??
        ThreadAndReflectionSafeSingleton threadAndReflectionSafeSingleton1 = null;
        try {
            Constructor[] constructors = ThreadAndReflectionSafeSingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                constructor.setAccessible(true);
                threadAndReflectionSafeSingleton1 = (ThreadAndReflectionSafeSingleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            LOGGER.error("Reflection failed when trying to destroy the ThreadAndReflection safe singleton implementation.");
            LOGGER.error("Error encountered = {}.", e.getCause().getMessage());
        }
    }

    private static class Thread2 extends Thread {
        @Override
        public void run() {
            LOGGER.info("\n------ From Thread 2 -------\n");
            LOGGER.info("The hashcode for Early bind singleton class = {}.", EarlyBindSingleton.getInstance().hashCode());
            LOGGER.info("The hashcode for Lazy bind singleton class = {}.", LazyBindSingleton.getInstance().hashCode());
            LOGGER.info("The hashcode for Reflection and Thread Safe singleton class = {}.",
                    ThreadAndReflectionSafeSingleton.getInstance().hashCode());
        }
    }
}