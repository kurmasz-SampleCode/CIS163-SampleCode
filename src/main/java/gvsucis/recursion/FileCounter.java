package gvsucis.recursion;

import java.io.File;
import java.util.Stack;

public class FileCounter {

  public static void main(String[] args) {
    String start = ".";
    String pattern = ".class";

    if (args.length >= 2) {
      start = args[0];
      pattern = args[1];
    }
    
    int count = searchDirectory(new File(start), pattern); 
    System.out.printf("Recursively found %d files that end with %s\n", count, pattern);

    count = searchDirectoryIterative(new File(start), pattern); 
    System.out.printf("Iteratively found %d files that end with %s\n", count, pattern);
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

  public static int searchDirectoryIterative(File root, String pattern) {

    int count = 0;
    Stack<Integer> fileNumber = new Stack<>();
    Stack<File[]> listStack = new Stack<>();

    File[] currentDirectoryFiles = root.listFiles();
    int i = 0;
    while (true) {
      File currentFile = currentDirectoryFiles[i];
      if (currentFile.getName().endsWith(pattern)) {
        ++count;
      }

      if (currentFile.isDirectory()) {      
       fileNumber.push(i);
       listStack.push(currentDirectoryFiles);
       currentDirectoryFiles = currentFile.listFiles();
       i = -1;
      } 

      ++i;

      // If we reach the end of a directory, move back up a level.
      while (i >= currentDirectoryFiles.length) {      
        // if the stack is empty, we're done.
        if (fileNumber.empty()) {
          return count;
        }
        i = fileNumber.pop() + 1;
        currentDirectoryFiles = listStack.pop();
      }
    }
  }
}