class ReferenceExample1
{

	// Demonstrates that object variables contain references, not objects.
	public static void refVsObject()
	{
		Point2D point1;

		// The line below is illegal, point1 has no value.  Not even
		// null
		// System.out.println(point1);

		point1 = null;
		System.out.println("The current value of point1 is: " + 
				point1 + "\n");

		// The line below will cause a Null pointer exception
		//System.out.println("The object point1 \"refers to\" has this data:" +
		//		   point1.toString2());


		// Now, let's actually create a Point2D object
		point1 = new Point2D(1.0, 2.0);
		System.out.println("The value of point1 is now: " + point1);

		System.out.println("The object point1 \"refers to\" has this data: " +
				point1.toString2());
	}

	
	// Demonstrates the difference between == and .equals
	public static void compareRefs()
	{

		// Now, let's make two Point2D objects with identical instance
		// data.
		Point2D point1 = new Point2D(1.0, 2.0);
		Point2D point2 = new Point2D(1.0, 2.0);

		System.out.println("The value of point1 is: " + point1);
		System.out.println("The value of point2 is: " + point2);

		System.out.println("The object point1 \"refers to\" has this data: " +
				point1.toString2());
		System.out.println("The object point2 \"refers to\" has this data: " +
				point2.toString2());


		// Notice that, although point1 and point2 have identical
		// instance data, they are not the same object.
		if (point1 == point2)
		{
			System.out.println("point1 and point2 are the same object");
		}
		else
		{
			System.out.println("point1 and point2 are NOT the same object");
		}

		// However, we can use the equals method to see if they have
		// the same data:
		if (point1.equals(point2))
		{
			System.out.println("point1 and point2 have identical " +
			"instance data");
		}
		else
		{
			System.out.println("point1 and point2 have different " + 
			"instance data");
		}

	} // end compareRefs

	// Demonstrates that String literals all share the same underlying object 
	// Thus == may not always exhibit the expected behavior
	public static void compareStringRefs()
	{
		// The same thing applies to strings:
		String string1 = "Sam"; // new String("I am a string");
		String string2 = "Sam"; // new String("I am a string");

		if (string1 == string2)
		{
			System.out.println("string1 and string2 are the same object");
		}
		else
		{
			System.out.println("string1 and string2 are NOT the " + 
			"same object");
		}

		// However, we can use the equals method to see if they have
		// the same data:
		if (string1.equals(string2))
		{
			System.out.println("string1 and string2 have identical " +
			"instance data");
		}
		else
		{
			System.out.println("string1 and string2 have different " + 
			"instance data");
		}

		// As an experiment, replace the first two lines of this
		// method with these lines:
		//
		// String string1 = "I am a string literal");
		// String string2 = "I am a string literal");
		//
		// You will see that if you incorrectly use == to compare
		// strings, you may not see the error right away!

	} // end compareStringRefs

	// Demonstrate that using = to assign objects produces two names for the same object
	public static void copyRefs()
	{
		Point2D point1 = new Point2D(3.0, 4.0);

		// Point2 is not a second name for the same object!
		Point2D point2 = point1;

		System.out.println("The value of point1 is: " + point1);
		System.out.println("The value of point2 is: " + point2);

		System.out.println("The object point1 \"refers to\" has this data: " +
				point1.toString2());
		System.out.println("The object point2 \"refers to\" has this data: " +
				point2.toString2());
	   

		// Notice that, although point1 and point2 have identical
		if (point1 == point2)
		{
			System.out.println("point1 and point2 are the same object");
		}
		else
		{
			System.out.println("point1 and point2 are NOT the same object");
		} 

		// However, we can use the equals method to see if they have
		// the same data:
		if (point1.equals(point2))
		{
			System.out.println("point1 and point2 have identical " +
			"instance data");
		}
		else
		{
			System.out.println("point1 and point2 have different " + 
			"instance data");
		}

		System.out.println("\n\nNow calling setXY(5.0, 6.0) on point1: ");
		point1.setXY(5.0, 6.0);
		System.out.println("The new value of point1 is: " + point1);
		System.out.println("The  value of point2 is: " + point2);

		System.out.println("The object point1 \"refers to\" has this data: " +
				point1.toString2());
		System.out.println("The object point2 \"refers to\" has this data: " +
				point2.toString2());
		System.out.println("Changing point1 also changed point2");
	   
	} // end 

	// Demonstrates use of clone method.
	public static void cloneObject()
	{
		Point2D point1 = new Point2D(3.0, 4.0);

		// Point2 is a "clone" of point1: A separate object with the
		// same data
		Point2D point2 = point1.clone();

		System.out.println("The value of point1 is: " + point1);
		System.out.println("The value of point2 is: " + point2);
	    
		System.out.println("The object point1 \"refers to\" has this data: " +
				point1.toString2());
		System.out.println("The object point2 \"refers to\" has this data: " +
				point2.toString2());


		// Notice that, although point1 and point2 have identical
		// instance data, they are not the same object.
		if (point1 == point2)
		{
			System.out.println("point1 and point2 are the same object");
		}
		else  
		{
			System.out.println("point1 and point2 are NOT the same object");
		}

		// However, we can use the equals method to see if they have
		// the same data:
		if (point1.equals(point2))
		{
			System.out.println("point1 and point2 have identical " +
			"instance data");
		}
		else
		{
			System.out.println("point1 and point2 have different " + 
			"instance data");
		}

		System.out.println("\n\nNow calling setXY(5.0, 6.0) on point1: ");
		point1.setXY(5.0, 6.0);
		System.out.println("The new value of point1 is: " + point1);
		System.out.println("The  value of point2 is: " + point2);

		System.out.println("The object point1 \"refers to\" has this data: " +
				point1.toString2());
		System.out.println("The object point2 \"refers to\" has this data: " +
				point2.toString2());
		System.out.println("Changing point1 did NOT change point 2");

	} // end 

	public static void method1(Point2D pPoint)
	{
		System.out.println("\n\tThe current value of pPoint is: " + 
				pPoint + ".");
		System.out.println("\tThe object pPoint \"refers to\" has this data: " +
				pPoint.toString2());

		pPoint.setXY(20.0, 40.0);
		System.out.println("\n\tThe new value of pPoint is: " + 
				pPoint + ".");
		System.out.println("\tThe object pPoint \"refers to\"  now has this data: " +
				pPoint.toString2());
	}

	// Demonstrates that methods can modify objects.
	public static void refsAsParms()
	{

		Point2D point1 = new Point2D(10.0, 12.0);

		System.out.println("The current value of point1 is: " + 
				point1 + ".");
		System.out.println("The object point1 \"refers to\" has this data: " +
				point1.toString2());
		method1(point1);
		System.out.println("\nAfter calling method1, the value of point1 is: " + 
				point1 + ".");
		System.out.println("After callilng method1,  point1 \"refers to\" " + 
				"an object with this data: " +
				point1.toString2());
	}


	public static void method2(Point2D pPoint)
	{
		System.out.println("\n\tThe current value of pPoint is: " + 
				pPoint + ".");
		System.out.println("\tThe object pPoint \"refers to\" has this data: " +
				pPoint.toString2());

		pPoint = new Point2D(40.0, 60.0);
		System.out.println("\n\tThe new value of pPoint is: " + 
				pPoint + ".");
		System.out.println("\tThe object pPoint \"refers to\"  now has this data: " +
				pPoint.toString2());
	}


	// Demonstrate that methods can't modify references.
	public static void refsAsParms2()
	{

		Point2D point1 = new Point2D(10.0, 12.0);

		System.out.println("The current value of point1 is: " + 
				point1 + ".");
		System.out.println("The object point1 \"refers to\" has this data: " +
				point1.toString2());
		method2(point1);
		System.out.println("\nAfter calling method2, the value of point1 is: " + 
				point1 + ".");
		System.out.println("After callilng method2,  point1 \"refers to\" " + 
				"an object with this data: " +
				point1.toString2());
	}

	public static void blankLines()
	{
		System.out.println("\n\n\n");
	}
	public static void main(String args[])
	{
		//refVsObject();
		//blankLines();


		compareRefs();
		//blankLines();

		//compareStringRefs();
		//blankLines();


		//copyRefs();
		//blankLines();

		//cloneObject();
		//blankLines();

		//refsAsParms();
		//blankLines();


		//refsAsParms2();
		//blankLines();


	}
}
