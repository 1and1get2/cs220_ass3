import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class DHT {

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
