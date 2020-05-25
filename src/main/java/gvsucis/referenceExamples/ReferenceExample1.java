
package gvsucis.referenceExamples;

class ReferenceExample1 {

	// Demonstrates that object variables contain references, not objects.
	public static void nullPointer() {
		Point2D point1;

		// The line below is illegal, point1 has no value. Not even
		// null
		// System.out.println(point1);

		point1 = null;
		System.out.println("   The current value of point1 is: " + point1 + "\n");

		// The line below will cause a Null pointer exception
		// System.out.println("The object point1 \"refers to\" has this data:" +
		// point1.toString2());

		// Now, let's actually create a Point2D object
		point1 = new Point2D(1.0, 2.0);
		System.out.println("   The value of point1 is " + point1);

		System.out.println("   The object point1 \"refers to\" has this data: " + point1.toString2());
	}

	public static void assignRefs() {

		Point2D point1 = new Point2D(1.0, 2.0);
		Point2D point2 = new Point2D(2.0, 5.0);
		Point2D point3;

		System.out.println("   The current value of point1 is: " + point1);
		System.out.println("   The current value of point2 is: " + point2);
		System.out.println("   point1 contains: " + point1.toString2());
		System.out.println("   point2 contains: " + point2.toString2());

		point3 = point1;
		System.out.println("   The current value of point3 is: " + point3);
		System.out.println("   point3 contains: " + point3.toString2());

		point3.setX(50.0);
		System.out.println("   point3 now contains: " + point3.toString2());
		System.out.println("   point1 now contains: " + point1.toString2());
	}

	public static void method1(Point2D pPoint) {
		System.out.println("   Entering method1");
		System.out.println("      The current value of pPoint is: " + pPoint + ".");
		System.out.println("      The object pPoint \"refers to\" has this data: " + pPoint.toString2());

		pPoint.setXY(20.0, 40.0);
		System.out.println("      The new value of pPoint is: " + pPoint + ".");
		System.out.println("      The object pPoint \"refers to\"  now has this data: " + pPoint.toString2());
		System.out.println("   Leaving method 1.");
	}

	// Demonstrates that methods can modify objects.
	public static void refsAsParams() {

		Point2D point1 = new Point2D(10.0, 12.0);

		System.out.println("   The current value of point1 is: " + point1 + ".");
		System.out.println("   The object point1 \"refers to\" has this data: " + point1.toString2());
		method1(point1);
		System.out.println("   After calling method1, the value of point1 is: " + point1 + ".");
		System.out
				.println("   After calling method1, point1 \"refers to\" " + "an object with this data: " + point1.toString2());
	}

	public static void method2(Point2D pPoint) {
		System.out.println("\n\tThe current value of pPoint is: " + pPoint + ".");
		System.out.println("\tThe object pPoint \"refers to\" has this data: " + pPoint.toString2());

		pPoint = new Point2D(40.0, 60.0);
		System.out.println("\n\tThe new value of pPoint is: " + pPoint + ".");
		System.out.println("\tThe object pPoint \"refers to\"  now has this data: " + pPoint.toString2());
	}

	// Demonstrate that methods can't modify references.
	public static void refsAsParams2() {

		Point2D point1 = new Point2D(10.0, 12.0);

		System.out.println("The current value of point1 is: " + point1 + ".");
		System.out.println("The object point1 \"refers to\" has this data: " + point1.toString2());
		method2(point1);
		System.out.println("\nAfter calling method2, the value of point1 is: " + point1 + ".");
		System.out
				.println("After calling method2,  point1 \"refers to\" " + "an object with this data: " + point1.toString2());
	}

	// Demonstrates the difference between == and .equals
	public static void compareRefs() {

		// Now, let's make two Point2D objects with identical instance
		// data.
		Point2D point1 = new Point2D(1.0, 2.0);
		Point2D point2 = new Point2D(1.0, 2.0);

		System.out.println("   The value of point1 is: " + point1);
		System.out.println("   The value of point2 is: " + point2);

		System.out.println("   The object point1 \"refers to\" has this data: " + point1.toString2());
		System.out.println("   The object point2 \"refers to\" has this data: " + point2.toString2());

		// Notice that, although point1 and point2 have identical
		// instance data, they are not the same object.
		if (point1 == point2) {
			System.out.println("   point1 and point2 are the same object");
		} else {
			System.out.println("   point1 and point2 are NOT the same object");
		}

		// However, we can use the equals method to see if they have
		// the same data:
		if (point1.equals(point2)) {
			System.out.println("   point1 and point2 have identical instance data");
		} else {
			System.out.println("   point1 and point2 have different instance data");
		}

	} // end compareRefs

	// Demonstrates that String literals all share the same underlying object
	// Thus == may not always exhibit the expected behavior
	public static void compareStringRefs() {
		// The same thing applies to strings:
		String string1 = "Sam"; // new String("I am a string");
		String string2 = "Sam"; //		new String("I am a string");

		if (string1 == string2) {
			System.out.println("   string1 and string2 are the same object");
		} else {
			System.out.println("   string1 and string2 are NOT the " + "same object");
		}

		// However, we can use the equals method to see if they have
		// the same data:
		if (string1.equals(string2)) {
			System.out.println("   string1 and string2 have identical instance data");
		} else {
			System.out.println("   string1 and string2 have different instance data");
		}

		// As an experiment, replace the first two lines of this
		// method with these lines:
		//
		// String string1 = new String("I am a string literal");
		// String string2 = new String("I am a string literal");
		//
		// You will see that if you incorrectly use == to compare
		// strings, you may not see the error right away!

	} // end compareStringRefs

	public static boolean isItSam(String name) {
		return name == "Sam";
	}

	public static void compareStringRefs2(String externalName) {

		// This works as expected
		if (isItSam("Fred")) {
			System.out.println("\t\"Fred\" is \"Sam\".");
		} else {
			System.out.println("\t\"Fred\" is not \"Sam\".");
		}

		// This also works as expected
		if (isItSam("Sam")) {
			System.out.println("\t\"Sam\" is \"Sam\".");
		} else {
			System.out.println("\t\"Sam\" is not \"Sam\".");
		}

		// This does *not* work as expected
		if (isItSam(externalName)) {
			System.out.printf("\t\"%s\" is \"Sam\".\n", externalName);
		} else {
			System.out.printf("\t\"%s\" is not \"Sam\".\n", externalName);
		}
	}

	public static void copyObject() {
		Point2D point1 = new Point2D(3.0, 4.0);

		// Point2 is a copy of point1: A separate object with the
		// same data. (Remember, you are responsible for providing the copy
		// constructor.)
		Point2D point2 = new Point2D(point1);

		System.out.println("The value of point1 is: " + point1);
		System.out.println("The value of point2 is: " + point2);

		System.out.println("The object point1 \"refers to\" has this data: " + point1.toString2());
		System.out.println("The object point2 \"refers to\" has this data: " + point2.toString2());

		// Notice that, although point1 and point2 have identical
		// instance data, they are not the same object.
		if (point1 == point2) {
			System.out.println("point1 and point2 are the same object");
		} else {
			System.out.println("point1 and point2 are NOT the same object");
		}

		// However, we can use the equals method to see if they have
		// the same data:
		if (point1.equals(point2)) {
			System.out.println("point1 and point2 have identical " + "instance data");
		} else {
			System.out.println("point1 and point2 have different " + "instance data");
		}

		System.out.println("\n\nNow calling setXY(5.0, 6.0) on point1: ");
		point1.setXY(5.0, 6.0);
		System.out.println("The new value of point1 is: " + point1);
		System.out.println("The  value of point2 is: " + point2);

		System.out.println("The object point1 \"refers to\" has this data: " + point1.toString2());
		System.out.println("The object point2 \"refers to\" has this data: " + point2.toString2());
		System.out.println("Changing point1 did NOT change point 2");

	} // end

	public static void main(String args[]) {

		final int exampleToRun = 7;

		switch (exampleToRun) {
			case 1:
				System.out.println("Case 1: Null pointers.");
				nullPointer();
				break;

			case 2:
				System.out.println("Case 2: Assigning references.");
				assignRefs();
				break;

			case 3:
				System.out.println("Case 3: References as parameters.");
				refsAsParams();
				break;

			case 4:
				System.out.println("Case 4: References as parameters.");
				refsAsParams2();
				break;

			case 5:
				System.out.println("Case 5: Comparing refs");
				compareRefs();
				break;

			case 6:
				System.out.println("Case 6: Comparing String refs");
				compareStringRefs();
				break;

			case 7:
				System.out.println("Case 7: Comparing String refs using a helper method");
				java.util.Scanner scanner = new java.util.Scanner(System.in);
				System.out.println("Enter a name");
				String input = scanner.next();
				compareStringRefs2(input);
				break;

			case 8:
				System.out.println("Case 8: Copying objects.");
				copyObject();
				break;
		}
	}
}
