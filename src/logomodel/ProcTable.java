package logomodel;

import java.util.HashMap;
import java.util.Map;

public class ProcTable {
    private Map<String, Procedure> procTable = new HashMap<>();

    public void donne(String s, Procedure p) {
    	procTable.put(s, p);
    }
    
    public Procedure getSymbol(String s){
    	return procTable.get(s);
    	
    }

}
