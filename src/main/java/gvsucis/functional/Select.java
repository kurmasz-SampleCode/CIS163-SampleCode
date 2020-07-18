package gvsucis.functional;

import java.util.*;
import java.util.function.Predicate;
import java.awt.Point;

public class Select {

  public static class Student {

    private int credits;
    private double gpa;

    public int getCredits() {
      return credits;
    }

    public double GPA() {
      return gpa;
    }
  }

  public static ArrayList<Student> filterByCredits(ArrayList<Student> studentList, int min, int max) {
    ArrayList<Student> answer = new ArrayList<Student>();

    for (Student s : studentList) {
      if (s.getCredits() >= min && s.getCredits() < max) {
        answer.add(s);
      }
    }
    return answer;
  }

  public static ArrayList<Student> filter(ArrayList<Student> studentList, Predicate<Student> function) {
    ArrayList<Student> answer = new ArrayList<Student>();
    for (Student s : studentList) {
      if (function.test(s)) {
        answer.add(s);
      }
    }
    return answer;
  }

  public static <T> ArrayList<T> genericFilter(ArrayList<T> array, Predicate<T> function) {
    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<T> answer = new ArrayList(array.size());
    for (T item : array) {
      if (function.test(item)) {
        answer.add(item);
      }
    }
    return answer;
  }

  public static <T, C extends Collection<T>> C evenMoreGenericFilter(C array, Predicate<T> function) {
    try {
      @SuppressWarnings("unchecked")
      C answer = (C) array.getClass().newInstance();
      for (T item : array) {
        if (function.test(item)) {
          answer.add(item);
        }
      }
      return answer;
    } catch (InstantiationException e) {
      throw new RuntimeException("Can't use genericFilter on this class");
    } catch (IllegalAccessException e) {
      throw new RuntimeException("Can't use genericFilter on this class");
    }
  }

  public static void main(String[] args) {
    ArrayList<Student> studentList = new ArrayList<Student>();
    studentList.add(new Student());
    studentList.add(new Student());

    ArrayList<Student> seniors = filter(studentList, (s) -> s.getCredits() > 120);
    ArrayList<Student> honorRoll = filter(studentList, (s) -> s.GPA() >= 3.0);

    List<Point> points = new ArrayList<>(
        Arrays.asList(new Point(3, 4), new Point(5, 6), new Point(7, 8), new Point(10, 12)));
    List<Point> closePoints = evenMoreGenericFilter(points, (p) -> {
      double dist = Math.sqrt(p.x * p.x + p.y * p.y);
      return dist <= 6.5;
    });
    System.out.println(closePoints);
  }

}