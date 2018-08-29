package serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationDemo {

  public static void main(String[] args) {
    System.out.println("Deserialization Demo");

    try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("C:\\workspace\\ser.txt"))) {
      SerializePojo object = (SerializePojo) inputStream.readObject();
      System.out.println("De-serializing: " + object);

    } catch (IOException ex) {
      System.err.println("Could not read from file");
      ex.printStackTrace();
    } catch (ClassNotFoundException e) {
      System.err.println("Could not find class for deserialization");
      e.printStackTrace();
    }
  }
}
