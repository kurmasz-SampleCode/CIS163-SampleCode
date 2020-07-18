
package gvsucis.referenceExamples;

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

	public static int subtract(int a, int b) {
		return a - b;
	}

	public static int multiply(int c, int d) {
		c = c * d;
		return c;
	}

	public static void main(String[] args) {

		// Notice that un-commenting the following two lines is a syntax error:
		// You can reference a variable that has never been given any value at all.
		 // int tooSoon;
		 // System.out.println("The value of tooSoon is: " + tooSoon);

		int q = 10;
		int r = 9;
		System.out.printf("q - r is %d\n", subtract(q, r));
		System.out.printf("r - q is %d\n", subtract(r, q));

		// Remember, parameters are passed by position,
		// even if the formal and actual parameters have the same names
		int a = 10;
		int b = 9;
		System.out.printf("a - b is %d\n", subtract(a, b));
		System.out.printf("b - a is %d\n", subtract(b, a));

		int y = 14;
		System.out.println("The value of y in main is " + y);
		method1(y);
		System.out.println("The value of y in main after method 1 is " + y);
		method2(y);
		System.out.println("The value of y in main after method 2 is " + y);
	}
}
