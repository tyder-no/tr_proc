package no.ssb.pg_tc;

import org.junit.Test;



//import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.assertFalse;
import static org.junit.Assert.* ;

import java.io.* ;
//import java.io.FileReader;

/**
 * 
 * @author ta(y)d
 *
 */




public class MatchDataTest 
{
	
	public void rXtest_0(String inFnm)  {
		
			try {

				// Must set up pipe here; InputStream -> InputStreamReader -> Bufferedreader
				InputStream is =  getClass().getResourceAsStream(inFnm) ;
				BufferedReader bR = new BufferedReader(new InputStreamReader(is));
				String trStr;
				
				while((trStr = bR.readLine()) != null) {
					
					MatchData catMatch = MatchData.trMatcher(trStr) ;
			
					//System.out.println(junk);
					System.out.println(catMatch.getCurrAlt() + " 1: " + catMatch.getFirstM() +" 2: " + catMatch.getSecM()  );
					
				}   

				// Always close files.
				bR.close();     
			
			} catch (Exception e) { e.printStackTrace();

			}finally {

			}
		}
		
		
	@Test
	public void checkFunction() {
	   rXtest_0("/acc_filtered.csv");
	   assertFalse( false );
	}
	
	
	
    
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    @Test
    public void shouldAnswerWithFalse()
    {
        assertFalse( false );
    }
    
    
}
