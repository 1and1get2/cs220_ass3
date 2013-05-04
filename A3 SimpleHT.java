import java.io.*;
import java.util.Hashtable;
import java.util.Enumeration;

public class SimpleHT {
  public Hashtable<String, Integer> ht;

  public SimpleHT() {
    ht = new Hashtable<String, Integer>();
  }

  public Integer lookup(String key) {
    Integer count = ht.get(key);
    if (count == null) {   // Not there yet
      ht.put(key, 1);
      count = 1;
    }
    else {
      count += 1;  
      ht.put(key, count);  // Reset its value
    }
    return count;
  }

  public Integer size() {
    return ht.size();
  }

  public void dump() {
    Enumeration e = ht.keys();
    while (e.hasMoreElements() ) {
      String key = e.nextElement().toString();
      System.out.printf("%d: %s\n", ht.get(key), key);
    }
  }
}