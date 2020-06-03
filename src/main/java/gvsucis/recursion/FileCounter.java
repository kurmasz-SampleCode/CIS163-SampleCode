package gvsucis.recursion;

import java.io.File;

public class FileCounter {

  public static void main(String[] args) {
    String start = args[0];
    String pattern = args[1];
    int count = searchDirectory(new File(start), pattern); 
    System.out.printf("Found %d files that end with %s\n", count, pattern);
  }

  public static int searchDirectory(File directory, String pattern) {

    int count = 0;
    for( File f : directory.listFiles()) {      
      if (f.getName().endsWith(pattern)) {
        ++count;
      }

      if (f.isDirectory()) {
       count += searchDirectory(f, pattern);
      }
    }
    return count;
  }

}