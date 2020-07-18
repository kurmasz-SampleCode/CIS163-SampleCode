package gvsucis.functional;

import java.util.*;

public class ForEach {
  
  public static class Student {

    public void addCredit(double amount) {}
  }

  public static void main(String[] args) {
    ArrayList<Student> studentList = new ArrayList<Student>();

    // Traditional OO/procedural/Java approach
    for (Student s : studentList) {
      s.addCredit(100.0);
    }

    // newer functional approach
    studentList.forEach( (s) -> s.addCredit(100.0));
  }
}