package logomodel;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private Map<String, Integer> symbolTable = new HashMap<>();

    public void donne(String s, int n) {
        symbolTable.put(s, n);
    }
    
    public int getSymbol(String s){
    	return symbolTable.get(s);
    	
    }
    
    

}


