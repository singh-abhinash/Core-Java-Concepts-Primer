package BasicFundamentals;

public class BoilerPlateCode {

}

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * Java Class with Getters, Setters, and Constructors
 * For a simple Java class with private fields, you often need to write a constructor, getters, and setters.


public class Person {
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // toString method
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
In recent years, Lombok has helped reduce this boilerplate by generating constructors, getters, setters, and toString
 methods with annotations like @Data, @Getter, @Setter, and @AllArgsConstructor.
 */