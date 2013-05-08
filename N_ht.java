import java.io.*;
import java.util.Scanner;
import java.util.NoSuchElementException;

// command test
public class N_ht {

	public static void main(String[] args) throws IOException {
		

		Integer nn = 8;
		DHT dht = new DHT(nn); // You must write this class!
/*
		Scanner scanner = new Scanner(System.in);
		try {
			String fqdn, src, key;
			Integer count;
			int n = 0;
			do {
				fqdn = scanner.next();
				src = scanner.next();
				key = fqdn + " " + src;
				// System.out.printf("%d: %s\n", n, key);
				dht.lookup(key);
				n += 1;
			} while (true); // (n != 5);
		} catch (NoSuchElementException e) {
			dht.statistics();
		}*/

		// while (scanner.hasNext()){
		// System.out.println(scanner.next());
		// }
		//
		String fqdn, src, key;
		Integer count;
		int n = 0;
		
		
/*		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			String nextLine = scanner.nextLine();
			//System.out.println("nextLine: " + nextLine + nextLine.equals("\n"));
			Scanner nl = new Scanner(nextLine);
			
			while (nl.hasNext()){
				fqdn = nl.next();
				src = nl.next();
				key = fqdn + " " + src;
				System.out.printf("%d: %s\n", n, key);
				dht.lookup(key);
				n += 1;
			}
			//while (true){
				System.out.println(scanner.hasNextLine());
			//}
		}*/
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nextLine;
		while ((nextLine = br.readLine()) != null){
			//System.out.println("nextLine: " + nextLine);
			Scanner scanner = new Scanner(nextLine);
			fqdn = scanner.next();
			src = scanner.next();
			key = fqdn + " " + src;
			//System.out.printf("%d: %s\n", n, key);
			dht.lookup(key);

//			if (n >= 99) {
//				// System.out.println(scanner.hasNext()?scanner.next():"null");
//				while (scanner.hasNext()) {
//					System.out.println(scanner.next());
//				}
//			}

			n += 1;
			//System.out.println("has next line: " + br.)
		}
		dht.statistics();
	}
}
