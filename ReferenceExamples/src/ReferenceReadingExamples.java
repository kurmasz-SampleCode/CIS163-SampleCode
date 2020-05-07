class ReferenceReadingExamples {

	public static void example1(int x, int y) {
		int temp;
		temp = x;
		x = y;
		y = temp;
	}

	public static void example2(Point2D x, Point2D y) {
		Point2D temp;
		temp = x;
		x = y;
		y = temp;
	}

	public static void example3(Point2D x, Point2D y) {
		x.setXY(y.getX(), y.getY());
	}

	public static void example4(Point2D x, Point2D y) {
		x.setXY(y.getY(), y.getX());
	}

	public static void example5(Point2D x, Point2D y) {
		x.setX(y.getX());
		y.setY(x.getY());
	}

	public static void example6(Point2D x, Point2D y) {
		x.setX(y.getY());
		y.setY(x.getX());
	}

	public static void example7(Point2D x, Point2D y) {
		x = new Point2D(y.getX(), y.getY());
	}

	public static void example8(Point2D x, Point2D y) {
		x.setX(y.getX());
		x = new Point2D(y.getX(), y.getY());
		x.setY(y.getY());
	}

	public static void main(String[] args) {
		int x = 7;
		int y = 8;
		example1(x, y);
		System.out.printf("Example 1: x = %d; y = %d\n\n", x, y);

		Point2D ptx = new Point2D(0, 0);
		Point2D pty = new Point2D(1, 1);
		example2(ptx, pty);
		System.out.printf("Example 2: ptx = %s; pty = %s\n\n", ptx.toString2(),
				pty.toString2());

		Point2D ptx3 = new Point2D(0, 0);
		Point2D pty3 = new Point2D(1, 1);
		example3(ptx3, pty3);
		System.out.printf("Example 3: ptx3 = %s; pty3 = %s\n\n", ptx3
				.toString2(), pty3.toString2());

		Point2D ptx4 = new Point2D(0, 0);
		Point2D pty4 = new Point2D(5, 9);
		example4(ptx4, pty4);
		System.out.printf("Example 4: ptx4 = %s; pty4 = %s\n\n", ptx4
				.toString2(), pty4.toString2());

		Point2D ptx5 = new Point2D(0, 0);
		Point2D pty5 = new Point2D(5, 9);
		example5(ptx5, pty5);
		System.out.printf("Example 5: ptx5 = %s; pty5 = %s\n\n", ptx5
				.toString2(), pty5.toString2());

		Point2D ptx7 = new Point2D(0, 0);
		Point2D pty7 = new Point2D(5, 9);
		example7(ptx7, pty7);
		System.out.printf("Example 7: ptx7 = %s; pty7 = %s\n\n", ptx7
				.toString2(), pty7.toString2());

		Point2D ptx8 = new Point2D(0, 0);
		Point2D pty8 = new Point2D(5, 9);
		example8(ptx8, pty8);
		System.out.printf("Example 8: ptx8 = %s; pty8 = %s\n\n", ptx8
				.toString2(), pty8.toString2());

	}
}