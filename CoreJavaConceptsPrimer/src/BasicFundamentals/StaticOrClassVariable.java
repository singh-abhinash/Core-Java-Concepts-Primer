package BasicFundamentals;

public class StaticOrClassVariable {
    // Static variable to keep track of the number of employees
    static int employeeCountStatic = 0;
    int workersCountNonStatic = 0;

    // Instance variables
    private String name;
    private int id;

    // Constructor
    public StaticOrClassVariable(String name, int id) {
        this.name = name;
        this.id = id;
        employeeCountStatic++;  // Increment the static variable whenever a new employee is created
        workersCountNonStatic++;
    }

    // Static method to get the number of employees
    public static int getEmployeeCount() {
        return employeeCountStatic;
    }
    
    public int getWorkersCount() {
        return workersCountNonStatic;
    }

    // Method to display employee details
    public void display() {
        System.out.println("Employee ID: " + id + ", Name: " + name);
    }

    public static void main(String[] args) {
        // Creating instances of Employee
    	StaticOrClassVariable emp1 = new StaticOrClassVariable("Alice", 101);
    	StaticOrClassVariable emp2 = new StaticOrClassVariable("Bob", 102);
    	StaticOrClassVariable emp3 = new StaticOrClassVariable("Charlie", 103);

        // Displaying employee details
        emp1.display();
        emp2.display();
        emp3.display();

        // Accessing the static variable using the class name
        System.out.println("Total number of employees: " + StaticOrClassVariable.getEmployeeCount());
        System.out.println("Total number of workers: " + emp1.getWorkersCount());
        System.out.println("Total number of workers: " + emp2.getWorkersCount());
        System.out.println("Total number of workers: " + emp3.getWorkersCount());
    }
}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++=
/*
 * Summary
Class-level scope: Static variables belong to the class.
Single copy: Only one copy exists for all instances.
Memory allocation: Allocated once when the class is loaded.
Direct access: Accessed using the class name not object
Initialization: Can be initialized during declaration, in static blocks, or by static methods.
Static context: Accessible directly in static methods and blocks.
Use cases: Commonly used for counters, constants, and shared resources.
Visibility: Follows regular access control rules.
Thread safety: Requires synchronization in multithreaded environments.
Class initialization: Executed when the class is loaded.
 */

