import java.io.*;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class N_ht {

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);

    Integer nn = 8;
    DHT dht = new DHT(nn);  // You must write this class!

    try {
      String fqdn, src, key;
      Integer count;
      int n = 0;
      do {
        fqdn = scanner.next();  src = scanner.next();
        key = fqdn + " " + src;
        // System.out.printf("%d: %s\n", n, key);
        dht.lookup(key);
        n += 1;
      } while (true);  // (n != 5);
    } catch (NoSuchElementException e) {
      // System.out.printf("end-of-file\n");    
    }

    dht.statistics();
  }
}
