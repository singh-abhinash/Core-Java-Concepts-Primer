package Interview;

class Vehicles {
	private int vehicleType;
	private int wheels;
	
	public Vehicles() {
		this.vehicleType = 2;
		this.wheels = 3;
		System.out.println(vehicleType + wheels);
	}
	
	public Vehicles(int vehicleType, int wheels) {
		this.vehicleType = vehicleType;
		this.wheels = wheels;
		System.out.println(vehicleType + wheels);
	}
	//concrete method
	public int getBoth() {
		return vehicleType + wheels;
	}
}
public class interview3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicles obj = new Vehicles();
		System.out.println("Sum is -> " + obj.getBoth());
		Vehicles obj1 = new Vehicles(3, 4);
		System.out.println("Sum is -> " + obj1.getBoth());
		
	}

}
