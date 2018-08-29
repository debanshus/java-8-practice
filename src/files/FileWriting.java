package files;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriting {

  public static void main(String[] args) {

    /*Trying out FileOutputStream*/
    System.out.println("Writing to file using FileOutputStream");
    String message1 = "Hello FileOutputStream";
    byte[] byteArray1 = message1.getBytes();
    try (FileOutputStream outputStream1 = new FileOutputStream("C:\\workspace\\test1.txt")) {
      outputStream1.write(byteArray1, 0, 10);
    } catch (IOException ex) {
      System.err.println("Error in writing file using FileOutputStream");
      ex.printStackTrace();
    }


    /*Trying out ByteArrayOutputStream*/
    System.out.println("Writing to file using ByteArrayOutputStream");
    String message2 = "Hello ByteArrayOutputStream";
    byte[] byteArray2 = message2.getBytes();
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    try {
      outputStream.write(byteArray2);
      outputStream.writeTo(new FileOutputStream("C:\\workspace\\test2.txt"));
    } catch (IOException e) {
      System.err.println("Error in writing file using ByteArrayOutputStream");
      e.printStackTrace();
    }


    /*Trying out DataOutputStream*/
    System.out.println("Writing to a file using DataOutputStream");
    try (FileOutputStream fileOutputStream = new FileOutputStream("C:\\workspace\\test3.txt");
         DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)) {

      dataOutputStream.writeBoolean(true);
      dataOutputStream.writeDouble(10.23);
      dataOutputStream.writeInt(5);
      dataOutputStream.writeBytes("Hello DataOutputStream");
    } catch (IOException ex) {
      System.err.println("Error in writing file using DataOutputStream");
      ex.printStackTrace();
    }


    /*Trying out FileWriter*/
    System.out.println("\nWriting to a file using FileWriter");
    String message3 = "Hello FileWriter";
    try (FileWriter fileWriter = new FileWriter("C:\\workspace\\test4.txt")) {
      fileWriter.write(message3);
    } catch (IOException ex) {
      System.err.println("Error in writing file using FileReader");
      ex.printStackTrace();
    }


    /*Trying out BufferedWriter*/
    System.out.println("\nWriting to a file using BufferedWriter");
    String message4 = "Hello BufferedWriter";
    try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\workspace\\test5.txt"))) {
      bufferedWriter.write(message4);
    } catch (IOException e) {
      System.err.println("Error in writing file using BufferedWriter");
      e.printStackTrace();
    }

  }
}
