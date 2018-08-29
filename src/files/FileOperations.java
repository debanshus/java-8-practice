package files;

import java.io.File;
import java.io.IOException;

public class FileOperations {

  public static void main(String[] args) {
    //Creating new file
    File file1 = new File("C:\\workspace\\test1.txt");
    try {
      file1.createNewFile();
    } catch (IOException e) {
      System.err.println("Error in creating new file");
    }

    //Checking if a file is a directory
    File file2 = new File("C:\\workspace");

    if (file2.exists()) {
      //Another way to create a file
      File file3 = new File(file2, "test-dir");
      file3.mkdir();

      File file4 = new File(file2, "test2.txt");
      try {
        file4.createNewFile();
      } catch (IOException e) {
        System.err.println("Error in creating new file");
      }
    }

    if (file2.isDirectory()) {
      System.out.println("Directory free space: " + file2.getFreeSpace());
      System.out.println("Directory total space: " + file2.getTotalSpace());
      System.out.println("Directory usable space: " + file2.getUsableSpace());
      File[] files = file2.listFiles();
      System.out.println("Files in directory:-");
      for (File file : files) {
        System.out.println(file.getName());
      }

      //List of files with name filter
      File[] filteredFiles = file2.listFiles((file, name) -> name.endsWith(".txt"));

      System.out.println("Filtered files:-");
      for (File file: filteredFiles){
        System.out.println(file.getName());
      }
    }

    if (file1.isFile()) {
      System.out.println("File Name: " + file1.getName());
      System.out.println("File Parent: " + file1.getParent());
      System.out.println("File Path: " + file1.getPath());
      System.out.println("File Absolute Path: " + file1.getAbsolutePath());
      try {
        System.out.println("File Canonical Path: " + file1.getCanonicalPath());
      } catch (IOException e) {
        System.out.println("Error in fetching canonical path");
      }
    }
  }
}
