package logomodel;

import java.util.HashMap;
import java.util.Map;

public class FoncTable {
    private Map<String, Fonction> foncTable = new HashMap<>();

    public void donne(String s, Fonction f) {
    	foncTable.put(s, f);
    }
    
    public Fonction getSymbol(String s){
    	return foncTable.get(s);
    	
    }

}
