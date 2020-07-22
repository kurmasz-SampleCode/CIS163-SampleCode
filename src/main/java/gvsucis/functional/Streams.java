package gvsucis.functional;

import java.util.stream.*;
import java.util.*;

public class Streams {

  public static class Person {
    public String name;
    public int age;
    
    public Person(String name, int age) {
      this.name = name;
      this.age = age;
    }

  }

  public static void main(String[] args) {

    List<Integer> oddSquares = Stream.of(8, 4, 3, 2, 5, 1, 9, 7, 4, 1, 6).filter((i) -> i % 2 == 1).map((i) -> i * i)
        .collect(Collectors.toList());
    System.out.println("odd squares: " + oddSquares);

    Person[] people = {new Person("Bob", 41), new Person("James", 27), new Person("Fred", 14), new Person("Tyler", 81), new Person("Andrew", 6)};
    List<String> adults = Arrays.stream(people).filter((p) -> p.age >= 18).map((p) -> p.name).collect(Collectors.toList());
    System.out.println("The adults: " + adults);
  }
}