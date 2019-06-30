package no.ssb.pg_tc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class ProcessCSVFile
{
	
	public static double toStdDouble(String nmbr) {
		String s1 = nmbr.replaceAll("[.]","");	
	    return Double.parseDouble(s1.replaceAll("[,]","."))	 ;
	}
	
	public static String toStdForm(String nmbr) {
		String s1 = nmbr.replaceAll("[.]","");	
	    return s1.replaceAll("[,]",".")	 ;
	}
	
	public void processTxt (String trStr) {
		
		MatchData trTxtMatcher = MatchData.trMatcher(trStr);
		// Process the different categories
		
		
	}
	
	
	
	public void processCSV(BufferedReader bR, BufferedWriter bW ) throws IOException {  
		//String inFnm = "/store/share/java/workspace/HelloWorld/src/FileIOTest.java" ;
		//String outFnm = "/store/share/java/workspace/HelloWorld/src/FileIOTest_o.java" ;

		try {

			// Always wrap FileReader in BufferedReader.
		//	BufferedReader bR = new BufferedReader(new FileReader(inFnm));
		//	BufferedWriter bW = new BufferedWriter(new FileWriter(outFnm));
			String line ;
			while((line = bR.readLine()) != null) {
				String[] tokens = line.split(";") ;
				String date = tokens[0] ;
 				String trStr = tokens[2] ;
 				
 				
 				processTxt(trStr) ;
 				double amt = toStdDouble(tokens[3]) ;
 				String amtStr = toStdForm(tokens[3]) ;
				System.out.println(line);
				System.out.println("Date: " + date + " Description: " + trStr + "  Amount " + amt);
				bW.write(date + ";"+trStr + ";" + amtStr);  bW.newLine();
			}   

			// Always close files.
			bR.close();     
			bW.close();
		} catch (Exception e) {
			e.printStackTrace() ;
		}finally {

		}
	}
	
	
	
	public void runApp() {
		
		System.out.println( "...In dynamically allocated App.runApp..." );
		
	}
	
    public static void main( String[] args )
    {   
    	App nApp = new App() ;
    	nApp.runApp();
    	
        System.out.println( "From static main: Hello, Brave New World!" );
    }
}

