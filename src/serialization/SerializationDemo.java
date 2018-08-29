package serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationDemo {

  public static void main(String[] args) {
    System.out.println("Serialization Demo");

    try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("C:\\workspace\\ser.txt"))) {
      SerializePojo object = new SerializePojo("Hello", 1, 10.5, 20.5);
      System.out.println("Serializing: " + object);

      outputStream.writeObject(object);
    } catch (IOException ex) {
      System.err.println("Cannot serialize object");
      ex.printStackTrace();
    }
  }

}
