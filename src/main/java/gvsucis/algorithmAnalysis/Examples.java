package gvsucis.algorithmAnalysis;

public class Examples {

  public static long sumArray(int[] values) {
    long answer = 0;
    for (int i = 0; i < values.length; ++i) {
      answer = answer + values[i];
    }
    return answer;
  }

  public static long multiplyArray(int[] values) {
    long answer = 1;
    for (int i = 0; i < values.length; ++i) {
      answer = answer * values[i];
    }
    return answer;
  }

  public static long multiplyArray_v2(int[] values) {
    long answer = 1;
    for (int i : values) {
      answer *= values[i];
    }
    return answer;
  }

  public static int locOfMax(int[] values) {
    int loc = 0;
    for (int i = 0; i < values.length; ++i) {
      if (values[i] > values[loc]) {
        loc = i;
      }
    }
    return loc;
  }

  public static int fastMode(int[] values) {
    int loc = locOfMax(values);
    int[] counts = new int[values[loc] + 1];
    for (int v : values) {
      counts[v]++;
    }

    return locOfMax(counts);
  }

  public static int slowMode(int[] values) {

    int currentMode = values[0];
    int modeCount = 1;

    for (int v : values) {
      int currentCount = 0;
      for (int v2 : values) {
        if (v == v2) {
          ++currentCount;
        }
      }
      if (currentCount > modeCount) {
        modeCount = currentCount;
        currentMode = v;
      }      
    }
    return currentMode;
  }

  public char firstRepeatedCharacter(String word) {
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (ch == word.charAt(i + 1))
        return ch;
    }
    return 0;
  }

  public static interface Person {
    void meet(Person other);
  }

  public static void meetEverybody(Person[] people) {
    for (int i = 0; i < people.length; ++i) {
      for (int j = i + 1; j <people.length; ++i) {
        people[i].meet(people[j]);
      }
    }
  }

  public static void meetEverybodyNaive(Person[] people) {
    for (int i = 0; i < people.length; ++i) {
      for (int j = 0; j <people.length; ++i) {
        people[i].meet(people[j]);
      }
    }
  }


 public static void main(String[] args) {

  int[] test = {1, 5, 3, 2, 3, 5, 1, 3, 3, 4, 6};
  System.out.printf("Modes:  %d  %d\n", fastMode(test), slowMode(test));


 }


}