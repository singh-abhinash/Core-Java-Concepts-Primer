package OopsConcept;



public class HasARelationshipComposition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*
Has-a Relationship:
The "has-a" relationship represents composition or aggregation and is a way to model 
relationships where one class contains or is composed "OBJECT" of another class. It is characterized 
by using instance variables that reference other objects.

Composition:
-> Composition implies a strong ownership where the contained object does not exist 
independently of the container object.
-> Composition: Strong relationship, the part cannot exist without the whole. 
Example: Car has an Engine.
-> Composition work as a Encapsulation: The Engine is encapsulated within the Car class, meaning it is not 
exposed directly to the outside world but is instead managed internally by the Car.
-> In composition, one class contains a reference to another class and creates an instance 
of that class. This implies a strong ownership where the contained object (part) cannot exist 
independently of the containing object (whole).

Aggregation:
-> Aggregation implies a weaker relationship where the contained object can exist independently 
of the container object.
-> Aggregation: Weaker relationship, the part can exist independently. Example: Person has an 
Address.

-> Represented by composition or aggregation.
-> Models a whole-part relationship.
*/
