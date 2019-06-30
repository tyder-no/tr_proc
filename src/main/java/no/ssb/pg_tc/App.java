package no.ssb.pg_tc;

/**
 * Hello world!
 *
 */
public class App
{
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

