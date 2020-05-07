/*************************************************************************
 * This is just a simple class containing two double values for for
 * the purpose of illustrating how references work.
 * 
 * @author Zachary Kurmas
 *
 *************************************************************************/

public class Point2D
{
	////////////////////////////////
	//
	// data (instance variables)
	//
	////////////////////////////////

    private double x;
    private double y;


	////////////////////////////////
	//
	// methods
	//
	////////////////////////////////


	// Constructor
	// Note:  Same name as class and 
	// no return type.
	public Point2D(double x1, double y1)
	{
		x = x1;
		y = y1;
	}

	public void setX(double pX) 
	{
		x = pX;
	}


	public void setY(double pY) 
	{
		y = pY;
	}

	public double getX() { return x;}

	public double getY() {return y;}
	

	public void setXY(double pX, double pY)
	{
		x = pX;
		y = pY;
	}


	public double distance_from_zero()
	{
		return Math.sqrt(x*x + y * y);
	}


	// I intentionally named this toString2 so that the "default"
	// version of toString would remain.
	public String toString2()
	{
		return "(" + x + ", " + y +")";
	}


	public boolean equals(Point2D otherPoint)
	{
		return (x == otherPoint.x && y == otherPoint.y);
	}

	public Point2D clone()
	{
		return new Point2D(x, y);
	}

} // end class Point2D;
