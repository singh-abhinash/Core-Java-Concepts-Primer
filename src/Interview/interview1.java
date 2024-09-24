package Interview;

class Car {
	private int fuel;
	private int fuelUsed;
	
	public void setFuel(int x, int y) {
		this.fuel = x;
		this.fuelUsed = y;
	}
	
	public int getFuel() {
		return fuel - fuelUsed;
	}
	
	public void drive() {
		if (fuel > 0) {
			System.out.println("fuel is available -> " + getFuel());
			fuel = fuel - fuelUsed;
		} else {
			System.out.println("fuel is not available");
		}
	}
}

public class interview1 {

	public static void main(String[] args) {
		StringBuilder s = new StringBuilder("Abhinash");

        // You can now use StringBuilder methods on 's'
        s.append(" Kumar");
        System.out.println(s.toString());  // Output: Abhinash Kumar
        System.out.println(s);  // Output: Abhinash Kumar
		// TODO Auto-generated method stub
		Car mycar = new Car();
		mycar.setFuel(5, 2);
		mycar.drive();
		mycar.drive();
		mycar.getFuel();
	}

}
