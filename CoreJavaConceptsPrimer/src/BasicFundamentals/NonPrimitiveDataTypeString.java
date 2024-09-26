package BasicFundamentals;

public class NonPrimitiveDataTypeString {
	public static void inWhichPackageClassMethod() {
		System.out.println("I am in BasicFundamentals package, NonPrimitiveDataTypeString class, inWhichPackageClassMethod method");
	}
	//immutable means, new string literals will not create if the string literals name is same (like ""Abhinash") for s1 and s4 objectes. 
	//It means both s1 and s4 object will point to same string literals
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Abhinash";
		String s2 = "Anup";
		String s3 = new String("Abhinash");
		String s4 = "Abhinash";
		
		System.out.println(s1 == s2);//output - false
		System.out.println(s1.equals(s2));//output - false
		
		System.out.println(s1 == s4);//output - true
		System.out.println(s1.equals(s4));//output - true
		
		System.out.println(s2 == s4);//output - false
		System.out.println(s2.equals(s4));//output - false
		
		System.out.println(s1 == s3);//output - false
		System.out.println(s1.equals(s3));//output - true
		//for more clearance see word document
		System.out.println("I am in main class");
		inWhichPackageClassMethod();
	}

}
