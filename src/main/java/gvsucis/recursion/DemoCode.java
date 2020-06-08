package gvsucis.recursion;

public class DemoCode {

  // Recursion
  // * a method that calls itself
  // * defining a problem in terms of (a smaller version of) itself

  // Fibonacci: 1 1 2 3 5 8 13 21 34
  // F(n) = 1 if n == 1 or n == 2; F(n-1) + F(n-2)

  public static long fib(int n) {
    if (n <= 2) {
      return 1;
    } else {
      return fib(n - 2) + fib(n - 1);
    }
  }

  public static long fib_iterative(int n) {
    if (n <= 2) {
      return 1;
    }

    // 1 1 2 3 5 8 13 21
    int one_before_previous = 1;
    int previous = 1;

    for (int i = 3; i <= n; ++i) {
      int temp = one_before_previous;
      one_before_previous = previous;
      previous = previous + temp;
    }
    return previous;
  }

  // factorial
  // 6! = 6 * 5 * 4 * 3 * 2 *1

  public static int fact(int n) {
    if (n <= 1) {
      return 1;
    }

    return fact(n - 1) * n;
  }

  public static boolean isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
  }

  public static boolean allVowels(String s) {

    if (s.length() == 0) {
      return true;
    }

    return isVowel(s.charAt(0)) && allVowels(s.substring(1));
  }

  public static boolean palindrome(String s) {
    if (s.length() <= 1)
      return true;

    if (s.charAt(0) == s.charAt(s.length() - 1)) {
      return palindrome(s.substring(1, s.length() - 1));
    }

    return false;
  }

  public static int maxValue(int[] array, int start) {
    if (start == array.length - 1) {
      return array[start];
    }

    int max_end = maxValue(array, start + 1);
    if (max_end > array[start]) { 
      return max_end;
    } else {
      return array[start];
    }
  }

  // A list is either:
  // (1) a single element 
  // (2) A list followed by an element 

  public static void main(String[] args) {

    int[] array = {9, 4, 5, 2};
    System.out.printf("max: %d\n", maxValue(array, 0));

  }

}