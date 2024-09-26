package Interview;

abstract class Vehicle {
	public abstract void start();
	public void stop() {
		System.out.println("bike stop");
	}
}

class Bike extends Vehicle {
	@Override
	public void start() {
		System.out.println("bike start");
	}
}

public class interview2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bike apache = new Bike();
		apache.start();
		apache.stop();
	}

}
