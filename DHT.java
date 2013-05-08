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
		for (int i = 0; i < sHTs.length; i++){
			//sHTs[i].dump();
			System.out.println("ht " + i + " = " + sHTs[i].size());
		}
	}
}
