package BasicFundamentals;

public class LombokJavaLibrary {

}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * Lombok is a Java library that helps reduce boilerplate code by automatically generating common code structures like getters, setters, constructors, equals, hashCode, and toString methods through simple annotations. It saves time and makes the code cleaner and more readable.

Here's a quick overview of Lombok's main features and commonly used annotations:

Key Lombok Annotations
@Getter and @Setter

Generates getter and setter methods for each field in a class.
You can add them at the class level to generate getters and setters for all fields, or at the field level for specific fields.

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Person {
    private String name;
    private int age;
}
@ToString

Generates a toString method for the class, which includes all fields by default.

import lombok.ToString;
@ToString
public class Person {
    private String name;
    private int age;
}

@EqualsAndHashCode
Generates equals and hashCode methods for the class, based on the fields.

import lombok.EqualsAndHashCode;
@EqualsAndHashCode
public class Person {
    private String name;
    private int age;
}

@NoArgsConstructor, @AllArgsConstructor, @RequiredArgsConstructor
@NoArgsConstructor generates a no-argument constructor.
@AllArgsConstructor generates a constructor with one parameter for each field.
@RequiredArgsConstructor generates a constructor for final fields or fields marked with @NonNull.

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String name;
    private int age;
}

@Data
Combines @Getter, @Setter, @ToString, @EqualsAndHashCode, and @RequiredArgsConstructor.
Often used for data classes where you want all the basic boilerplate.

import lombok.Data;
@Data
public class Person {
    private String name;
    private int age;
}

@Builder
Enables the Builder Pattern, allowing you to build objects in a more readable way.
Automatically generates a Builder inner class with methods for each field.

import lombok.Builder;
@Builder
public class Person {
    private String name;
    private int age;
}

// Usage
Person person = Person.builder()
                      .name("Alice")
                      .age(30)
                      .build();
@Value
Used to create immutable classes. It makes all fields private and final by default, generates a constructor for all 
fields, and adds @ToString, @EqualsAndHashCode, and getters for all fields.

import lombok.Value;
@Value
public class Person {
    private String name;
    private int age;
}


How to Use Lombok
Add Lombok to Your Project

In Maven:
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.26</version> <!-- Use the latest version -->
    <scope>provided</scope>
</dependency>


In Gradle:
compileOnly 'org.projectlombok:lombok:1.18.26'
annotationProcessor 'org.projectlombok:lombok:1.18.26'
Enable Annotation Processing in Your IDE

In IntelliJ IDEA: Go to File > Settings > Build, Execution, Deployment > Compiler > Annotation Processors, and check "Enable annotation processing."
In Eclipse: Annotation processing is typically enabled by default.
Benefits of Using Lombok
Less Boilerplate Code: Reduces the amount of repetitive code you need to write, making the codebase cleaner and more readable.
Readability: Focus on the core logic without being distracted by boilerplate methods.
Standardization: Provides a standardized way of generating methods like getters, setters, toString, etc.
Example of a Full Lombok Class

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {
    private String name;
    private int age;
}

// Usage
Person person = Person.builder().name("John").age(25).build();
System.out.println(person); // Person(name=John, age=25)
Using Lombok can help make your code shorter and more maintainable, especially in projects with many data-centric classes.
 */
