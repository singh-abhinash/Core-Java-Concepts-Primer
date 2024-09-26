package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {

	public static void main(String[] args) {
		try {
			
			// 1. Obtain the Class object for NewPerson
			//we can obtain class object from three ways:
			
			//Using forName method
			Class personClass1 = Class.forName("Reflection.NewPerson");
			
			//Using .class with the name of the class
			/*
			 Make sure that the class name you are passing to Class.forName() is exactly the same as the actual 
			 class name, including the package (if any).

			For example, if your class is in a package like com.example, you should use:
			Class<?> personClass = Class.forName("com.example.NewPerson");
			*/
			Class personClass = Reflection.NewPerson.class;
			
			//using get class with the obj of the class
			NewPerson personObj = new NewPerson();
			Class personClass2 = personObj.getClass();
			
			//Get all constructor of the class
			Constructor[] constructors = personClass2.getDeclaredConstructors();
			System.out.println("Constructors are : ");
			for (Constructor constructor : constructors) {
				System.out.println(constructor);
			}
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			
			// 3. Get the private argument constructor
			//Note: below statement will throw error because parameterized constructor is private constructor and 
			//and we can't access directly outside the class so we have to make it accessible first then we can access.
			//Constructor privateConstructor = personClass.getDeclaredConstructor("Abhinas", 27);
			Constructor privateConstructor = personClass.getDeclaredConstructor(String.class, int.class);
			
			//making private constructor accessible so that it will not throw error like below 59 to 66
			// 4. Make the private constructor accessible
			privateConstructor.setAccessible(true);
			
			// 4. Create an instance of NewPerson using the private argument constructor
			Object privateConstructorObj = privateConstructor.newInstance("Abhinash", 27);
			
			Method getNameMethod = personClass.getMethod("getName");
            Method getAgeMethod = personClass.getMethod("getAge");
			
			System.out.println("private constructor:");
			System.out.println("Name: " + getNameMethod.invoke(privateConstructorObj));
			System.out.println("Age: " + getAgeMethod.invoke(privateConstructorObj));
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++==");
			
			
			Object personClassObj = personClass.newInstance();
			
			// 5. Access the default constructor methods
			/*
			 * : Reflection.NewPerson.setName()
	at java.lang.Class.getMethod(Class.java:1786)
	at Reflection.Main.main(Main.java:53)
	below two statement will throw error because we are not passing argument
			 
            Method getNameMethod = personClass.getMethod("setName");
            Method getAgeMethod = personClass.getMethod("setAge");
            */
			
			Method setNameMethod = personClass.getMethod("setName", String.class);
            Method setAgeMethod = personClass.getMethod("setAge", int.class);
			
            setNameMethod.invoke(personClassObj, "Anup");
            setAgeMethod.invoke(personClassObj, 22);
			// 6. Access the methods and print the result from the private constructor instance
			System.out.println("getName and getAge:");
			System.out.println("Name: " + getNameMethod.invoke(personClassObj));
			System.out.println("Age: " + getAgeMethod.invoke(personClassObj));
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			/*
			 * below error we will get when we will try to access private constructor of another class without
			 * setting it accessible. so first we need to set accessible (error due to statement 6)
			 * : Class Reflection.Main can not access a member of class Reflection.NewPerson with modifiers "private"
	at sun.reflect.Reflection.ensureMemberAccess(Reflection.java:102)
	at java.lang.reflect.AccessibleObject.slowCheckMemberAccess(AccessibleObject.java:296)
	at java.lang.reflect.AccessibleObject.checkAccess(AccessibleObject.java:288)
	at java.lang.reflect.Constructor.newInstance(Constructor.java:413)
	at Reflection.Main.main(Main.java:46)
		TO GET RID OF THIS MESSAGE WE WILL MAKE CONSTRUCTOR AS ACCESSIBLE 
			 */
			Field[] fields = personClass.getDeclaredFields();
			for (Field field : fields) {
				System.out.println("field name : " + field.getName());
				System.out.println("field type : " + field.getType());
				/*
				 * The difference between field.getModifiers() and Modifier.toString(field.getModifiers()) lies 
				 * in what they return and how they represent the field's modifiers:
				field.getModifiers():

				This method returns an "int" representing the modifiers of the field (like public, private, static, etc.)
				as a bitmask.
				The bitmask is a combination of constants defined in the java.lang.reflect.Modifier class, and each 
				bit in the integer represents a specific modifier.
				The value returned is an integer that may not be easily readable to humans.
				 */
				System.out.println("field modifier name : " + field.getModifiers());
				/*
				 * Modifier.toString(field.getModifiers()):
				This method takes the integer bitmask returned by field.getModifiers() and converts it into a 
				human-readable string representation of the modifiers.
				It breaks down the bitmask and converts the corresponding modifier flags into their string names 
				(e.g., "public", "private", "static", etc.).
				 */
				System.out.println("field modifier name : " + Modifier.toString(field.getModifiers()));
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*
=> this class  Class is invoked by JVM at runtime
Que => What is Reflection in Java?
Ans => Reflection in Java is a powerful feature that allows a program to inspect and manipulate the properties and 
behavior of objects at runtime. With reflection, you can analyze or modify the classes, methods, fields, and 
constructors of loaded classes, even if you don't know their names or types at compile time. 
It is part of the java.lang.reflect package.

Reflection is typically used in scenarios where dynamic behavior is required, such as in frameworks, libraries, 
and tools like IDEs, testing frameworks (JUnit), dependency injection frameworks (Spring), and object 
serialization/deserialization libraries (Jackson, Gson).

=> In Java, making a constructor private restricts the instantiation of the class from outside of that class. 
However, through reflection, it is possible to invoke a private constructor and create an instance of the class.

=> Key Classes and Methods in Java Reflection
1) Class: Represents classes and interfaces in Java.
2) Field: Represents a field (member variable).
3) Method: Represents a method of a class.
4) Constructor: Represents a constructor of a class.

=> Common Use Cases for Reflection:
1) Dynamic instantiation of classes.
2) Inspecting or modifying fields and methods of a class at runtime.
3) Bypassing access control (e.g., accessing private methods/fields).
4) Creating object instances dynamically based on class names at runtime.
5) Analyzing annotations on classes, methods, and fields.

=> Disadvantage of using Reflection
 1) It breaks encapsulation principle
 2) It breaks singleton approach
 */