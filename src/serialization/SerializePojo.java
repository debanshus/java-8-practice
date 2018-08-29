package serialization;

import java.io.Serializable;

public class SerializePojo
    implements Serializable {

  String s;
  int i;
  double d;
  transient double td;

  public SerializePojo(String s, int i, double d, double td) {
    this.s = s;
    this.i = i;
    this.d = d;
    this.td = td;
  }

  @Override
  public String toString() {
    return "SerializePojo{" +
           "s='" + s + '\'' +
           ", i=" + i +
           ", d=" + d +
           ", td=" + td +
           '}';
  }
}
