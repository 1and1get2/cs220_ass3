public class DHT {
	
	private SimpleHT[] sHTs;
	private int upTo = 0;
	
	
	public DHT(int n) {
		sHTs = new SimpleHT[n];
		for (int i = 0; i < n; i++){
			sHTs[i] = new SimpleHT();
		}
	}
	Integer place(String key){
		return Integer.parseInt(key.substring(key.lastIndexOf('.') + 1)) % 8;
	}
	
	public void lookup(String key){
		
		sHTs[place(key)].lookup(key);
	}
	
	public void statistics(){
		System.out.println("Entries in the SimpleHTs:");
		for (int i = 0; i < sHTs.length; i++){
			//sHTs[i].dump();
			String str = ""+sHTs[i].size();
			//System.out.println(("     "+str).substring(str.length()-1,str.length()+5));
			System.out.println("ht  " + i + " =" + ("     "+str).substring(str.length()-1,str.length()+5) + 
					" entries");
		}
	}
}
