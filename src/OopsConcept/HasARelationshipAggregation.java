package OopsConcept;

class Address {
	/*private String city;
	private String state;*/
	//above two statement is wrong, just comment and see
	public String city;
	public String state;
	
	public Address (String city, String state) {
		this.city = city;
		this.state = state;
	}
}

class Persons {
	private String name;
	private int age;
	private Address address;
	
	public Persons(String name, int age, Address address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	public void display() {
		System.out.println("name is -> "+ name);
		System.out.println("age is -> "+ age);
		System.out.println("city is -> "+ address.city);
		System.out.println("age is -> "+ address.state);
	}
}

public class HasARelationshipAggregation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Address newAddress = new Address("Dhanbad", "Jharkhand");
		Persons man = new Persons("Abhi", 25, newAddress);
		man.display();
		
	}

}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*
Has-a Relationship:
The "has-a" relationship represents composition or aggregation and is a way to model 
relationships where one class contains or is composed "OBJECT" of another class. It is characterized 
by using instance variables that reference other objects.

Aggregation:
-> Aggregation implies a weaker relationship where the contained object can exist independently 
of the container object.
-> Aggregation: Weaker relationship, the part can exist independently. Example: Person has an 
Address.

-> Represented by composition or aggregation.
-> Models a whole-part relationship.
-> Composition: Strong relationship, the part cannot exist without the whole. Example: Car has an 
Engine.
 */
