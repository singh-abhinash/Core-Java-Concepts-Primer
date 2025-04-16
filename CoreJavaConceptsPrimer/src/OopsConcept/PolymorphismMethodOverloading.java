package OopsConcept;

class Sum {
	
	public int add(int a, int b) {
		return a + b;
	}
	
	public int add(int a, int b, int c) {
		return a + b + c;
	}
	
	public String add(String a, String b) {
		return a + b;
	}
}

public class PolymorphismMethodOverloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Sum sum = new Sum(2, 3); -> this will throw error because we haven't defined constructor
		//for this we have to create object and then pass
		Sum obj = new Sum();
		System.out.println("Sum is -> " + obj.add(2, 3));
		System.out.println("Sum is -> " + obj.add(2, 3, 5));
		System.out.println("Sum is -> " + obj.add("Abhinash", "Singh"));
	}

}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*Key Points:
	
1) Method Signature: Each overloaded method has a unique signature, which consists of the 
method name and the parameter list. "The return type is not considered for method overloading".
2) The methods must have the same name but different parameters (different number or types of 
parameters).
3) Overloading is resolved at compile time.
4) It improves code readability and reusability.
5) Compile Time /Static Polymorphism /Method Overloading.
Question - what is meaning of Overloading is resolved at compile time????
Answer - When you write a method call in your code, the compiler analyzes the call to 
determine which method signature matches the arguments provided in the call. It will not see the
return type.
*/
