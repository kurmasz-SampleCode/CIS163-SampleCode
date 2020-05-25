
package gvsucis.referenceExamples;

public class ShallowVsDeep {

  // [3, 2, 3, 5, 6, 2, 3, 1, 4]
  // assume we know that the values are all [0, 100]
  public static int mode(int[] nums) {

     // Find the integer that occurs most frequently in nums.

    // Just get it working at first; but, see if you can get it working with just one loop.

    int[] counts = new int[101];
    int maxLoc = 0;

    for (int i = 0; i < nums.length; ++i) {
      int currentValue = nums[i]; 
      int occurencesOfThatValue = counts[currentValue];

      counts[currentValue] = counts[currentValue] + 1;

     int newCount =  counts[currentValue];
      if (newCount > counts[maxLoc]) {
        maxLoc = nums[i];
      }
    }

    return counts[maxLoc];
  }

  public static void scratchSpace() {

    int rows = 5;
    int columns = 10;

    // This is a short cut for loop below;
    int[][] matrix = new int[rows][columns];

    // An array full of int[]
    matrix = new int[rows][];
    for (int r = 0; r < rows;++r) {
      matrix[r] = new int[columns];
    }
  }

  public static Point2D[] shallowArrayCopy(Point2D[] points) {

    Point2D[] newArray = new Point2D[points.length];
    
    for (int i = 0; i < points.length; ++i) {
      newArray[i] = points[i];
    }
    return newArray;
  }

  public static Point2D[] deepArrayCopy(Point2D[] points) {

    Point2D[] newArray = new Point2D[points.length];

    for (int i = 0; i < points.length; ++i) {
      // fix this
      newArray[i] = new Point2D(points[i]);
    }
    return newArray;
  }


  public static void main(String[] args) {

    Point2D[] points = {new Point2D(1,1), new Point2D(2, 2), new Point2D(3,3)};
    Point2D[] copyOfPoints = shallowArrayCopy(points);

    copyOfPoints[1].setXY(5, 5);

    System.out.println("Orig[1] = " + points[1].toString2());
    System.out.println("Copy[1] = " + copyOfPoints[1].toString2());


  }


}
