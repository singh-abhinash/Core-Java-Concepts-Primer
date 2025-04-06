package typesOfClasses;

public class SingletonClassExample {

    // 1. Eager Initialization
    public static class EagerSingletonDbConnection {
        // The instance is created at the time of class loading.
        // This is a static final variable, meaning it is a constant and cannot be reassigned.
        private static final EagerSingletonDbConnection instance = new EagerSingletonDbConnection();
        
        // Private constructor to prevent the creation of additional instances from outside the class.
        private EagerSingletonDbConnection() {}

        // Public method to return the singleton instance.
        // Since the instance is already created, this just returns the existing one.
        public static EagerSingletonDbConnection getInstance() {
            return instance;
        }
    }

    // 2. Lazy Initialization
    public static class LazySingletonDbConnection {
        // This instance is created only when it is requested for the first time.
        private static LazySingletonDbConnection instance;

        // Private constructor to prevent the creation of additional instances from outside the class.
        private LazySingletonDbConnection() {}

        // Public method to provide access to the instance.
        // If the instance is null (i.e., not created yet), it will create the instance.
        // If already created, it will return the same instance.
        public static LazySingletonDbConnection getInstance() {
            if (instance == null) {
                instance = new LazySingletonDbConnection();  // Lazy initialization occurs here.
            }
            return instance;
        }
    }

    // 3. Thread-Safe Singleton (Synchronized Method)
    public static class SynchronizedSingletonDbConnection {
        // The instance is initialized only when needed.
        // The `static` keyword ensures that this variable is shared across all instances.
        private static SynchronizedSingletonDbConnection instance;

        // Private constructor to prevent instantiation from outside.
        private SynchronizedSingletonDbConnection() {}

        // This method is synchronized, meaning that only one thread can access it at a time.
        // This ensures thread safety when multiple threads try to create the singleton instance simultaneously.
        public static synchronized SynchronizedSingletonDbConnection getInstance() {
            // If the instance is null, it creates a new one; otherwise, it returns the existing one.
            if (instance == null) {
                instance = new SynchronizedSingletonDbConnection();
            }
            return instance;
        }
    }

    // 4. Double-Check Locking Singleton
    public static class DoubleCheckLockSingletonDbConnection {
        // The instance is declared volatile to ensure that changes to the instance are visible to all threads.
        // This helps in avoiding any memory inconsistency errors.
        private static volatile DoubleCheckLockSingletonDbConnection instance;

        // Private constructor to prevent instantiation from outside.
        private DoubleCheckLockSingletonDbConnection() {}

        // This method uses double-checked locking to minimize synchronization overhead.
        public static DoubleCheckLockSingletonDbConnection getInstance() {
            // First check without locking: This is done to avoid unnecessary locking once the instance is created.
            if (instance == null) {
                // Synchronize only the block of code that actually creates the instance.
                // This ensures thread safety.
                synchronized (DoubleCheckLockSingletonDbConnection.class) {
                    // Second check with locking: Double-check to avoid creating multiple instances.
                    if (instance == null) {
                        instance = new DoubleCheckLockSingletonDbConnection();
                    }
                }
            }
            return instance;  // Returns the singleton instance.
        }
    }

    // 5. Bill Pugh Singleton (Best Practice)
    public static class BillPughSingletonDbConnection {
        // Private constructor to prevent instantiation from outside the class.
        private BillPughSingletonDbConnection() {}

        // Static inner helper class that holds the instance of the singleton.
        // The class is loaded only when it's accessed for the first time.
        private static class SingletonHelper {
            // The static final instance of BillPughSingleton is created when this class is loaded.
            private static final BillPughSingletonDbConnection INSTANCE = new BillPughSingletonDbConnection();
        }

        // Public method to provide access to the instance.
        // This will trigger the loading of the `SingletonHelper` class and create the instance.
        public static BillPughSingletonDbConnection getInstance() {
            return SingletonHelper.INSTANCE;
        }
    }

    // 6. Enum Singleton (Thread-safe and Simple)
    public enum EnumSingletonDbConnection {
        // The single instance of the Enum Singleton.
        INSTANCE;

        // Example method to show that you can define methods inside the enum singleton.
        public void someMethod() {
            System.out.println("Enum Singleton method called");
        }
    }

    // Main method to test all Singleton implementations.
    public static void main(String[] args) {
        // Testing Eager Initialization Singleton.
        // Both instances should point to the same object since only one instance is created.
        EagerSingletonDbConnection eagerSingleton1 = EagerSingletonDbConnection.getInstance();
        EagerSingletonDbConnection eagerSingleton2 = EagerSingletonDbConnection.getInstance();
        // Verifying that both references point to the same instance.
        System.out.println("Eager Singleton: " + (eagerSingleton1 == eagerSingleton2));  // true

        // Testing Lazy Initialization Singleton.
        LazySingletonDbConnection lazySingleton1 = LazySingletonDbConnection.getInstance();
        LazySingletonDbConnection lazySingleton2 = LazySingletonDbConnection.getInstance();
        // Verifying that both references point to the same instance.
        System.out.println("Lazy Singleton: " + (lazySingleton1 == lazySingleton2));  // true

        // Testing Synchronized Singleton (Thread-safe Lazy Initialization).
        SynchronizedSingletonDbConnection syncSingleton1 = SynchronizedSingletonDbConnection.getInstance();
        SynchronizedSingletonDbConnection syncSingleton2 = SynchronizedSingletonDbConnection.getInstance();
        // Verifying that both references point to the same instance.
        System.out.println("Synchronized Singleton: " + (syncSingleton1 == syncSingleton2));  // true

        // Testing Double-Check Locking Singleton.
        DoubleCheckLockSingletonDbConnection doubleCheck1 = DoubleCheckLockSingletonDbConnection.getInstance();
        DoubleCheckLockSingletonDbConnection doubleCheck2 = DoubleCheckLockSingletonDbConnection.getInstance();
        // Verifying that both references point to the same instance.
        System.out.println("Double Check Locking Singleton: " + (doubleCheck1 == doubleCheck2));  // true

        // Testing Bill Pugh Singleton.
        BillPughSingletonDbConnection billPugh1 = BillPughSingletonDbConnection.getInstance();
        BillPughSingletonDbConnection billPugh2 = BillPughSingletonDbConnection.getInstance();
        // Verifying that both references point to the same instance.
        System.out.println("Bill Pugh Singleton: " + (billPugh1 == billPugh2));  // true

        // Testing Enum Singleton.
        EnumSingletonDbConnection enumSingleton1 = EnumSingletonDbConnection.INSTANCE;
        EnumSingletonDbConnection enumSingleton2 = EnumSingletonDbConnection.INSTANCE;
        // Verifying that both references point to the same instance.
        System.out.println("Enum Singleton: " + (enumSingleton1 == enumSingleton2));  // true

        // Calling a method in the Enum Singleton.
        enumSingleton1.someMethod();  // Output: Enum Singleton method called
    }
}

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * A Singleton Class is a class that allows only one instance (object) to be created during the entire execution of a 
 * program.
 * Explanation of Each Approach:
 * 
 * Eager Initialization: The singleton instance is created at the time of class loading. Simple but can lead to resource 
 * wastage if the instance is never used.
 * 
 * Lazy Initialization: The instance is created only when it is required for the first time. Not thread-safe by default but 
 * avoids early instantiation.
 * 
 * Thread-Safe Singleton (Synchronized Method): Ensures that only one thread can access the method at a time, making it 
 * thread-safe. Slower performance due to method synchronization.
 * 
 * Double-Check Locking: Optimizes thread-safety by reducing the overhead of synchronized methods. Ensures that the instance 
 * is created only once in a multithreaded environment with better performance.
 * 
 * Bill Pugh Singleton: Uses a static inner helper class to hold the instance. Lazy-loaded and thread-safe without needing 
 * synchronization. This is considered the best approach.
 * 
 * Enum Singleton: Simplest way to implement a Singleton. Provides built-in serialization, thread-safety, and protection 
 * against reflection.
 * 
 * Key Points:
 * All approaches are valid depending on your needs.
 * Eager Initialization is good for simple use cases where resources aren’t a concern.
 * Lazy Initialization is better when you want to create the instance only when needed.
 * Synchronized and Double-Check Locking provide thread safety in multithreaded environments.
 * Bill Pugh and Enum Singleton are the most effective and recommended implementations due to their simplicity, thread-safety, and resource management.
 */
