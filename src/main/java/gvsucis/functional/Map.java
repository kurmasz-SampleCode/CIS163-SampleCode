package gvsucis.functional;

import java.util.*;
import java.util.function.*;
import java.util.Arrays;
import java.awt.Point;

public class Map {

  public static <In, Out> ArrayList<Out> map(List<In> input, Function<In, Out> function) {
    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Out> output = (ArrayList<Out>) new ArrayList(input.size());
    input.forEach((item) -> output.add(function.apply(item)));
    return output;
  }

  public static void main(String[] args) {
    List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
    List<Integer> squares = map(nums, (i) -> i * i);
    System.out.println(squares);

    List<Point> points = Arrays.asList(new Point(3, 4), new Point(5, 6), new Point(7, 8), new Point(10, 12));
    List<Integer> xOnly = map(points, (p) -> p.x);
    List<Integer> yOnly = map(points, (p) -> p.y);
    List<Double> distance = map(points, (p) -> Math.sqrt(p.x*p.x - p.y*p.y));
    System.out.println(xOnly);
    System.out.println(yOnly);
  }

}