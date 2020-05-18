import java.awt.*;
// Talk about lab
//   * useful examples on p393, 396, and 400.

// Show equals() short-cut
// Show modifySong() short-cut

class ArrayExamples {

    public static final int ARRAY_SIZE = 10;

    public static void main(String[] args) {
        //init();
        using_arrays();
        //copy1();  // Don't forget parameter passing.
        //demo_faulty_load_array();
        //copy2();
        //copy2b();

    }


    //-----------------------------------------------------------------
    //
    // Initializing Arrays
    //
    //------------------------------------------------------------------
    public static void init() {

        int[] int_array = new int[ARRAY_SIZE];
        double[] double_array = new double[ARRAY_SIZE];
        Point[] point_array = new Point[ARRAY_SIZE];


        // Notice that int and double arrays are initialized to 0
        System.out.println("Contents of int_array:");
        for (int x = 0; x < int_array.length; x++) {
            System.out.println("int_array[" + x + "] = "
                    + int_array[x]);
        }

        // Notice that int and double arrays are initialized to 0
        System.out.println("\n\nContents of double_array:");
        for (int x = 0; x < double_array.length; x++) {
            System.out.println("double_array[" + x + "] = "
                    + double_array[x]);
        }

        // Notice that objects are initialized to null.
        System.out.println("\n\nContents of Point_array:");
        for (int x = 0; x < point_array.length; x++) {
            System.out.println("point_array[" + x + "] = "
                    + point_array[x]);

            // If I try to call a method on point_array[x],
            // java throws an exception.
            //point_array[x].translate(1,1);
        }
    }

    //-----------------------------------------------------------------
    //
    // Using arrays
    //
    //------------------------------------------------------------------
    public static void using_arrays() {
        Point[] point_array = new Point[ARRAY_SIZE];

        // Fill up the first half.
        for (int x = 0; x < ARRAY_SIZE / 2; x++) {
            point_array[x] = new Point(x, x * x);
        }

        // Print out list
        System.out.println("point_array half full");
        for (int x = 0; x < ARRAY_SIZE; x++) {
            System.out.println("Point " + x + " is " + point_array[x]);
        }


        // Fill up the second half with data from first half.
        for (int x = ARRAY_SIZE / 2; x < ARRAY_SIZE; x++) {
            // Note:  No parens needed
            point_array[x] = point_array[x - ARRAY_SIZE / 2];
        }


        System.out.println("\n\npoint_array full.  Second half equal to "
                + "first half.");
        for (int x = 0; x < ARRAY_SIZE; x++) {
            System.out.println("Point " + x + " is " + point_array[x]);
        }


        // Now, lets set the x value of each point to x.
        for (int x = ARRAY_SIZE / 2; x < ARRAY_SIZE; x++) {
            // Note:  No parens needed
            point_array[x].y = x;
        }

        System.out.println("\n\nSince we only copied references, "
                + "changes to 2nd half affect 1st half.");
        for (int x = 0; x < ARRAY_SIZE; x++) {
            System.out.println("Point " + x + " is " + point_array[x]);
        }

    }

    //-----------------------------------------------------------------
    //
    // Copying Arrays
    //
    // 1).  Copying array reference gives same array object two "names"
    //
    // This is what happens when you pass an array to a method.
    // Method has it's own reference to the array passed.
    //------------------------------------------------------------------
    public static void load_array_with_squares(int[] int_array) {
        for (int x = 0; x < int_array.length; x++) {
            int_array[x] = x * x;
        }
    }


    public static void copy1() {
        int[] int_array1 = new int[ARRAY_SIZE];
        load_array_with_squares(int_array1);

        // This only copies *reference*.  Both int_array1 and
        // int_array2 reference (or "point to") same data
        int[] int_array2 = int_array1;

        System.out.println("int_array1 and int_array2 are the same\n");
        System.out.println("x\tint_array1\tint_array2");
        for (int x = 0; x < int_array1.length; x++) {
            System.out.println(x + "\t    " + int_array1[x]
                    + "\t\t    " + int_array2[x]);
        }

        // By changing some elements in int_array2, we're really changing
        // int_array1.
        for (int x = 0; x < int_array1.length; x += 2) {
            int_array2[x] = x;
        }

        System.out.println("\n\nChanging int_array2 also changed int_array1");
        System.out.println("x\tint_array1\tint_array2");
        // You can see changes here.
        for (int x = 0; x < int_array1.length; x++) {
            System.out.println(x + "\t    " + int_array1[x]
                    + "\t\t    " + int_array2[x]);
        }
    } // end Copy 1

    //-----------------------------------------------------------------
    //
    // Copying Arrays
    //
    // 2a).  To make separate array objects, use clone() method.
    //
    // This does a *shallow* copy:  It copies the values in
    // Each array index into a new array object.
    //
    //------------------------------------------------------------------
    public static void copy2() {
        int[] int_array1 = new int[ARRAY_SIZE];
        load_array_with_squares(int_array1);

        // This clones the array.  It makes a separate object and
        // copies all the data in int_array1 into int_array2.
        int[] int_array2 = (int[]) (int_array1.clone());

        System.out.println("int_array1 and int_array2 are the same\n");
        System.out.println("x\tint_array1\tint_array2");
        for (int x = 0; x < int_array1.length; x++) {
            System.out.println(x + "\t    " + int_array1[x]
                    + "\t\t    " + int_array2[x]);
        }

        // Now, because we cloned() array1, changing elements in
        // int_array2, does not change array1.
        for (int x = 0; x < int_array1.length; x += 2) {
            int_array2[x] = x;
        }

        System.out.println("\n\nChanging int_array2 has not changed int_array1");
        System.out.println("x\tint_array1\tint_array2");
        // You can see changes here.
        for (int x = 0; x < int_array1.length; x++) {
            System.out.println(x + "\t    " + int_array1[x]
                    + "\t\t    " + int_array2[x]);
        }
    } // end copy2

    //-----------------------------------------------------------------
    //
    // Copying Arrays
    //
    // 2b).  Take care when making shallow copies.  Copying references means
    // you have two pointers to the same objects.
    //
    //------------------------------------------------------------------
    public static void copy2b() {
        Point[] point_array = new Point[ARRAY_SIZE];

        for (int x = 0; x < ARRAY_SIZE; x++) {
            point_array[x] = new Point(x, x * x);
        }


        Point[] point_array2 = (Point[]) (point_array.clone());

        // Print out list
        System.out.println("point_array and point_array2:");
        for (int x = 0; x < ARRAY_SIZE; x++) {
            System.out.println("Point " + x + " is " + point_array[x]
                    + " and " + point_array2[x]);
        }

        // Because we cloned the array, we can change the point_array2
        // object without affecting point_array1.  Here, we reverse
        // the order of the Points in the array.
        for (int x = 0; x < ARRAY_SIZE / 2; x++) {
            // see p 407 for discussion of how this works.
            int place = point_array2.length - 1 - x;

            Point temp = point_array2[x];
            point_array2[x] = point_array2[place];
            point_array2[place] = temp;
        }

        System.out.println("\n\nChanges to the point_array2 object itself "
                + " are not reflected in point_array.");
        for (int x = 0; x < ARRAY_SIZE; x++) {
            System.out.println("Point " + x + " is " + point_array[x]
                    + " and " + point_array2[x]);
        }


        // Changes to *objects* in point_array2 are seen in
        // point_array1, because the two arrays contain references to
        // the same objects.
        for (int x = 0; x < ARRAY_SIZE; x++) {
            point_array2[x].y = x;
        }


        System.out.println("\n\nSince we only copied references, "
                + "changes to objects in point_array2 affect"
                + " point_array 1");
        for (int x = 0; x < ARRAY_SIZE; x++) {
            System.out.println("Point " + x + " is " + point_array[x]
                    + " and " + point_array2[x]);
        }
    }

    //-----------------------------------------------------------------
    //
    // Faulty parameter passing.
    //
    //------------------------------------------------------------------


    // What's wrong with this??
    public static void faulty_load_array(int[] array) {
        int temp[] = new int[ARRAY_SIZE];
        for (int x = 0; x < temp.length; x++) {
            temp[x] = x * x;
        }

        array = temp;
        return;
    }


    public static void demo_faulty_load_array() {
        int array[] = new int[ARRAY_SIZE];
        faulty_load_array(array);

        System.out.println("Contents of array:");
        for (int x = 0; x < array.length; x++) {
            System.out.println("array[" + x + "] = "
                    + array[x]);
        }
    }
}
	
      
	