package files;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.SequenceInputStream;

public class FileReading {

  public static void main(String[] args) {

    learningFileInputStream();

    learningByteArrayInputStream();

    learningSequenceInputStream();

    learningDataInputStream();

    learningFileReader();

    learningBufferedReader();
  }

  private static void learningFileInputStream() {
    System.out.println("\n\nReading from file using FileInputStream");
    try (FileInputStream inputStream = new FileInputStream("C:\\workspace\\test1.txt")) {
      int ch;
      while ((ch = inputStream.read()) != -1) {
        System.out.print((char) ch);
      }
    } catch (IOException ex) {
      System.err.println("Error in reading file using FileInputStream");
      ex.printStackTrace();
    }
  }

  private static void learningByteArrayInputStream() {
    System.out.println("\n\nReading from using ByteArrayInputStream");
    String message = "Hello ByteArrayInputStream";
    byte[] byteArray = message.getBytes();
    ByteArrayInputStream inputStream = new ByteArrayInputStream(byteArray);
    int ch;
    while ((ch = inputStream.read()) != -1) {
      System.out.print((char) ch);
    }
  }

  private static void learningSequenceInputStream() {
    System.out.println("\n\nReading from using SequenceInputStream");
    String message1 = "Hello SequenceInputStream One";
    String message2 = "Hello SequenceInputStream Another";
    try (SequenceInputStream sequenceInputStream = new SequenceInputStream(
        new ByteArrayInputStream(message1.getBytes()), new ByteArrayInputStream(message2.getBytes()))) {
      int c;
      while ((c = sequenceInputStream.read()) != -1) {
        System.out.print((char) c);
      }
    } catch (IOException ex) {
      System.err.println("Error in reading file using SequenceInputStream");
    }
  }

  private static void learningDataInputStream() {
    System.out.println("\n\nReading to a file using DataInputStream");
    try (FileInputStream fileInputStream = new FileInputStream("C:\\workspace\\test3.txt");
         DataInputStream dataInputStream = new DataInputStream(fileInputStream)) {

      System.out.println(dataInputStream.readBoolean());
      System.out.println(dataInputStream.readDouble());
      System.out.println(dataInputStream.readInt());

      byte[] bytes = new byte[100];
      dataInputStream.readFully(bytes);
      System.out.println(new String(bytes));

    } catch (IOException ex) {
      System.err.println("Error in reading file using DataInputStream");
      ex.printStackTrace();
    }
  }

  private static void learningFileReader() {
    System.out.println("\nReading file using FileReader");
    try (FileReader reader = new FileReader("C:\\workspace\\test4.txt")) {
      int c;
      while ((c = reader.read()) != -1) {
        System.out.print((char) c);
      }
    } catch (IOException ex) {
      System.err.println("Error in reading file using FileReader");
    }
  }

  private static void learningBufferedReader() {
    System.out.println("\nReading file using BufferedReader");
    try (BufferedReader reader = new BufferedReader(new FileReader("C:\\workspace\\test5.txt"))) {
      int c;
      while ((c = reader.read()) != -1) {
        System.out.print((char) c);
      }
    } catch (IOException ex) {
      System.err.println("Error in reading file using BufferedReader");
    }
  }
}
