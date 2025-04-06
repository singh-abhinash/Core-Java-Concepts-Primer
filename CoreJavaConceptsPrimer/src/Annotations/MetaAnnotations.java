package Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;

/**Target annotation applied to methods:
 *The @Target annotation specifies the kinds of program elements to which an annotation type is applicable. 
 *You can use it to limit where your annotation can be applied, such as classes, methods, fields, etc.
 *@Target(ElementType.ANNOTATION_TYPE)
public @interface Target {
 *If you will click on target annotation then you will see we can apply @target annotation on 
 *ElementType.Annotation_Type it means we can use meta annotation on top of annotation only8- keep remember
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyMethodAnnotation {
    String value();
}

// Retention annotation indicating it is available at runtime
/*
 * The @Retention annotation indicates how long annotations with the annotated type are to be retained. The 
 * retention policy can be specified as:
 * 
 * *******Means how annotation will be stored in java
 * 
 * @Retention(RetentionPolicy.SOURCE): Annotations are discarded by the compiler. Means whatever
 * annotation we are using we can only see in SOURCE file not in CLASS file and also not able to see
 * during RUNTIME when JVM invoke.
 * 
 * @Retention(RetentionPolicy.CLASS): Annotations are recorded in the class file but ignored by the JVM. Means 
 * whatever annotation we are using we can see in SOURCE as well as in CLASS file but not able to see
 * during RUNTIME when JVM invoke.It means reflection is not possible because reflection happens at RUNTIME.
 * Don't allow reflection.
 * 
 * @Retention(RetentionPolicy.RUNTIME): Annotations are recorded in the class file and retained by the JVM at 
 * runtime, allowing reflection. Means whatever annotation we are using we can only see in SOURCE, in 
 * CLASS file also able to see during RUNTIME when JVM invoke. It means reflection is possible because 
 * reflection happens at RUNTIME.
 */
@Retention(RetentionPolicy.RUNTIME)
@interface MyRuntimeAnnotation {
    String description();
}

// Documented annotation to include in Javadoc
/*
 * The @Documented annotation indicates that whenever the annotated element is used, the annotation should be 
 * included in the Javadoc. This is useful for documenting the use of annotations in your API. Means whatever 
 * annotation we are using if we will put this annotation on the top of the another annotations then we are able 
 * to see those annotations in document.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@interface MyDocumentedAnnotation {
    String value();
}

// Inherited annotation to be inherited by subclasses
/*
 * The @Inherited annotation indicates that an annotation type is inherited from a superclass. If a class is 
 * annotated with an @Inherited annotation, its subclasses will also inherit this annotation.It means by default 
 * annotation applied on parent class cannot be applied on child class but after putting this annotation on parent 
 * class , whatever annotation will be applicable for parent class that will also be applicable for child class.
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@interface MyInheritedAnnotation {
    String value();
}

// Repeatable annotation example
/*
 * The @Repeatable annotation allows the same annotation type to be applied more than once to the same 
 * declaration. To use @Repeatable, you also need to define a containing annotation.
 */
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyRepeatableAnnotations.class)
@interface MyRepeatableAnnotation {
    String value();
}

// Container for the repeatable annotations
@Retention(RetentionPolicy.RUNTIME)
@interface MyRepeatableAnnotations {
    MyRepeatableAnnotation[] value();
}

// Applying the annotations in a single class
public class MetaAnnotations {

    @MyMethodAnnotation("Example Method")
    @MyRuntimeAnnotation(description = "This method demonstrates runtime annotation.")
    @MyDocumentedAnnotation("This is a documented annotation.")
    public void myMethod() {
        System.out.println("My method is called.");
        System.out.println("+++++++++++++++++++++++++++++++++++++");
    }

    @MyInheritedAnnotation("Base Class")
    public static class Base {}

    public static class Derived extends Base {} // Inherits MyInheritedAnnotation

    @MyRepeatableAnnotation("First")
    @MyRepeatableAnnotation("Second")
    public void myRepeatableMethod() {
        System.out.println("My repeatable method is called.");
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
    }

    public static void main(String[] args) {
    	MetaAnnotations example = new MetaAnnotations();
        example.myMethod();
        example.myRepeatableMethod();
        
        // Checking for inherited annotation
        if (Derived.class.isAnnotationPresent(MyInheritedAnnotation.class)) {
            MyInheritedAnnotation annotation = Derived.class.getAnnotation(MyInheritedAnnotation.class);
            System.out.println("Inherited Annotation Value: " + annotation.value());
            System.out.println("+++++++++++++++++++++++++++++++++++++++++");
        }
    }
}
