import java.util.Arrays;
import java.util.*;

public class MyInteger {

	public static void main(String[] args) {
		MyInteger val1 = new MyInteger(20);
		String mystring = new String("Hello");
		char[] mychar = new char[]{'1','2','3'};
	
		if(val1.isEven()) {
			System.out.printf("The number %d is even! \n", val1.getValue(), val1.isEven());
		}
		if(val1.isOdd()) {
			System.out.printf("The number %d is odd! \n",  val1.getValue(), val1.isOdd());
		}
		if(val1.isPrime()) {
			System.out.printf("The number %d is prime! \n", val1.getValue(), val1.isPrime());
		}
		System.out.println(parseInt(mystring));
		for(int i = 0; i < mychar.length; i++) {
			System.out.print(Character.toString(mychar[i]));
		}
	}
	private int value;

	public MyInteger(int number) {
		value = number;
	}
	public int getValue() {
		return value;
	}
	public boolean isEven() {
		if(value % 2 == 0) {
			return true;
		}
		return false;
	}
	public boolean isOdd() {
		return !isEven();
	}
	public boolean isPrime() {
		for(int i = 2; i < value / 2; i++) {
			if(value % i == 0) {
				return false;
			}
		}
		return true;
	}
	public static boolean isEven(int number) {
		if(number % 2 == 0) {
			return true;
		}
		return false;	
	}
	public static boolean isOdd(int number) {
		if(!isEven(number)) {
			return true;
		}
		return false;
	}
	public static boolean isPrime(int number) {
		for(int i = 2; i < number / 2; i++) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}
	public static boolean isEven(MyInteger myint) {
		return isEven(myint.getValue()); 
	}
	public static boolean isOdd(MyInteger myint) {
		return !isEven(myint);
	}
	public static boolean isPrime(MyInteger myint) {
		return isPrime(myint);
	}
	public boolean equals(int number) {
		if(this.value == number) {
			return true;
		}
		return false;
	}
	public boolean equals(MyInteger myint) {
		if(this.value == myint.getValue()) {
			return true;
		}
		return false;
	}
	public static int parseInt(char[] number) {
		int result = 0;
		for(int i = 0; i <= number.length; i++) {
			result = result * 10 + (number[i] - '0');
		}
		return result;
	}
	public static int parseInt(String number) {
		int result = 0;
		for(int i = 0; i < number.length(); i++) {
			result = result * 10 + (number.charAt(i) - '0');
		}
		return result;
	}
}
