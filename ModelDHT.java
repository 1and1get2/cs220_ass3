import java.util.Enumeration;
import java.io.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class ModelDHT {
	public static void main(String[] args) throws IOException {

		Integer nn = 8;
		DHT dht = new DHT(nn); // You must write this class!
		/*
		 * Scanner scanner = new Scanner(System.in); try { String fqdn, src,
		 * key; Integer count; int n = 0; do { fqdn = scanner.next(); src =
		 * scanner.next(); key = fqdn + " " + src; //
		 * System.out.printf("%d: %s\n", n, key); dht.lookup(key); n += 1; }
		 * while (true); // (n != 5); } catch (NoSuchElementException e) {
		 * dht.statistics(); }
		 */

		// while (scanner.hasNext()){
		// System.out.println(scanner.next());
		// }
		//
		String fqdn, src, key;
		Integer count;
		int n = 0;

		/*
		 * Scanner scanner = new Scanner(System.in); while
		 * (scanner.hasNextLine()) { String nextLine = scanner.nextLine();
		 * //System.out.println("nextLine: " + nextLine +
		 * nextLine.equals("\n")); Scanner nl = new Scanner(nextLine);
		 * 
		 * while (nl.hasNext()){ fqdn = nl.next(); src = nl.next(); key = fqdn +
		 * " " + src; System.out.printf("%d: %s\n", n, key); dht.lookup(key); n
		 * += 1; } //while (true){ System.out.println(scanner.hasNextLine());
		 * //} }
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nextLine;
		while ((nextLine = br.readLine()) != null) {
			// System.out.println("nextLine: " + nextLine);
			Scanner scanner = new Scanner(nextLine);
			fqdn = scanner.next();
			src = scanner.next();
			key = fqdn + " " + src;
			// System.out.printf("%d: %s\n", n, key);
			dht.lookup(key);

			// if (n >= 99) {
			// // System.out.println(scanner.hasNext()?scanner.next():"null");
			// while (scanner.hasNext()) {
			// System.out.println(scanner.next());
			// }
			// }

			n += 1;
			// System.out.println("has next line: " + br.)
		}
		dht.statistics();
	}
}

class DHT {

	private SimpleHT[] sHTs;
	private int upTo = 0;
	private HashMap<String, Integer> counterHT;

	public DHT(int n) {
		sHTs = new SimpleHT[n];
		counterHT = new HashMap<String, Integer>();
		for (int i = 0; i < n; i++) {
			sHTs[i] = new SimpleHT();
			// counterHT[i] = new Hashtable<String, Integer>();
		}
	}

	Integer place(String key) {
		return Integer.parseInt(key.substring(key.lastIndexOf('.') + 1)) % 8;
	}

	public void lookup(String key) {
		// counterHT[place(key)] = new Hashtable<"aa", 23>();
		if (counterHT.containsKey(key)) {
			counterHT.remove(key);
		}
		counterHT.put(key, sHTs[place(key)].lookup(key));
	}

	public void statistics() {
		int max = sHTs[0].size(), min = sHTs[0].size();

		System.out.println("Entries in the SimpleHTs:");
		for (int i = 0; i < sHTs.length; i++) {
			String str = "" + sHTs[i].size();
			if (max < sHTs[i].size())
				max = sHTs[i].size();
			if (min > sHTs[i].size())
				min = sHTs[i].size();
			// System.out.println(("     "+str).substring(str.length()-1,str.length()+5));
			System.out.println("ht  "
					+ i
					+ " ="
					+ ("     " + str).substring(str.length() - 1,
							str.length() + 5) + " entries");
		}

		// Enumeration<String> enumKey = counterHT.keys();
		// while(enumKey.hasMoreElements()) {
		// String key = enumKey.nextElement();
		// Integer val = counterHT.get(key);
		// if()
		// }

		Iterator it = counterHT.entrySet().iterator();
		Map.Entry hightestEntry = (Map.Entry) it.next();

		while (it.hasNext()) {
			Map.Entry me = (Map.Entry) it.next();
			if ((Integer) me.getValue() > (Integer) hightestEntry.getValue())
				hightestEntry = me;
			// System.out.println(/*me.getKey() + " " + */me.getValue());
		}
		// System.out.println("highest: " + hightestEntry.getKey() + ": " +
		// hightestEntry.getValue());
		System.out.println("key with highest count = " + hightestEntry.getKey());
		System.out.println(hightestEntry.getKey() + " appeared "
				+ hightestEntry.getValue() + " "
				+ ((Integer) hightestEntry.getValue() == 1 ? "time" : "times"));

		System.out.println("max ht size = " + max + ", min ht size = " + min);
		System.out.println("difference between max and min = " + (max - min));
	}
}

class SimpleHT {
	public Hashtable<String, Integer> ht;

	public SimpleHT() {
		ht = new Hashtable<String, Integer>();
	}

	public Integer lookup(String key) {
		Integer count = ht.get(key);
		if (count == null) { // Not there yet
			ht.put(key, 1);
			count = 1;
		} else {
			count += 1;
			ht.put(key, count); // Reset its value
		}
		return count;
	}

	public Integer size() {
		return ht.size();
	}

	public void dump() {
		Enumeration e = ht.keys();
		while (e.hasMoreElements()) {
			String key = e.nextElement().toString();
			System.out.printf("%d: %s\n", ht.get(key), key);
		}
	}
}
