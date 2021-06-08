package gvsucis.sorts;

import java.util.Arrays;

public class Sorts2 {

  public static int locationOfMinimum(int[] array, int start) {
    int locMin = start;
    for (int j = start + 1; j < array.length; ++j) {
      if (array[j] < array[locMin]) {
        locMin = j;
      }
    }
    return locMin;
  }

  public static void swap(int[] array, int from, int to) {
    int temp = array[from];
    array[from] = array[to];
    array[to] = temp;
  }

  public static void selectionSort(int[] array) {
    for (int i = 0; i < array.length; ++i) {
      int locMin = locationOfMinimum(array, i);
      swap(array, locMin, i);
    }
  }

  public static void main(String[] args) {

    int[] input = { 2, 8, 3, 6, 5, 8, 7, 4, 1, 9, 2, 8, 3 };
    selectionSort(input);
    System.out.println(Arrays.toString(input));
  }

}
