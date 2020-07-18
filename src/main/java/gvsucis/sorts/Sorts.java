package gvsucis.sorts;

import java.util.Arrays;

public class Sorts {

  public static void selectionSort(int[] array) {
    for (int i = 0; i < array.length; ++i) {
      int locMin = i;
      for (int j = i + 1; j < array.length; ++j) {
        if (array[j] < array[locMin]) {
          locMin = j;
        }
      }
      if (locMin != i) {
        int temp = array[locMin];
        array[locMin] = array[i];
        array[i] = temp;
      }
    }
  }

  public static <T> void swap(T[] array, int from, int to) {
    T temp = array[from];
    array[from] = array[to];
    array[to] = temp;
  }

  public static <T extends Comparable<T>> void selectionSort(T[] array) {
    for (int i = 0; i < array.length; ++i) {
      int locMin = i;
      for (int j = i + 1; j < array.length; ++j) {
        if (array[j].compareTo(array[locMin]) < 0) {
          locMin = j;
        }
      }
      swap(array, i, locMin);
    }
  }

  public static <T extends Comparable<T>> void insertionSort(T[] array) {
    for (int i = 1; i < array.length; ++i) {
      T key = array[i];
      int position = i;
      while (position > 0 && key.compareTo(array[position - 1]) < 0) {
        array[position] = array[position - 1];
        --position;
      }
      array[position] = key;
      // System.out.printf("%d: %s\n", i, Arrays.toString(array));
    }
  }

  public static <T extends Comparable<T>> void bubbleSort(T[] array) {
    for (int i = 0; i < array.length; ++i) {
      for (int j = i + 1; j < array.length; ++j) {
        if (array[i].compareTo(array[j]) > 0) {
          swap(array, i, j);
        }
      }
      // System.out.printf("%d: %s\n", i, Arrays.toString(array));
    }
  }

  public static <T extends Comparable<T>> void merge(T[] array, int start, int mid, int stop) {

    @SuppressWarnings("unchecked")
    T[] temp = (T[]) (new Comparable[array.length]);

    int left = start;
    int right = mid + 1;
    int pos = left;
    while (left <= mid && right <= stop) {
      if (array[left].compareTo(array[right]) < 0) {
        temp[pos] = array[left];
        ++left;
      } else {
        temp[pos] = array[right];
        ++right;
      }
      ++pos;
    }

    while (left <= mid) {
      temp[pos++] = array[left++];
    }

    while (right <= stop) {
      temp[pos++] = array[right++];
    }

    for (int i = start; i <= stop; ++i) {
      array[i] = temp[i];
    }
  }

  public static <T extends Comparable<T>> void mergeSort(T[] array) {
    mergeSort(array, 0, array.length - 1);
  }

  public static <T extends Comparable<T>> void mergeSort(T[] array, int start, int stop) {
    if (stop > start) {
      int mid = (start + stop) / 2;
      mergeSort(array, start, mid);
      mergeSort(array, mid + 1, stop);
      merge(array, start, mid, stop);
    }
  }

  public static <T extends Comparable<T>> int choosePivotLoc(T[] array, int start, int stop) {
    return (start + stop) / 2;
  }

  public static <T extends Comparable<T>> int partition(T[] array, int start, int stop) {

    int pivotLoc = choosePivotLoc(array, start, stop);
    T pivot = array[pivotLoc];

    swap(array, start, pivotLoc);
    int left = start;
    int right = stop;

    while (left < right) {

      while (left < right && array[left].compareTo(pivot) <= 0) {
        ++left;
      }

      while (array[right].compareTo(pivot) > 0) {
        --right;
      }

      if (left < right) {
        swap(array, left, right);
      }
    }
    swap(array, start, right);
    return right;
  }

  public static <T extends Comparable<T>> void quickSort(T[] array) {
    quickSort(array, 0, array.length - 1);
  }

  public static <T extends Comparable<T>> void quickSort(T[] array, int start, int stop) {
    if (stop > start) {
      int pivotLoc = partition(array, start, stop);
      quickSort(array, start, pivotLoc - 1);
      quickSort(array, pivotLoc + 1, stop);
    }
  }

  public static void main(String[] args) {

    /*
    int[] input = {2, 8, 3, 6, 5, 8, 7, 4, 1, 9, 2, 8, 3};
    selectionSort(input);
    System.out.println(Arrays.toString(input));
    */

    
    Integer[] input2 = { 2, 8, 3, 6, 5, 8, 7, 4, 1, 9, 2, 8, 3 };
    selectionSort(input2);
    System.out.println(Arrays.toString(input2));

    String[] input3 = { "James", "Bob", "Fred", "George" };
    selectionSort(input3);
    System.out.println(Arrays.toString(input3));

    //Integer[] input4 = { 2, 8, 3, 6, 5, 7, 4, 1, 9 };
    //quickSort(input4);
    //System.out.println(Arrays.toString(input4));

  }

}