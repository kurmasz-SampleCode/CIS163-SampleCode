/********************************************************************************
 * This class simply shows that changes to primitive data inside methods do not
 * persist outside the method.
 *******************************************************************************/

public class Primitive {

	public static void method1(int x) {
		System.out.printf("\tx = %d when entering method1.\n", x);
		x = x + 1;
		System.out.printf("\tx = %d when leaving method1.\n", x);
		return;
	}

	public static void method2(int y) {
		System.out.printf("\ty = %d when entering method2.\n", y);
		y = y + 1;
		System.out.printf("\ty = %d when leaving method2.\n", y);
		return;
	}

	public static void main(String[] args) {
		int y = 14;
		System.out.println("The value of y in main is " + y);
		method1(y);
		System.out.println("The value of y in main after method 1 is " + y);
		method2(y);
		System.out.println("The value of y in main after method 2 is " + y);
	}

}
