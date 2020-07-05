package gvsucis.algorithmAnalysis;

public class Examples {

  public static int sumArray(int[] array) {
    int sum = 0;
    for (int i = 0; i < array.length; ++i) {
      sum += array[i];
    }
    return sum;
  }

  public static int multiplyArray(int[] array) {
    int product = 1;
    int sum = 0;
    for (int i = 0; i < array.length; ++i) {
      product *= array[i];
      sum += array[i];
    }
    return product + sum;
  }

  public static int sumArray_v2(int[] array) {
    int sum = 0;
    int i = 0;
    while (i < array.length) {
      sum += array[i];
      ++i;
    }
    return sum;
  }

  public static int sumAndMultiplyArray(int[] array) {
    int sum = 1;
    for (int i = 0; i < array.length; ++i) {
      sum *= array[i];
    }
    return sum;
  }

  // This algorithm is O(n)
  public static int locationOfMax(int[] array) {
    int locOfMax = 0;
    for (int i = 0; i < array.length; ++i) {
      if (array[i] > array[locOfMax]) {
        locOfMax = i;
      }
    }
    return locOfMax;
  }

  public static int fastMode(int[] array) {

    int loc = locationOfMax(array);  // O(n)
    int maxValue = array[loc];
    int[] count = new int[maxValue + 1];

    for (int val : array) {
      count[val]++;
    }

    return locationOfMax(count); // !! Be careful  count.length != array.length
  }

  public static int slowMode(int[] array) {

    int maxCount = 0;
    int maxValue = array[0];

    for (int valToCount : array) {
      int localCount = 0;
      for (int val : array) {
        if (val == valToCount) {
          ++localCount;
        }
      }
      if (localCount > maxCount) {
        maxCount = localCount;
        maxValue = valToCount;
      }
    }
    return maxValue;
  }

  public static int linearSearch(int findMe, int[] array) {
    for (int i = 0; i < array.length; ++i) {
      if (array[i] == findMe) {
        return i;
      }
    }
    return -1; // -1 means "NOT FOUND"
  }

  public static int trick1(int[] array) {
    int total = 0;
    for (int i = 0; i < 10; ++i) {
      total += array[i % 10];
    }
    return total;
  }

  public static int trick2(int[] array) {
    int total = 0;
    for (int i = 0; i < array.length; ++i) {
      if (i % 2 == 0) {
        total += locationOfMax(array);
      } else {
        total += array[i];
      }
    }
    return total;
  }

  public static int trick3(int[] array) {
    int total = 0;
    for (int i = 0; i < array.length; ++i) {
      if (i == array.length / 2) {
        total += locationOfMax(array);
      } else {
        total += array[i];
      }
    }
    return total;
  }

  public interface Person {
    public void meet(Person other);
  }

  public static void meetEverybody_v1(Person[] people) {
    for (Person p1 : people) {
      for (Person p2 : people) {
        if (p1 != p2) {
          p1.meet(p2);
        }
      }
    }
  }

  public static void meetEverybody_v2(Person[] people) {
    for (int i = 0; i < people.length; ++i) {
      for (int j = i + 1; j < people.length; ++j) {
        people[i].meet(people[j]);
      }
    }
  }

  public static int sumSome(int[] array) {
    int sum = 0;
    int place = array.length - 1;
    while (place >= 0) {
      sum += array[place];
      place = place / 2;
    }
    return sum;
  }

  public static int binarySearch(int x, int[] arr) {

    // [low, high] is the window we are searching in
    int low = 0, high = arr.length - 1;
    while (low <= high) {
      int midpoint = low + (high - low) / 2;

      // Check if x is present at mid
      if (arr[midpoint] == x)
        return midpoint;

      // If x greater, ignore left half
      if (arr[midpoint] < x)
        low = midpoint + 1;

      // If x is smaller, ignore right half
      else
        high = midpoint - 1;
    }

    // if we reach here, then element was
    // not present
    return -1;
  }
}