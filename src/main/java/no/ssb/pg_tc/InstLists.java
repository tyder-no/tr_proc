package no.ssb.pg_tc;

/**
 * 
 * 
 * 
 * @author ta(y)d
 *
 */

//import java.io.*;
//import java.util.regex.*;  
//import java.util.Scanner; 
import java.util.HashMap ;
import java.util.ArrayList ;



public class InstLists 
{

	HashMap<String, ArrayList<String>> arkivet ;

	public InstLists() {
		arkivet = new HashMap<>();
	}

	public int insertEntry(String instN,String newRec) {
		if (arkivet.get(instN)==null) {
			ArrayList<String> arL = new ArrayList<String>() ;
			arL.add(newRec) ;
			arkivet.put(instN,arL) ;
			return 1 ;		
		} 
		else {
			ArrayList<String> arL = arkivet.get(instN) ;
			arL.add(newRec) ;
			return 0 ;
		} 
		
	}
	
    public ArrayList<String> retrieveList(String key) {
    	return arkivet.get(key) ;
    }

    public String retrieveListEntry(String key, int index) {
    	return arkivet.get(key).get(index) ;
    }

    
	
	public void runApp() {
		
		System.out.println( "...In dynamically allocated InstList.runApp..." );
		
	}
	
    public static void main( String[] args )
    {   
    	//App nApp = new App() ;
    	//nApp.runApp();
    	InstLists iL = new InstLists() ;
    	iL.runApp() ;
    	
        System.out.println( "From static InstLists.main: Hello, Brave New World!" );
    }
}

