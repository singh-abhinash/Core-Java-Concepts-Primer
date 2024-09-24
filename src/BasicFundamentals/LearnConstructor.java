//***CONSTRUCTOR CHAINING*****
//*********this*********
package BasicFundamentals;

public class LearnConstructor {
	String name;
	int empId;

	LearnConstructor() {
		this("Abhinash");
	}
	
	LearnConstructor(String name) {
		this(name, 10);
	}
	
	LearnConstructor(String name, int empId) {
		this.name = name;
		this.empId = empId;
	}
	
	void display() {
		System.out.println("name -> "+ name + ", empid -> "+ empId);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LearnConstructor obj1 = new LearnConstructor();//default constructor
		obj1.display();
		LearnConstructor obj2 = new LearnConstructor("Anup");//parameterized constructor with one argument
		obj2.display();
		LearnConstructor obj3 = new LearnConstructor("Abhi", 3);//parameterized constructor with two argument
		obj3.display();
		
	}

}
