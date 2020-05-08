class ReferenceReadingExamples {

	public static void method1(int x, int y) {
		System.out.printf("     in: x = %d; y = %d\n", x, y);
		int temp;
		temp = x;
		x = y;
		y = temp;
		System.out.printf("    out: x = %d; y = %d\n", x, y);
	}

	public static void method3(Point2D x, Point2D y) {
		System.out.printf("     in: ptx = %s; pty = %s\n", x.toString2(), y.toString2());
		Point2D temp = x;
		temp.setX(x.getX() + y.getX());
		temp.setY(x.getY() + y.getY());
		System.out.printf("    out: ptx = %s; pty = %s\n", x.toString2(), y.toString2());
	}

	public static void method4(Point2D x, Point2D y) {
		System.out.printf("     in: ptx = %s; pty = %s\n", x.toString2(), y.toString2());
		Point2D temp;
		temp = x;
		x = y;
		y = temp;
		System.out.printf("    out: ptx = %s; pty = %s\n", x.toString2(), y.toString2());
	}

	public static void method5(Point2D x, Point2D y) {
		System.out.printf("     in: ptx = %s; pty = %s\n", x.toString2(), y.toString2());
		x = new Point2D(y.getX(), y.getY());
		System.out.printf("    out: ptx = %s; pty = %s\n", x.toString2(), y.toString2());
	}

	public static void method6(Point2D x, Point2D y) {
		System.out.printf("     in: ptx = %s; pty = %s\n", x.toString2(), y.toString2());
		x.setX(y.getX());
		x = new Point2D(y.getX(), y.getY());
		x.setY(y.getY());
		System.out.printf("    out: ptx = %s; pty = %s\n", x.toString2(), y.toString2());
	}

	public static void method7(Point2D x, Point2D y) {
		System.out.printf("     in: ptx = %s; pty = %s\n", x.toString2(), y.toString2());
		x = y;
		x.setX(y.getX()*2);
		x.setY(y.getY()*2);
		System.out.printf("    out: ptx = %s; pty = %s\n", x.toString2(), y.toString2());
	}


	public static void method8(Point2D x, Point2D y) {
		x.setXY(y.getX(), y.getY());
	}

	public static void method9(Point2D x, Point2D y) {
		x.setXY(y.getY(), y.getX());
	}

	public static void method10(Point2D x, Point2D y) {
		x.setX(y.getX());
		y.setY(x.getY());
	}

	public static void method11(Point2D x, Point2D y) {
		x.setX(y.getY());
		y.setY(x.getX());
	}

	public static void main(String[] args) {

		final int exampleToRun =7 ;

		switch (exampleToRun) {

			case 1:
				System.out.println("Case 1:");
				int x = 7;
				int y = 8;
				System.out.printf("   init: x = %d; y = %d\n", x, y);
				method1(x, y);
				System.out.printf("   main: x = %d; y = %d\n", x, y);
				break;

			case 2:
				System.out.println("Case 2:");
				x = 17;
				y = 14;
				System.out.printf("   init: x = %d; y = %d\n", x, y);
				method1(y, x);
				System.out.printf("   main: x = %d; y = %d\n", x, y);
				break;

			case 3:
				System.out.println("Case 3:");
				Point2D ptx = new Point2D(2, 2);
				Point2D pty = new Point2D(4, 4);
				System.out.printf("   init: ptx = %s; pty = %s\n", ptx.toString2(), pty.toString2());
				method3(ptx, pty);
				System.out.printf("   main: ptx = %s; pty = %s\n", ptx.toString2(), pty.toString2());
				break;

			case 4:
				System.out.println("Case 4:");
				ptx = new Point2D(10, 10);
				pty = new Point2D(20, 20);
				System.out.printf("   init: ptx = %s; pty = %s\n", ptx.toString2(), pty.toString2());
				method4(ptx, pty);
				System.out.printf("   main: ptx = %s; pty = %s\n", ptx.toString2(), pty.toString2());
				break;

			case 5:
				System.out.println("Case 5:");
				ptx = new Point2D(15, 15);
				pty = new Point2D(25, 25);
				System.out.printf("   init: ptx = %s; pty = %s\n", ptx.toString2(), pty.toString2());
				method5(ptx, pty);
				System.out.printf("   main: ptx = %s; pty = %s\n", ptx.toString2(), pty.toString2());
				break;

			case 6:
				System.out.println("Case 6:");
				ptx = new Point2D(41, 42);
				pty = new Point2D(43, 44);
				System.out.printf("   init: ptx = %s; pty = %s\n", ptx.toString2(), pty.toString2());
				method6(ptx, pty);
				System.out.printf("   main: ptx = %s; pty = %s\n", ptx.toString2(), pty.toString2());
				break;

			case 7:
				System.out.println("Case 7:");
				ptx = new Point2D(2, 3);
				pty = new Point2D(9, 11);
				System.out.printf("   init: ptx = %s; pty = %s\n", ptx.toString2(), pty.toString2());
				method7(ptx, pty);
				System.out.printf("   main: ptx = %s; pty = %s\n", ptx.toString2(), pty.toString2());
				break;

			case 8:
				System.out.println("Case 8:");
				ptx = new Point2D(41, 42);
				pty = new Point2D(43, 44);
				System.out.printf("   init: ptx = %s; pty = %s\n", ptx.toString2(), pty.toString2());
				method8(ptx, pty);
				System.out.printf("   main: ptx = %s; pty = %s\n", ptx.toString2(), pty.toString2());
				break;

			case 9:
				System.out.println("Case 9:");
				ptx = new Point2D(41, 42);
				pty = new Point2D(43, 44);
				System.out.printf("   init: ptx = %s; pty = %s\n", ptx.toString2(), pty.toString2());
				method9(ptx, pty);
				System.out.printf("   main: ptx = %s; pty = %s\n", ptx.toString2(), pty.toString2());
				break;

			case 10:
				System.out.println("Case 10:");
				ptx = new Point2D(41, 42);
				pty = new Point2D(43, 44);
				System.out.printf("   init: ptx = %s; pty = %s\n", ptx.toString2(), pty.toString2());
				method10(ptx, pty);
				System.out.printf("   main: ptx = %s; pty = %s\n", ptx.toString2(), pty.toString2());
				break;

				case 11:
				System.out.println("Case 10:");
				ptx = new Point2D(41, 42);
				pty = new Point2D(43, 44);
				System.out.printf("   init: ptx = %s; pty = %s\n", ptx.toString2(), pty.toString2());
				method11(ptx, pty);
				System.out.printf("   main: ptx = %s; pty = %s\n", ptx.toString2(), pty.toString2());
				break;

		}

	}
}