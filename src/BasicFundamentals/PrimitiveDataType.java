package BasicFundamentals;

public class PrimitiveDataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte byteVar = 100;
		//byte byteVar1 = 129 -> this wrong due to range of byte. see below, how to write
		byte byteVar1 = (byte)129;//please think about its output(range: -128 to 127)
        short shortVar = 10000;
        int intVar = 100000;
        long longVar = 1234456l;
        float floatVar = 10.5f;
        double doubleVar = 20.99d;
        char charVar = 'A';
        boolean booleanVar = true;

        System.out.println("byteVar: " + byteVar);
        System.out.println("byteVar1: " + byteVar1);
        System.out.println("shortVar: " + shortVar);
        System.out.println("intVar: " + intVar);
        System.out.println("longVar: " + longVar);
        System.out.println("floatVar: " + floatVar);
        System.out.println("doubleVar: " + doubleVar);
        System.out.println("charVar: " + charVar);
        System.out.println("booleanVar: " + booleanVar);
	}

}
